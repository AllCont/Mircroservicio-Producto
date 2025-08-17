package com.umg.productos.controller;

import com.umg.productos.dto.ProductoDTO;
import com.umg.productos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listar(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "categoria", required = false) String categoria
    ) {
        if (nombre != null && !nombre.isBlank()) {
            return ResponseEntity.ok(service.findByNombre(nombre));
        }
        if (categoria != null && !categoria.isBlank()) {
            return ResponseEntity.ok(service.findByCategoria(categoria));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtener(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@Valid @RequestBody ProductoDTO dto) {
        ProductoDTO creado = service.create(dto);
        return ResponseEntity.created(URI.create("/api/productos/" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable("id") Long id,
                                                  @Valid @RequestBody ProductoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
