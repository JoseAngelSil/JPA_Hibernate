package com.jasilva.hibernatejpa.dao;

import com.jasilva.hibernatejpa.modelo.Productos;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


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

    // consultas con parametros dinamicos
    public List<Productos> consultaPorParametros(String nombre, Double precio, LocalDate fecha){
        StringBuilder jpql =new StringBuilder("select p from Productos p where  1=1 ");
        if(nombre != null && !nombre.trim().isEmpty())
            jpql.append("and p.nombre =:nombre ");
        if(precio != null && !precio.equals(0))
            jpql.append("and p.precio =:precio ");
        if(fecha != null)
            jpql.append("and p.fechaRegistro =:fecha ");
        TypedQuery<Productos> query = em.createQuery(jpql.toString(), Productos.class);
        if(nombre != null && !nombre.trim().isEmpty())
            query.setParameter("nombre", nombre);
        if(precio != null && !precio.equals(0))
            query.setParameter("precio", precio);
        if(fecha != null)
            query.setParameter("fecha", fecha);

        return query.getResultList();
    }
    //consulta por parametros dinamicos con API Criteria
    public List<Productos> consultaDinamicaCriteria(String nombre, Double precio, LocalDate fecha){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Productos> query = builder.createQuery(Productos.class);
        Root<Productos> from = query.from(Productos.class);

        Predicate predicate = builder.and();

        if(nombre != null && !nombre.trim().isEmpty())
            predicate = builder.and(predicate,builder.equal(from.get("nombre"),nombre));
        if(precio != null && !precio.equals(0))
            predicate = builder.and(predicate,builder.equal(from.get("precio"),precio));
        if(fecha != null)
            predicate = builder.and(predicate,builder.equal(from.get("fechaRegistro"),fecha));

        query = query.where(predicate);
        return em.createQuery(query).getResultList();
    }
}
