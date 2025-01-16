package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.Producto;
import com.back_ADS.BackendADS.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de servicio para manejar la lógica de negocio relacionada con "Producto"
@Service
public class ProductoService {

    // Inyección del repositorio de Producto para interactuar con la base de datos
    @Autowired
    private ProductoRepository productoRepository;

    // Método para obtener todos los registros de "Producto"
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // Método para obtener un registro de "Producto" por su ID
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    // Método para obtener productos por su nombre
    public List<Producto> findByNombre(String nombre) {
        return productoRepository.findByName(nombre);
    }

    // Método para guardar un nuevo registro de "Producto"
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    // Método para actualizar un registro de "Producto" por su ID
    public Producto update(Long id, Producto productoDetails) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();

            // Actualiza el nombre del "Producto"
            producto.setName(productoDetails.getName());
            return productoRepository.save(producto);
        }
        // Si el producto no existe, devuelve null
        return null;
    }

    // Método para eliminar un registro de "Producto" por su ID
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
