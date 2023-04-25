package com.jasilva.hibernatejpa.test;

import com.jasilva.hibernatejpa.dao.PedidoDAO;
import com.jasilva.hibernatejpa.modelo.Pedido;
import com.jasilva.hibernatejpa.utils.JPAUtils;

import javax.persistence.EntityManager;

public class PruebaDesempeno {
    public static void main(String[] args) {

        EntityManager em = JPAUtils.getEntityManager();

        PedidoDAO pedido = new PedidoDAO(em);
        Pedido pedidoCliente = pedido.consultarPedidoCliente(1);
        em.close();

        System.out.println(pedidoCliente.getCliente().getNombre());
    }
}
