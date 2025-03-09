package com.juanlopezaranzazu.tasks_service.dto;

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
public class TaskRequest {
    @NotBlank(message = "El titulo de la tarea es obligatorio")
    private String title;

    @NotBlank(message = "La descripcion de la tarea es obligatorio")
    private String description;

    @NotNull(message = "El usuario es obligatorio")
    private Long userId; // referencia al usuario
}
