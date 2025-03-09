package com.juanlopezaranzazu.tasks_service.repository;

import com.juanlopezaranzazu.tasks_service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // obtener las tareas por usuario
    List<Task> findByUserId(Long userId);
}
