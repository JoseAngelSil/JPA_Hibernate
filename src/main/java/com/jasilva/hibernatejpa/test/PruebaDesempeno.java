package com.jasilva.hibernatejpa.test;

import com.jasilva.hibernatejpa.dao.PedidoDAO;
import com.jasilva.hibernatejpa.dao.ProductoDao;
import com.jasilva.hibernatejpa.modelo.Pedido;
import com.jasilva.hibernatejpa.modelo.Productos;
import com.jasilva.hibernatejpa.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class PruebaDesempeno {
    public static void main(String[] args) {

        EntityManager em = JPAUtils.getEntityManager();

        PedidoDAO pedido = new PedidoDAO(em);
        ProductoDao prod = new ProductoDao(em);
        Pedido pedidoCliente = pedido.consultarPedidoCliente(1);
        LocalDate fechaHoy =  LocalDate.now();
        var productos = prod.consultaPorParametros(null,null, fechaHoy);
        var productos2 = prod.consultaDinamicaCriteria(null,null, null);
        em.close();

        System.out.println(pedidoCliente.getCliente().getNombre());
        for (Productos pro:
             productos) {
            System.out.println(pro.getNombre() + " - " + pro.getDescripcion());
        }
        System.out.println("--------------------------------");
        for (Productos pro: productos2) {
            System.out.println(pro.getNombre() + " - " + pro.getDescripcion());
        }
    }
}
