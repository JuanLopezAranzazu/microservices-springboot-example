package com.juanlopezaranzazu.tasks_service.client;

import com.juanlopezaranzazu.tasks_service.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-service", url = "http://localhost:8081/api/users")
public interface UserClient {
    // obtener un usuario por su id
    @GetMapping("/{id}")
    UserResponse getUserById(@PathVariable Long id);
}
