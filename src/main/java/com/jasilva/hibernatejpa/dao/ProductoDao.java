package com.jasilva.hibernatejpa.dao;

import com.jasilva.hibernatejpa.modelo.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.hibernate.criterion.Expression.sql;

/**
 *
 * @author Jose Angel Silva
 */
public class ProductoDao {

    private EntityManager em;

    public ProductoDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Productos producto) {
        this.em.persist(producto);
    }
    public void actualizar(Productos producto) {
        this.em.merge(producto);
    }
    public void remover(Productos producto){
        producto = this.em.merge(producto);
        this.em.remove(producto);
    }

    public Productos consultaID(Integer id) {
        return em.find(Productos.class, id);
    }

    public List<Productos> consultarTodos(){
        // JPQL 
        String jpql = "SELECT * from productos";
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }
    
    public List<Productos> consultaPorNombre(String nombre){
        String jpql = "SELECT * from productos where nombre = '" + nombre + "'";
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }
    public List<Productos> consultaPorCategoria(int idCategoria){
        String jpql = "SELECT * from productos where categoria_id = " + idCategoria ;
        Query query = em.createNativeQuery(jpql, Productos.class);
        return query.getResultList();
    }

    public Double consultarPrecioProducto(String nombre){
        return em.createNamedQuery("Producto.consultaPrecio", Double.class).setParameter("nombre", nombre).getSingleResult();
    }
}
