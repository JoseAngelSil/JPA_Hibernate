package com.jasilva.hibernatejpa.modelo;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "items_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private short cantidad;
    private Double precio;
    @ManyToOne(fetch = FetchType.LAZY)
    private Productos producto;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    public ItemPedido() {
    }

    public ItemPedido(short cantidad, Productos producto, Pedido pedido) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.pedido = pedido;
        this.precio = Double.valueOf(producto.getPrecio());
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
