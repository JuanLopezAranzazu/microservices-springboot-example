package com.juanlopezaranzazu.users_service.config;

import com.juanlopezaranzazu.users_service.entity.Role;
import com.juanlopezaranzazu.users_service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    // crear los roles por defecto usuario y administrador
    @Override
    public void run(String... args) {
        createRoleIfNotExists("ROLE_ADMIN");
        createRoleIfNotExists("ROLE_USER");
    }

    private void createRoleIfNotExists(String roleName) {
        if (!roleRepository.existsByName(roleName)) {
            // crear nuevo rol
            Role newRole = new Role();
            newRole.setName(roleName);
            // guardar el rol
            roleRepository.save(newRole);
            System.out.println("Rol " + roleName + " creado.");
        }
    }
}