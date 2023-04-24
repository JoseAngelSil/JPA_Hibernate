package com.jasilva.hibernatejpa.test;

import com.jasilva.hibernatejpa.dao.ClienteDAO;
import com.jasilva.hibernatejpa.dao.PedidoDAO;
import com.jasilva.hibernatejpa.dao.ProductoDao;
import com.jasilva.hibernatejpa.modelo.Cliente;
import com.jasilva.hibernatejpa.modelo.ItemPedido;
import com.jasilva.hibernatejpa.modelo.Pedido;
import com.jasilva.hibernatejpa.modelo.Productos;
import com.jasilva.hibernatejpa.utils.JPAUtils;

import javax.persistence.EntityManager;

public class RelacionBidireccional {
    public static void main(String[] args) {
        // Registro de pedido
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Productos producto = productoDao.consultaID(1);
        Cliente cliente1 = new Cliente("Jose Angel Silva", "2023-JS-QA");

        Pedido pedido = new Pedido(cliente1);
        pedido.agregarItemPedido(new ItemPedido((short) 4, producto, pedido));
        // inicio de transaccion a la tabla de pedidos
        em.getTransaction().begin();
        clienteDAO.guardar(cliente1);
        pedidoDAO.guardar(pedido);
        em.getTransaction().commit();
        em.close();
    }
}
