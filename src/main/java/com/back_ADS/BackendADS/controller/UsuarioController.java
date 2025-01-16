package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.dto.UserDTO;
import com.back_ADS.BackendADS.entity.Usuario;
import com.back_ADS.BackendADS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para manejar las operaciones relacionadas con "Usuario"
@RestController
@RequestMapping(path="/api/usuarios")
public class UsuarioController {

    // Inyección del servicio de Usuario para manejar la lógica de negocio
    @Autowired
    private UsuarioService usuarioService;

    // Método para obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.findAll();
    }

    // Método para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);

        // Si el usuario se encuentra, retorna el usuario con un status HTTP 200, si no, retorna un 404
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);

        // Retorna el usuario creado con un status HTTP 201 (CREATED)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    // Método para actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario updatedUsuario = usuarioService.update(id, usuarioDetails);

        // Si el usuario fue encontrado y actualizado, retorna el usuario actualizado con un status HTTP 200, sino retorna un 404
        if (updatedUsuario != null) {
            return ResponseEntity.ok(updatedUsuario);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Método para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);

        // Retorna un status HTTP 204 (NO CONTENT) cuando el usuario ha sido eliminado exitosamente
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Método para realizar el login de un usuario
    @PostMapping("/login")
    public ResponseEntity<UserDTO> validate(@RequestParam String email, @RequestParam String password) {
        Optional<UserDTO> user = usuarioService.validateUser(email, password);

        // Si las credenciales son correctas, retorna un status HTTP 200 con el DTO del usuario, si no, se manejaría de otra forma
        return ResponseEntity.ok(user.get());
    }
}
