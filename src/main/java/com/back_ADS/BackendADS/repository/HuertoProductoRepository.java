package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.entity.HuertoProducto;
import com.back_ADS.BackendADS.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Interfaz de repositorio para la entidad "HuertoProducto", que extiende de JpaRepository
@Repository
public interface HuertoProductoRepository extends JpaRepository<HuertoProducto, Long> {

    // Método para encontrar los productos de un huerto dado su identificador
    List<HuertoProducto> findByHuertoIdGarden(Long idGarden);

    // Método para encontrar los productos por nombre
    List<HuertoProducto> findByProductoName(String productName);
}
