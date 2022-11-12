package com.BackEndRecibos.Modelo;

import javax.persistence.*;

@Entity(name = "EmpleadoDTOSimple")

@NamedNativeQuery(
        name  = "empleados_simple",
        query = "SELECT legajo, nombre, apellido FROM empleado",
        resultSetMapping = "empleados_simple_dto"
)
@SqlResultSetMapping(
        name = "empleados_simple_dto",
        classes = @ConstructorResult(
                targetClass =  EmpleadoDTOSimple.class,
                columns = {
                        @ColumnResult(name = "legajo", type = Integer.class),
                        @ColumnResult(name = "nombre", type = String.class),
                        @ColumnResult(name = "apellido", type = String.class)
                }
        )
)

public class EmpleadoDTOSimple {


    @Id
    private Integer legajo;

    private String nombre;

    private String apellido;

    public EmpleadoDTOSimple(Integer legajo, String nombre, String apellido) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
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
}
