package com.back_ADS.BackendADS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 * Entidad que representa un producto en la base de datos.
 * Contiene información sobre el nombre del producto y su relación con huertos.
 */
@Entity
@Table(name="Product")
public class Producto {

    /**
     * Identificador único del producto (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    /**
     * Nombre del producto. Este campo es obligatorio.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Relación con la entidad HuertoProducto. Representa la lista de huertos donde está asociado este producto.
     * Utiliza @JsonIgnore para evitar problemas de serialización JSON y optimizar las respuestas.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HuertoProducto> huertoProductos;

    // Getters y setters

    /**
     * Obtiene el identificador del producto.
     * @return idProduct
     */
    public Long getIdProduct() {
        return idProduct;
    }

    /**
     * Establece el identificador del producto.
     * @param idProduct Identificador del producto
     */
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Obtiene el nombre del producto.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del producto.
     * @param name Nombre del producto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la lista de asociaciones con huertos.
     * @return Lista de huertoProductos
     */
    public List<HuertoProducto> getHuertoProductos() {
        return huertoProductos;
    }

    /**
     * Establece la lista de asociaciones con huertos.
     * @param huertoProductos Lista de huertoProductos
     */
    public void setHuertoProductos(List<HuertoProducto> huertoProductos) {
        this.huertoProductos = huertoProductos;
    }
}
