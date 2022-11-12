package com.BackEndRecibos.Controlador;

import com.BackEndRecibos.Repositorio.ReciboRepository;
import com.BackEndRecibos.Repositorio.EmpleadoRepository;
import com.BackEndRecibos.Modelo.ReciboDTO;
import com.BackEndRecibos.Modelo.EmpleadoDTOSimple;
import com.BackEndRecibos.Modelo.EmpleadoDTO;
import com.BackEndRecibos.Modelo.ReciboNQ;
import com.BackEndRecibos.Modelo.Recibo;
import com.BackEndRecibos.Modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@RestController

public class Controlador {
    @Autowired
    private EmpleadoRepository empRep;

    @Autowired
    private ReciboRepository recRep;

    private static final DecimalFormat df = new DecimalFormat("#,###");

    @GetMapping(value = "/")
    public String holaMundo() {
        return "BackEnd ejecutandose correctamente, ingrese a los endpoints correspondientes :)";
    }

    @GetMapping(value = "/empleados")
    public ResponseEntity<ArrayList<EmpleadoDTO>> getEmpleados() {
        ArrayList<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();

        try {
            List<Empleado> empleados = empRep.findAll();

            for (Empleado e : empleados) {
                int legajo = e.getLegajo();
                String nombre = e.getNombre();
                String apellido = e.getApellido();
                String fecNac = e.fecNacFormat();
                String area = e.getArea();
                float sueldoBruto = e.getSueldoBruto();


                float antiguedad = e.getAntiguedad();
                EmpleadoDTO eDTO = new EmpleadoDTO(legajo, nombre, apellido, fecNac, antiguedad, area, sueldoBruto);

                empleadosDTO.add(eDTO);
            }

            return ResponseEntity.status(200).body(empleadosDTO);
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/empleado")
    public ResponseEntity<List<EmpleadoDTOSimple>> getEmpleado() {
        try {
            List<EmpleadoDTOSimple> dto = empRep.findEmpleadoDTOSimple();
            System.out.println(dto);
            return ResponseEntity.status(200).body(dto);
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping(value = "/hayempleado")
    public ResponseEntity<Boolean> getHayEmpleado(@RequestParam int legajo){
        try{
            Boolean result = empRep.existsById(legajo);

                return ResponseEntity.status(200).body(result);


        }catch (Exception ex){
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping(value = "/empleados")
    public ResponseEntity postEmpleado(@RequestBody Empleado e) {
        if (validarEmpleado(e) == false) {
            return ResponseEntity.status(400).body("Error al cargar empleado, verifique los datos ingresados");
        }

        try {
            empRep.save(e);
            return ResponseEntity.status(200).body("El empleado fue creado exitosamente");
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.status(400).body("Error al crear empleado");
        }
    }



    @PostMapping(value = "/recibos")
    public ResponseEntity postRecibo(@RequestBody Recibo r) {

        try {
            recRep.save(r);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado exitosamente el recibo");
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.status(400).body("Error al crear recibo");
        }
    }

    @GetMapping(value = "/recibos/{legajo}")
    public ResponseEntity<ArrayList<ReciboDTO>> recibosByEmpleado(@PathVariable int legajo) {
        ArrayList<ReciboDTO> recibosDTO = new ArrayList<ReciboDTO>();
        try {
            List<Recibo> recibos = recRep.findRecibos(legajo);

            for (Recibo r : recibos) {
                int id = r.getId();
                int ano = r.getAno();
                int mes = r.getMes();
                float sueldoBruto = r.getSueldoBruto();
                float montoAntiguedad = r.getMontoAntiguedad();
                float montoJubilacion = r.getMontoJubilacion();
                float montoObraSocial = r.getMontoObraSocial();
                float montoFAC = r.getMontoFAC();
                float sueldoNeto = (r.getSueldoBruto() + r.getMontoAntiguedad()) - r.getMontoJubilacion() - r.getMontoObraSocial() - r.getMontoFAC();
                int legajoEmpleado = r.getEmpleado().getLegajo();

                ReciboDTO rDTO = new ReciboDTO(id, ano, mes, sueldoBruto, montoAntiguedad, montoJubilacion, montoObraSocial, montoFAC, sueldoNeto, legajoEmpleado);
                recibosDTO.add(rDTO);
            }
            return ResponseEntity.status(200).body(recibosDTO);
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/reciboReporte")
    public ResponseEntity<List<ReciboNQ>> recibosPorArea(@RequestParam int ano, @RequestParam int mes) {
        try {
            List<ReciboNQ> recibos = recRep.findRecibs(ano, mes);
            System.out.println(recibos.toString());
            return ResponseEntity.status(200).body(recibos);

        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }

    public boolean validarEmpleado(Empleado e) {
        if (e.getLegajo() == 0) {
            return false;
        }
        if(empRep.existsById(e.getLegajo())){
            return false;
        }
        if (e.getNombre().isEmpty()) {
            return false;
        }
        if (e.getApellido().isEmpty()) {
            return false;
        }
        if (e.getFechaNacimiento() == null) {
            return false;
        }

        if (e.getFechaIngreso() == null) {
            return false;
        }
        if (e.getArea().isEmpty()) {
            return false;
        }
        if (e.getSueldoBruto() == 0) {
            return false;
        }
        return true;
    }
}
