package com.umg.productos.service.impl;

import com.umg.productos.dto.ProductoDTO;
import com.umg.productos.dto.ProductoMapper;
import com.umg.productos.entity.Producto;
import com.umg.productos.exception.NotFoundException;
import com.umg.productos.repository.ProductoRepository;
import com.umg.productos.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;

    public ProductoServiceImpl(ProductoRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findAll() {
        return repo.findAll().stream().map(ProductoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO findById(Long id) {
        Optional<Producto> op = repo.findById(id); // Uso de Optional para evitar NPE
        Producto p = op.orElseThrow(() -> new NotFoundException("Producto no encontrado: " + id));
        return ProductoMapper.toDTO(p);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findByNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre).stream().map(ProductoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findByCategoria(String categoria) {
        return repo.findByCategoriaIgnoreCase(categoria).stream().map(ProductoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductoDTO create(ProductoDTO dto) {
        try {
            Producto p = ProductoMapper.toEntity(dto);
            Producto saved = repo.save(p);
            return ProductoMapper.toDTO(saved);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO dto) {
        Producto p = repo.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado: " + id));
        ProductoMapper.copyToEntity(dto, p);
        return ProductoMapper.toDTO(repo.save(p));
    }

    @Override
    public void delete(Long id) {
        Producto p = repo.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado: " + id));
        repo.delete(p);
    }
}
