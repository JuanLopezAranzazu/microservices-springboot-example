package com.juanlopezaranzazu.users_service.service;

import com.juanlopezaranzazu.users_service.dto.UserRequest;
import com.juanlopezaranzazu.users_service.dto.UserResponse;
import com.juanlopezaranzazu.users_service.entity.Role;
import com.juanlopezaranzazu.users_service.entity.User;
import com.juanlopezaranzazu.users_service.exception.BadRequestException;
import com.juanlopezaranzazu.users_service.exception.NotFoundException;
import com.juanlopezaranzazu.users_service.repository.RoleRepository;
import com.juanlopezaranzazu.users_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // obtener todos los usuarios
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> UserResponse.fromEntity(user))
                .collect(Collectors.toList());
    }

    // obtener un usuario por su id
    @Override
    public UserResponse getUserById(Long id) {
        // verificar si el usuario existe
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con ID " + id + " no encontrado"));

        return UserResponse.fromEntity(user);
    }

    // crear un usuario
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // verificar si el rol existe
        Long roleId = userRequest.getRoleId();
        String username = userRequest.getUsername();

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Rol con ID " + roleId + " no encontrado"));

        // verificar si existe el nombre de usuario
        if (userRepository.existsByUsername(username)){
            throw new BadRequestException("Ya existe el usuario " + username);
        }

        // crear un usuario
        User newUser = new User();
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setLastName(userRequest.getLastName());
        newUser.setUsername(username);
        newUser.setRole(role);
        // guardar el usuario
        userRepository.save(newUser);

        return UserResponse.fromEntity(newUser);
    }

    // editar un usuario por su id
    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        // verificar si el usuario existe
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con ID " + id + " no encontrado"));

        // verificar si el rol existe
        Long roleId = userRequest.getRoleId();
        String username = userRequest.getUsername();

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Rol con ID " + roleId + " no encontrado"));

        // verificar si existe el nombre de usuario
        if (!user.getUsername().equals(username) && userRepository.existsByUsernameAndIdNot(username, id)) {
            throw new BadRequestException("Ya existe el usuario " + username);
        }

        // editar usuario
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUsername(username);
        user.setRole(role);
        // guardar el usuario
        User updatedUser = userRepository.save(user);

        return UserResponse.fromEntity(updatedUser);
    }

    // eliminar un usuario por su id
    @Override
    public void deleteUser(Long id) {
        // verificar si el usuario existe
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("Usuario con ID " + id + " no encontrado");
        }
        userRepository.deleteById(id);
    }

    // obtener usuario por nombre de usuario
    @Override
    public UserResponse getUserByUsername(String username) {
        // verificar si el usuario existe por nombre de usuario
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException("El nombre de usuario " + username + " no existe"));

        return UserResponse.fromEntity(user);
    }
}
