package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.dto.UserDTO;
import com.back_ADS.BackendADS.entity.Usuario;
import com.back_ADS.BackendADS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de servicio para manejar la lógica de negocio relacionada con "Usuario"
@Service
public class UsuarioService {

    // Inyección del repositorio de Usuario para interactuar con la base de datos
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para validar un usuario mediante su correo electrónico y contraseña
    public Optional<UserDTO> validateUser(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        // Si el usuario con el correo existe y la contraseña es correcta, retorna un UserDTO
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (password.equals(usuario.getPassword())) {
                return Optional.of(new UserDTO(
                        usuario.getIdUser(),
                        usuario.getName(),
                        usuario.getRole()
                ));
            }
        }
        // Si no existe el usuario o la contraseña es incorrecta, retorna un Optional vacío
        return Optional.empty();
    }

    // Método para obtener todos los registros de "Usuario"
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Método para obtener un registro de "Usuario" por su ID
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método para obtener un usuario por su correo electrónico
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Método para guardar un nuevo registro de "Usuario"
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para actualizar un registro de "Usuario" por su ID
    public Usuario update(Long id, Usuario usuarioDetails) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();

            // Actualiza los detalles del "Usuario"
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setName(usuarioDetails.getName());
            usuario.setLastName(usuarioDetails.getLastName());
            usuario.setPassword(usuarioDetails.getPassword());
            return usuarioRepository.save(usuario);
        }
        // Si el usuario no existe, devuelve null
        return null;
    }

    // Método para eliminar un registro de "Usuario" por su ID
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
