package com.BackEndRecibos.Modelo;

public class EmpleadoDTO {


    private int legajo;

    private String nombre;

    private String apellido;

    private String fechaNacimiento;

    private float antiguedad;

    private String area;

    private float sueldoBruto;

    public EmpleadoDTO(int legajo, String nombre, String apellido, String fechaNacimiento, float antiguedad, String area, float sueldoBruto) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.antiguedad = antiguedad;
        this.area = area;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(float antiguedad) {
        this.antiguedad = antiguedad;
    }

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
}



