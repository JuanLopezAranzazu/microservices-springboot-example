package com.juanlopezaranzazu.users_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName; // nombre

    @Column(name = "last_name", nullable = false)
    private String lastName; // apellido

    @Column(nullable = false, unique = true)
    private String username; // nombre de usuario

    // relacion muchos a 1 con roles
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role; // rol del usuario
}
