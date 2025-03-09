package com.juanlopezaranzazu.users_service.service;

import com.juanlopezaranzazu.users_service.dto.UserRequest;
import com.juanlopezaranzazu.users_service.dto.UserResponse;

import java.util.List;

public interface UserService {
    // obtener todos los usuarios
    List<UserResponse> getAllUsers();

    // obtener un usuario por su id
    UserResponse getUserById(Long id);

    // crear un usuario
    UserResponse createUser(UserRequest userRequest);

    // editar un usuario por su id
    UserResponse updateUser(Long id, UserRequest userRequest);

    // eliminar un usuario por su id
    void deleteUser(Long id);

    // obtener usuario por nombre de usuario
    UserResponse getUserByUsername(String username);
}
