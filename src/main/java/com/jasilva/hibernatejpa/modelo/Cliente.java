package com.jasilva.hibernatejpa.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Embedded // la clase esta siendo inyectada a esta clase cliente
    private DatosPersonales datosPersonales;

    public Cliente() {
    }

    public Cliente(String nombre, String dni) {
        this.datosPersonales = new DatosPersonales();
        this.datosPersonales.setNombre(nombre);
        this.datosPersonales.setDni(dni);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return this.datosPersonales.getNombre();
    }

    public String getDni() {
        return this.datosPersonales.getDni();
    }

    public void setNombre(String nombre) {
        this.datosPersonales.setNombre(nombre);
    }

    public void setDni(String dni) {
        this.datosPersonales.setDni(dni);
    }
}
