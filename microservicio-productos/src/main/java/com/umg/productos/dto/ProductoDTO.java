package com.umg.productos.dto;

import java.math.BigDecimal;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String categoria;

    public ProductoDTO() {}

    public ProductoDTO(Long id, String nombre, BigDecimal precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
