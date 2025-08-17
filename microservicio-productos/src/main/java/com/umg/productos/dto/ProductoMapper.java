package com.umg.productos.dto;

import com.umg.productos.entity.Producto;

public class ProductoMapper {
    public static ProductoDTO toDTO(Producto p) {
        if (p == null) return null;
        return new ProductoDTO(p.getId(), p.getNombre(), p.getPrecio(), p.getCategoria());
    }

    public static Producto toEntity(ProductoDTO dto) {
        if (dto == null) return null;
        return new Producto(dto.getId(), dto.getNombre(), dto.getPrecio(), dto.getCategoria());
    }

    public static void copyToEntity(ProductoDTO dto, Producto entity) {
        if (dto.getNombre() != null) entity.setNombre(dto.getNombre());
        if (dto.getPrecio() != null) entity.setPrecio(dto.getPrecio());
        if (dto.getCategoria() != null) entity.setCategoria(dto.getCategoria());
    }
}
