package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.repository.HuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de servicio para manejar la lógica de negocio relacionada con "Huerto"
@Service
public class HuertoService {

    // Inyección del repositorio de Huerto para interactuar con la base de datos
    @Autowired
    private HuertoRepository huertoRepository;

    // Método para obtener todos los registros de "Huerto"
    public List<Huerto> findAll() {
        return huertoRepository.findAll();
    }

    // Método para obtener un registro de "Huerto" por su ID
    public Optional<Huerto> findById(Long id) {
        return huertoRepository.findById(id);
    }

    // Método para obtener todos los huertos asociados a un usuario, dado su ID
    public List<Huerto> findByUserId(Long idUser) {
        return huertoRepository.findByUsuarioIdUser(idUser);
    }

    // Método para obtener todos los huertos que contienen productos con un nombre específico
    public List<Huerto> findByProductName(String name) {
        return huertoRepository.findByHuertoProductosProductoName(name);
    }

    // Método para guardar un nuevo registro de "Huerto"
    public Huerto save(Huerto huerto) {
        return huertoRepository.save(huerto);
    }

    // Método para actualizar un registro de "Huerto" por su ID
    public Huerto update(Long id, Huerto huertoDetails) {
        Optional<Huerto> optionalHuerto = huertoRepository.findById(id);
        if (optionalHuerto.isPresent()) {
            Huerto huerto = optionalHuerto.get();

            // Actualiza los detalles del "Huerto"
            huerto.setName(huertoDetails.getName());
            huerto.setLatitude(huertoDetails.getLatitude());
            huerto.setLongitude(huertoDetails.getLongitude());
            huerto.setDescription(huertoDetails.getDescription());
            return huertoRepository.save(huerto);
        }
        // Si el huerto no existe, devuelve null
        return null;
    }

    // Método para eliminar un registro de "Huerto" por su ID
    public void delete(Long id) {
        huertoRepository.deleteById(id);
    }
}
