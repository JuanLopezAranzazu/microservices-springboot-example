package com.juanlopezaranzazu.users_service.repository;

import com.juanlopezaranzazu.users_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // existe por nombre de usuario
    boolean existsByUsername(String username);

    // existe por nombre de usuario y no por id
    boolean existsByUsernameAndIdNot(String username, Long id);

    // obtener usuario por nombre de usuario
    Optional<User> findByUsername(String username);
}
