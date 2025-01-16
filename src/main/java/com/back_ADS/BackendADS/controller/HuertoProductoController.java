package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.HuertoProducto;
import com.back_ADS.BackendADS.entity.Producto;
import com.back_ADS.BackendADS.service.HuertoProductoService;
import com.back_ADS.BackendADS.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para manejar las operaciones relacionadas con "HuertoProducto"
@RestController
@RequestMapping("/api/huerto-productos")
public class HuertoProductoController {

    // Inyección del servicio de HuertoProducto para manejar la lógica de negocio
    @Autowired
    private HuertoProductoService huertoProductoService;

    // Método para obtener todos los huerto-productos
    @GetMapping
    public List<HuertoProducto> getAll() {
        return huertoProductoService.findAll();
    }

    // Método para obtener un huerto-producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<HuertoProducto> getById(@PathVariable Long id) {
        Optional<HuertoProducto> huertoProductoOpt = huertoProductoService.findById(id);

        // Si el huerto-producto se encuentra, retorna el huerto-producto con un status HTTP 200, si no, retorna un 404
        return huertoProductoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para obtener los huerto-productos por el ID del huerto
    @GetMapping("/garden/{idGarden}")
    public List<HuertoProducto> getByGardenId(@PathVariable Long idGarden) {
        return huertoProductoService.findByIdGarden(idGarden);
    }

    // Método para obtener los huerto-productos por el nombre del producto
    @GetMapping("/product/{productName}")
    public List<HuertoProducto> getByProductName(@PathVariable String productName) {
        return huertoProductoService.findByProductName(productName);
    }

    // Método para crear un nuevo huerto-producto
    @PostMapping
    public ResponseEntity<HuertoProducto> create(@RequestBody HuertoProducto huertoProducto) {
        HuertoProducto savedHuertoProducto = huertoProductoService.save(huertoProducto);

        // Retorna el huerto-producto creado con un status HTTP 201 (CREATED)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHuertoProducto);
    }

    // Método para actualizar un huerto-producto existente
    @PutMapping("/{id}")
    public ResponseEntity<HuertoProducto> update(@PathVariable Long id, @RequestBody HuertoProducto huertoProductoDetails) {
        HuertoProducto updatedHuertoProducto = huertoProductoService.update(id, huertoProductoDetails);

        // Si el huerto-producto fue encontrado y actualizado, retorna el huerto-producto actualizado con un status HTTP 200, sino retorna un 404
        if (updatedHuertoProducto != null) {
            return ResponseEntity.ok(updatedHuertoProducto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Método para eliminar un huerto-producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        huertoProductoService.delete(id);

        // Retorna un status HTTP 204 (NO CONTENT) cuando el huerto-producto ha sido eliminado exitosamente
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
