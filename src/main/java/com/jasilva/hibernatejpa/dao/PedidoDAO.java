package com.jasilva.hibernatejpa.dao;

import com.jasilva.hibernatejpa.modelo.Pedido;
import com.jasilva.hibernatejpa.modelo.Productos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PedidoDAO {
    final private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public void actualizar(Pedido pedido) {
        this.em.merge(pedido);
    }

    public void remover(Pedido pedido) {
        pedido = this.em.merge(pedido);
        this.em.remove(pedido);
    }

    public Pedido consultaID(Integer id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> consultarTodos() {
        // JPQL
        String jpql = "SELECT * from pedidos";
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }

    public List<Pedido> consultaPorNombre(String nombre) {
        String jpql = "SELECT * from pedido where nombre = '" + nombre + "'";
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }

    public List<Pedido> consultaPorCategoria(int idCategoria) {
        String jpql = "SELECT * from pedidos where categoria_id = " + idCategoria;
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }
}

