package com.juanlopezaranzazu.users_service.repository;

import com.juanlopezaranzazu.users_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // existe por nombre
    boolean existsByName(String name);
}
