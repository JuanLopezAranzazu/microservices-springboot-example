package com.juanlopezaranzazu.tasks_service.service;

import com.juanlopezaranzazu.tasks_service.dto.TaskRequest;
import com.juanlopezaranzazu.tasks_service.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    // obtener todas las tareas
    List<TaskResponse> getAllTasks();

    // obtener una tarea por su id
    TaskResponse getTaskById(Long id);

    // crear una tarea
    TaskResponse createTask(TaskRequest taskRequest);

    // editar una tarea por su id
    TaskResponse updateTask(Long id, TaskRequest taskRequest);

    // eliminar una tarea por su id
    void deleteTask(Long id);

    // obtener las tareas de un usuario
    List<TaskResponse> getTasksByUserId(Long userId);
}
