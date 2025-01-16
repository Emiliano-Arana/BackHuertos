package com.back_ADS.BackendADS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Entidad que representa la relación entre un huerto y los productos asociados a este.
 * Contiene información sobre el producto, la cantidad disponible (stock) y la relación con la entidad Huerto.
 */
@Entity
@Table(name="garden_product")
public class HuertoProducto {

    /**
     * Identificador único de la relación entre huerto y producto (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGardenProduct;

    /**
     * Relación con la entidad Huerto. Un producto está asociado a un único huerto.
     * Utiliza @JsonBackReference para evitar problemas de serialización cíclica en JSON.
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idGarden", nullable = false)
    private Huerto huerto;

    /**
     * Relación con la entidad Producto. Representa el producto asociado al huerto.
     */
    @ManyToOne
    @JoinColumn(name="idProduct")
    private Producto producto;

    /**
     * Cantidad disponible del producto en el huerto. Este campo es obligatorio.
     */
    @Column(nullable = false)
    private Integer stock;

    // Getters y setters

    /**
     * Obtiene el identificador de la relación huerto-producto.
     * @return idGardenProduct
     */
    public Long getIdGardenProduct() {
        return idGardenProduct;
    }

    /**
     * Establece el identificador de la relación huerto-producto.
     * @param idGardenProduct Identificador de la relación
     */
    public void setIdGardenProduct(Long idGardenProduct) {
        this.idGardenProduct = idGardenProduct;
    }

    /**
     * Obtiene el huerto asociado al producto.
     * @return huerto
     */
    public Huerto getHuerto() {
        return huerto;
    }

    /**
     * Establece el huerto asociado al producto.
     * @param huerto Huerto asociado
     */
    public void setHuerto(Huerto huerto) {
        this.huerto = huerto;
    }

    /**
     * Obtiene el producto asociado al huerto.
     * @return producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado al huerto.
     * @param producto Producto asociado
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la cantidad disponible del producto en el huerto.
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Establece la cantidad disponible del producto en el huerto.
     * @param stock Cantidad disponible
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
