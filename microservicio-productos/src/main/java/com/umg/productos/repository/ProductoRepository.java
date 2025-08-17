package com.umg.productos.repository;

import com.umg.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByCategoriaIgnoreCase(String categoria);
}
