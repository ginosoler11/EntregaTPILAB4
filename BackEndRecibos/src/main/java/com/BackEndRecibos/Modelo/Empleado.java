package com.BackEndRecibos.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    private int legajo;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Date fechaNacimiento;
    @Column
    private Date fechaIngreso;
    @Column
    private String area;
    @Column
    private float sueldoBruto;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(float sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getAntiguedad(){
        Date ahora = new Date();
        long diffInMillies = Math.abs(ahora.getTime() - this.getFechaIngreso().getTime());
        float antiguedad = (TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)) / (float) 365;
        float f = roundFloat(antiguedad, 2);
        return f;
    }

    private static float roundFloat(float f, int places) {

        BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }

    public String fecNacFormat(){
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(this.fechaNacimiento);
    }
}
