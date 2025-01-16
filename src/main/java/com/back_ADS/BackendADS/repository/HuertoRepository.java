package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Interfaz de repositorio para la entidad "Huerto", que extiende de JpaRepository
@Repository
public interface HuertoRepository extends JpaRepository<Huerto, Long> {

    // Método para encontrar huertos por el ID del usuario propietario
    List<Huerto> findByUsuarioIdUser(Long idUser);

    // Método para encontrar huertos que contienen productos con un nombre específico
    List<Huerto> findByHuertoProductosProductoName(String name);
}
