package com.jasilva.hibernatejpa.dao;

import com.jasilva.hibernatejpa.modelo.Pedido;
import com.jasilva.hibernatejpa.vo.RelatorioVenta;

import javax.persistence.EntityManager;
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
        String jpql = "SELECT p from Pedido p";
        return em.createQuery(jpql,Pedido.class).getResultList();
    }
    public Double valorTotalVendido(){
        String jpql = "select sum(p.valor_total) from Pedido p ";
        return em.createQuery(jpql, Double.class).getSingleResult();
    }
    public Double valorPromedioVendido(){
        String jpql = "select avg(p.valor_promedio) from Pedido p";
        return em.createQuery(jpql, Double.class).getSingleResult();
    }

    public List<RelatorioVenta> rolatorioVentaVO(){
        String jpql = "select new com.jasilva.hibernatejpa.vo.RelatorioVenta(producto.nombre, " +
                "sum(item.cantidad), " +
                "max(pedido.fechaRegistro)) " +
                "from Pedido pedido " +
                "join pedido.productos item " +
                "Join item.producto producto " +
                "group by producto.nombre " +
                "order by item.cantidad DESC";
        return em.createQuery(jpql,RelatorioVenta.class).getResultList();
    }
}

