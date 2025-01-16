package com.back_ADS.BackendADS.dto;

// Clase DTO (Data Transfer Object) para representar los datos de un usuario de forma simplificada
public class UserDTO {
    // Atributo para almacenar el identificador único del usuario
    private Long id;

    // Atributo para almacenar el nombre del usuario
    private String name;

    // Atributo para almacenar el rol del usuario (Ej. ADMIN, USER)
    private String role;

    // Constructor que inicializa los atributos de la clase
    // Este constructor es usado para crear un objeto UserDTO con valores específicos
    public UserDTO(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getter para el id del usuario
    public Long getId() {
        return id;
    }

    // Setter para el id del usuario
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el nombre del usuario
    public String getName() {
        return name;
    }

    // Setter para el nombre del usuario
    public void setName(String name) {
        this.name = name;
    }

    // Getter para el rol del usuario
    public String getRole() {
        return role;
    }

    // Setter para el rol del usuario
    public void setRole(String role) {
        this.role = role;
    }
}
