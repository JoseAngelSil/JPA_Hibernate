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
public class BusquedaRegistro {
    public static void main(String[] args) {
        EntityManager em = JPAUtils.getEntityManager();
        
        em.getTransaction().begin();
        Categoria categoria =  em.find(Categoria.class, 1); // selecciona la fila de valor 1 de pk
        categoria.setNombre("Vestidos"); // modifica con el setNombre
        em.getTransaction().commit(); // se confirma para que se vea reflejado en la base de datps
    }
}
