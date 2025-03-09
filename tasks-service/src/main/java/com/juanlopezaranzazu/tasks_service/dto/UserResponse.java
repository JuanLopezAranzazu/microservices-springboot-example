package com.juanlopezaranzazu.tasks_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String firstName; // nombre
    private String lastName; // apellido
    private String username; // nombre de usuario
    private String roleName; // nombre del rol
}