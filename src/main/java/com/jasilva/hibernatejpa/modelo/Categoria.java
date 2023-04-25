/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jasilva.hibernatejpa.modelo;

import javax.persistence.*;

/**
 *
 * @author Jose Angel Silva
 */
@Entity
@Table(name = "categorias")
public class Categoria {
    @EmbeddedId
    private CategoraID categoryID;
    public Categoria() {
    }


    public Categoria(String nombre) {
        this.categoryID = new CategoraID(nombre,"456    ");
    }
    


    public String getNombre() {
        return this.categoryID.getNombre();
    }

    public void setNombre(String nombre) {
        this.categoryID.setNombre(nombre);
    }

    
    
    
}
