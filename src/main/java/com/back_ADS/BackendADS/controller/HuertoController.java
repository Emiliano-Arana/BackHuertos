package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.service.HuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para manejar las operaciones relacionadas con "Huerto"
@RestController
@RequestMapping("/api/huertos")
public class HuertoController {

    // Inyección del servicio de Huerto para manejar la lógica de negocio
    @Autowired
    private HuertoService huertoService;

    // Método para obtener todos los huertos
    @GetMapping
    public List<Huerto> getAll() {
        return huertoService.findAll();
    }

    // Método para obtener un huerto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Huerto> getById(@PathVariable Long id) {
        Optional<Huerto> huertoOpt = huertoService.findById(id);

        // Si el huerto se encuentra, retorna el huerto con un status HTTP 200, si no, retorna un 404
        return huertoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para obtener los huertos de un usuario dado su ID
    @GetMapping("/user/{idUser}")
    public List<Huerto> getByUserId(@PathVariable Long idUser) {
        return huertoService.findByUserId(idUser);
    }

    // Método para crear un nuevo huerto
    @PostMapping
    public ResponseEntity<Huerto> create(@RequestBody Huerto huerto) {
        Huerto savedHuerto = huertoService.save(huerto);

        // Retorna el huerto creado con un status HTTP 201 (CREATED)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHuerto);
    }

    // Método para actualizar un huerto existente
    @PutMapping("/{id}")
    public ResponseEntity<Huerto> update(@PathVariable Long id, @RequestBody Huerto huertoDetails) {
        Huerto updatedHuerto = huertoService.update(id, huertoDetails);

        // Si el huerto fue encontrado y actualizado, retorna el huerto actualizado con un status HTTP 200, sino retorna un 404
        if (updatedHuerto != null) {
            return ResponseEntity.ok(updatedHuerto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Método para eliminar un huerto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        huertoService.delete(id);

        // Retorna un status HTTP 204 (NO CONTENT) cuando el huerto ha sido eliminado exitosamente
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
