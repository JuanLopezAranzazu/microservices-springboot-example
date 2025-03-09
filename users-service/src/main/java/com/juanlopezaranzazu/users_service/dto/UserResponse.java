package com.juanlopezaranzazu.users_service.dto;

import com.juanlopezaranzazu.users_service.entity.User;
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

    // mostrar los datos del usuario
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getRole().getName()
        );
    }
}
