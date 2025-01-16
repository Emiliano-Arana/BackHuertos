package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.Producto;
import com.back_ADS.BackendADS.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para manejar las operaciones relacionadas con "Producto"
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Inyección del servicio de Producto para manejar la lógica de negocio
    @Autowired
    private ProductoService productoService;

    // Método para obtener todos los productos
    @GetMapping
    public List<Producto> getAll() {
        return productoService.findAll();
    }

    // Método para obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);

        // Si el producto se encuentra, retorna el producto con un status HTTP 200, si no, retorna un 404
        return productoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para obtener los productos por el nombre
    @GetMapping("/name/{nombre}")
    public List<Producto> getByName(@PathVariable String nombre) {
        return productoService.findByNombre(nombre);
    }

    // Método para crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        Producto savedProducto = productoService.save(producto);

        // Retorna el producto creado con un status HTTP 201 (CREATED)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    // Método para actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto updatedProducto = productoService.update(id, productoDetails);

        // Si el producto fue encontrado y actualizado, retorna el producto actualizado con un status HTTP 200, sino retorna un 404
        if (updatedProducto != null) {
            return ResponseEntity.ok(updatedProducto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Método para eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.delete(id);

        // Retorna un status HTTP 204 (NO CONTENT) cuando el producto ha sido eliminado exitosamente
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
