package com.umg.productos.service;

import com.umg.productos.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {
    List<ProductoDTO> findAll();
    ProductoDTO findById(Long id);
    List<ProductoDTO> findByNombre(String nombre);
    List<ProductoDTO> findByCategoria(String categoria);
    ProductoDTO create(ProductoDTO dto);
    ProductoDTO update(Long id, ProductoDTO dto);
    void delete(Long id);
}
