package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Interfaz de repositorio para la entidad "Producto", que extiende de JpaRepository
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Método para encontrar productos por su nombre
    List<Producto> findByName(String name);
}
