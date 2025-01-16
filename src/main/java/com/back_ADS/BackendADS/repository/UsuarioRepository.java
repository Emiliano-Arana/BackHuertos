package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Interfaz de repositorio para la entidad "Usuario", que extiende de JpaRepository
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para encontrar un usuario por su dirección de correo electrónico
    Optional<Usuario> findByEmail(String email);
}
