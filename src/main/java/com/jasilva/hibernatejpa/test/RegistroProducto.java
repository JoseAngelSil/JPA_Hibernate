/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jasilva.hibernatejpa.test;

import com.jasilva.hibernatejpa.dao.CategoriaDAO;
import com.jasilva.hibernatejpa.dao.ProductoDao;
import com.jasilva.hibernatejpa.modelo.Categoria;
import com.jasilva.hibernatejpa.modelo.Productos;
import com.jasilva.hibernatejpa.utils.JPAUtils;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Angel Silva
 */
public class RegistroProducto {

    public static void main(String[] args) {
        /*
        creacion de un producto de la clase mapeada de la tabla productos en DB tienda
         */
        Categoria cel = new Categoria("Celulares");
        Productos producto = new Productos("Celular huawei","Huawei psmart 2019",78.5, cel);
        // Creacion de las concenciones de persistence.xms
        EntityManager em = JPAUtils.getEntityManager();
        
        ProductoDao prodDao = new ProductoDao(em);
        CategoriaDAO catDao = new CategoriaDAO(em);
        
        em.getTransaction().begin();
        catDao.guardarCategoria(cel);
        prodDao.guardar(producto);
        em.getTransaction().commit();
        em.close();
    }
}
