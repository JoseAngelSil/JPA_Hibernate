package com.jasilva.hibernatejpa.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "electronicos")
public class Electronico extends Productos{
    private String marca;
    private String modelo;

    public Electronico() {
    }

    public Electronico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Electronico(String nombre, String descripcion, double precio, Categoria categoria, String marca, String modelo) {
        super(nombre, descripcion, precio, categoria);
        this.marca = marca;
        this.modelo = modelo;
    }

    public Electronico(String nombre, String descripcion, double precio, String marca, String modelo) {
        super(nombre, descripcion, precio);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
