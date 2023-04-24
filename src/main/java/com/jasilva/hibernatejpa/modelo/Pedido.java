package com.jasilva.hibernatejpa.modelo;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private  LocalDate fechaRegistro = LocalDate.now();
    private double valor_total = 0.0;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<ItemPedido> productos = new ArrayList<>();
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    public void agregarItemPedido(ItemPedido item){
        item.setPedido(this);
        this.productos.add(item);
        this.valor_total  =  item.getCantidad() * Double.valueOf(item.getPrecio());
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }
}
