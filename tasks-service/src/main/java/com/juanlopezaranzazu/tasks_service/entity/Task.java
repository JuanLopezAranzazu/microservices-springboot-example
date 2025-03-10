package com.juanlopezaranzazu.tasks_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // titulo

    @Column(nullable = false)
    private String description; // descripcion

    @Column(name = "user_id", nullable = false)
    private Long userId; // referencia al usuario
}
