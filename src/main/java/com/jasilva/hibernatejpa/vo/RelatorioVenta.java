package com.jasilva.hibernatejpa.vo;

import java.time.LocalDate;

public class RelatorioVenta {
    private String nombreProducto;
    private Long cantidadDeProducto;
    private LocalDate fechaUltimaVenta;
    public RelatorioVenta(String nombreProducto, Long cantidadDeProducto, LocalDate fechaUltimaVenta) {
        this.nombreProducto = nombreProducto;
        this.cantidadDeProducto = cantidadDeProducto;
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getCantidadDeProducto() {
        return cantidadDeProducto;
    }

    public void setCantidadDeProducto(Long cantidadDeProducto) {
        this.cantidadDeProducto = cantidadDeProducto;
    }

    public LocalDate getFechaUltimaVenta() {
        return fechaUltimaVenta;
    }

    public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    @Override
    public String toString() {
        return String.format("Nombre de Producto : %s,\n " +
                "Cantidad: %d,\n " +
                "Ultima venta: %s\n",
                this.nombreProducto,
                this.cantidadDeProducto,
                String.valueOf(this.fechaUltimaVenta));
    }
}
