package com.back_ADS.BackendADS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * Entidad que representa un huerto en la base de datos.
 * Contiene información sobre la ubicación, descripción y relaciones con otras entidades.
 */
@Entity
@Table(name = "garden")
public class Huerto {
    // Identificador único del huerto (clave primaria).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGarden;

    //Nombre del huerto. Este campo es obligatorio.
    @Column(nullable = false)
    private String name;

    //Latitud de la ubicación del huerto. Este campo es obligatorio.
    @Column(nullable = false)
    private double latitude;

    //Longitud de la ubicación del huerto. Este campo es obligatorio.
    @Column(nullable = false)
    private double longitude;

    //Descripción del huerto. Este campo es obligatorio.
    @Column(nullable = false)
    private String description;

     //Relación con la entidad Usuario. Un huerto pertenece a un usuario.
     //Utiliza @JsonBackReference para evitar bucles infinitos en la serialización JSON
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idUser", nullable = false)
    private Usuario usuario;
     //Relación con la entidad HuertoProducto. Un huerto puede tener varios productos asociados.
     //Utiliza @JsonManagedReference para manejar la serialización JSON de la lista de productos
    @JsonManagedReference
    @OneToMany(mappedBy = "huerto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HuertoProducto> huertoProductos;

    // Getters y setters

    /**
     * Obtiene el identificador del huerto.
     * @return idGarden
     */
    public Long getIdGarden() {
        return idGarden;
    }

    /**
     * Establece el identificador del huerto.
     * @param idGarden Identificador del huerto
     */
    public void setIdGarden(Long idGarden) {
        this.idGarden = idGarden;
    }

    /**
     * Obtiene el nombre del huerto.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del huerto.
     * @param name Nombre del huerto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la latitud del huerto.
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Establece la latitud del huerto.
     * @param latitude Latitud del huerto
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Obtiene la longitud del huerto.
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Establece la longitud del huerto.
     * @param longitude Longitud del huerto
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Obtiene la descripción del huerto.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del huerto.
     * @param description Descripción del huerto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el usuario propietario del huerto.
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario propietario del huerto.
     * @param usuario Usuario propietario del huerto
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de productos asociados al huerto.
     * @return huertoProductos
     */
    public List<HuertoProducto> getHuertoProductos() {
        return huertoProductos;
    }

    /**
     * Establece la lista de productos asociados al huerto.
     * @param huertoProductos Lista de productos del huerto
     */
    public void setHuertoProductos(List<HuertoProducto> huertoProductos) {
        this.huertoProductos = huertoProductos;
    }
}
