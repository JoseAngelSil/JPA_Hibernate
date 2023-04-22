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
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Angel Silva
 */
public class ConsultaEntidad {

    public static void main(String[] args) {

        RegistrarProducto();
        /*
        este proceso se consulta un dato de la base de datos
         */
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao prodDao = new ProductoDao(em);
        Productos consultProducto = prodDao.consultaID(1);
        System.out.println(consultProducto.getNombre());
        // selecciona todos los productos de la tabla productos
        List<Productos> listProduc = prodDao.consultarTodos();
        listProduc.forEach(prod -> System.out.printf("ID: %d,"
                + "Nombre: %s,"
                + "Descripcion: %s,"
                + "Categoria: %s \n", prod.getId(), prod.getNombre(), prod.getDescripcion(), prod.getCategoria().getNombre()));
        
        

    }

    private static void RegistrarProducto() {
        Categoria cel = new Categoria("Telefonia");
        Productos producto = new Productos("Celular huawei", "Huawei 4S", 1000.62, cel);
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
