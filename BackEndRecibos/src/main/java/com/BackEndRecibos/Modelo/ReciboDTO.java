package com.BackEndRecibos.Modelo;


public class ReciboDTO {

    private int id;

    private int ano;

    private int mes;

    private float sueldoBruto;

    private float montoAntiguedad;

    private float montoJubilacion;

    private float montoObraSocial;

    private float montoFAC;

    private float sueldoNeto;

    private int legajoEmpleado;

    public ReciboDTO(int id, int ano, int mes, float sueldoBruto, float montoAntiguedad, float montoJubilacion, float montoObraSocial, float montoFAC, float sueldoNeto, int legajoEmpleado) {
        this.id = id;
        this.ano = ano;
        this.mes = mes;
        this.sueldoBruto = sueldoBruto;
        this.montoAntiguedad = montoAntiguedad;
        this.montoJubilacion = montoJubilacion;
        this.montoObraSocial = montoObraSocial;
        this.montoFAC = montoFAC;
        this.sueldoNeto = sueldoNeto;
        this.legajoEmpleado = legajoEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int año) {
        this.ano = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public float getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(float sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public float getMontoAntiguedad() {
        return montoAntiguedad;
    }

    public void setMontoAntiguedad(float montoAntiguedad) {
        this.montoAntiguedad = montoAntiguedad;
    }

    public float getMontoJubilacion() {
        return montoJubilacion;
    }

    public void setMontoJubilacion(float montoJubilacion) {
        this.montoJubilacion = montoJubilacion;
    }

    public float getMontoObraSocial() {
        return montoObraSocial;
    }

    public void setMontoObraSocial(float montoObraSocial) {
        this.montoObraSocial = montoObraSocial;
    }

    public float getMontoFAC() {
        return montoFAC;
    }

    public void setMontoFAC(float montoFAC) {
        this.montoFAC = montoFAC;
    }

    public float getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(float sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public int getLegajoEmpleado() {
        return legajoEmpleado;
    }

    public void setEmpleado(int legajoEmpleado) {
        this.legajoEmpleado = legajoEmpleado;
    }
}
