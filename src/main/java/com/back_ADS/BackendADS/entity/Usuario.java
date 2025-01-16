package com.back_ADS.BackendADS.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

// Definición de la entidad "Usuario", que mapea la tabla "user" en la base de datos
@Entity
@Table(name = "user")
public class Usuario {

    // Identificador único para cada usuario, generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    // Email del usuario, debe ser único y no puede ser nulo
    @Column(unique = true, nullable = false)
    private String email;

    // Nombre del usuario, no puede ser nulo
    @Column(nullable = false)
    private String name;

    // Apellido del usuario, no puede ser nulo
    @Column(nullable = false)
    private String lastName;

    // Contraseña del usuario, no puede ser nula
    @Column(nullable = false)
    private String password;

    // Rol del usuario, puede ser nulo (por ejemplo, admin, usuario, etc.)
    @Column
    private String role;

    // Relación uno a muchos con la entidad "Huerto", se maneja de forma en cascada
    @JsonManagedReference // Se utiliza para evitar la referencia cíclica en JSON durante la serialización
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Huerto> huertos;

    // Getter y setter para el rol del usuario
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Getter y setter para el identificador del usuario
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    // Getter y setter para el email del usuario
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y setter para el nombre del usuario
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y setter para el apellido del usuario
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter y setter para la contraseña del usuario
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter y setter para la lista de huertos asociados al usuario
    public List<Huerto> getHuertos() {
        return huertos;
    }

    public void setHuertos(List<Huerto> huertos) {
        this.huertos = huertos;
    }
}
