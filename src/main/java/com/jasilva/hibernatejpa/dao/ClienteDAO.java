package com.jasilva.hibernatejpa.dao;

import com.jasilva.hibernatejpa.modelo.Cliente;
import com.jasilva.hibernatejpa.modelo.Pedido;
import com.jasilva.hibernatejpa.modelo.Productos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO {
    final private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public void actualizar(Cliente cliente) {
        this.em.merge(cliente);
    }

    public void remover(Cliente cliente) {
        cliente = this.em.merge(cliente);
        this.em.remove(cliente);
    }

    public Pedido consultaID(Integer id) {
        return em.find(Pedido.class, id);
    }

    public List<Cliente> consultarTodos() {
        // JPQL
        String jpql = "SELECT * from clientes";
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }

    public List<Pedido> consultaPorNombre(String nombre) {
        String jpql = "SELECT * from clientes where nombre = '" + nombre + "'";
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }

}
