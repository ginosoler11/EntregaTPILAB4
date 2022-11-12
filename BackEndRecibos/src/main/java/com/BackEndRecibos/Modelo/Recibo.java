package com.BackEndRecibos.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "recibo")
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int ano;
    @Column
    private int mes;
    @Column
    private float sueldoBruto;
    @Column
    private float montoAntiguedad;
    @Column
    private float montoJubilacion;
    @Column
    private float montoObraSocial;
    @Column
    private float montoFAC;
    @ManyToOne
    @JoinColumn(name = "legajoEmpleado")
    private Empleado legajoEmpleado;

    public Empleado getEmpleado() {
        return legajoEmpleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.legajoEmpleado = empleado;
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

    public void setAño(int ano) {
        this.ano = ano;
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
}
