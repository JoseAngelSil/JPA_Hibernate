/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jasilva.hibernatejpa.test;

import com.jasilva.hibernatejpa.modelo.Categoria;
import com.jasilva.hibernatejpa.utils.JPAUtils;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Angel Silva
 */
public class UpdateRegistro {

    public static void main(String[] args) {
        Categoria libro = new Categoria("Celular");
        EntityManager em = JPAUtils.getEntityManager();

        em.getTransaction().begin();
    
        em.persist(libro);
        libro.setNombre("Telefonia");
        em.flush();
        em.clear();
        
        libro = em.merge(libro);
        libro.setNombre("telefonos");
        em.flush();
    }
}
