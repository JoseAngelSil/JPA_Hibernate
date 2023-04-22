/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jasilva.hibernatejpa.dao;

import com.jasilva.hibernatejpa.modelo.Categoria;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Angel Silva
 */
public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardarCategoria(Categoria categoria){
        this.em.persist(categoria);
    }
    
    public void actualizarCategoria(Categoria categoria){
        this.em.merge(categoria);
    }
    
    public void elemeninarCategoria(Categoria categoria){
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }
}
