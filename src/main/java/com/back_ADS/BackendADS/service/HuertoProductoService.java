package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.HuertoProducto;
import com.back_ADS.BackendADS.repository.HuertoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de servicio para manejar la lógica de negocio relacionada con "HuertoProducto"
@Service
public class HuertoProductoService {

    // Inyección del repositorio de HuertoProducto para interactuar con la base de datos
    @Autowired
    private HuertoProductoRepository huertoProductoRepository;

    // Método para obtener todos los registros de "HuertoProducto"
    public List<HuertoProducto> findAll() {
        return huertoProductoRepository.findAll();
    }

    // Método para obtener un registro de "HuertoProducto" por su ID
    public Optional<HuertoProducto> findById(Long id) {
        return huertoProductoRepository.findById(id);
    }

    // Método para obtener todos los "HuertoProducto" asociados a un huerto específico, dado su ID
    public List<HuertoProducto> findByIdGarden(Long idGarden) {
        return huertoProductoRepository.findByHuertoIdGarden(idGarden);
    }

    // Método para obtener todos los "HuertoProducto" que contienen un producto con un nombre específico
    public List<HuertoProducto> findByProductName(String productName) {
        return huertoProductoRepository.findByProductoName(productName);
    }

    // Método para guardar un nuevo registro de "HuertoProducto"
    public HuertoProducto save(HuertoProducto huertoProducto) {
        return huertoProductoRepository.save(huertoProducto);
    }

    // Método para actualizar un registro de "HuertoProducto" por su ID
    public HuertoProducto update(Long id, HuertoProducto huertoProductoDetails) {
        Optional<HuertoProducto> optionalHuertoProducto = huertoProductoRepository.findById(id);
        if (optionalHuertoProducto.isPresent()) {
            HuertoProducto huertoProducto = optionalHuertoProducto.get();

            // Actualiza el stock del "HuertoProducto"
            huertoProducto.setStock(huertoProductoDetails.getStock());
            return huertoProductoRepository.save(huertoProducto);
        }
        // Si el producto no existe, devuelve null
        return null;
    }

    // Método para eliminar un registro de "HuertoProducto" por su ID
    public void delete(Long id) {
        huertoProductoRepository.deleteById(id);
    }
}
