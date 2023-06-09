/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jasilva.hibernatejpa.modelo;

import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author Jose Angel Silva
 */
@Entity
@Table(name = "productos")
@NamedQuery(name = "Producto.consultaPrecio", query = "SELECT p.precio from Productos as p where p.nombre =:nombre")
@Inheritance(strategy = InheritanceType.JOINED) // herencia de tabla como una sola tabla
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private LocalDate fechaRegistro = LocalDate.now();
    //@Enumerated(EnumType.STRING) // el enum lo combierte en string y no el valor pocicional
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    public Productos() {
    }
    
    

    public Productos(String nombre, String descripcion, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Productos(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    
}
