package com.juanlopezaranzazu.users_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotBlank(message = "El nombre del usuario es obligatorio")
    private String firstName; // nombre

    @NotBlank(message = "El apellido del usuario es obligatorio")
    private String lastName; // apellido

    @NotBlank(message = "El nombre de usuario del usuario es obligatorio")
    private String username; // nombre de usuario

    @NotNull(message = "El rol del usuario es obligatorio")
    private Long roleId; // rol del usuario
}
