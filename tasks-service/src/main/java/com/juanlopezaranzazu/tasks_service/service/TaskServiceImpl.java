package com.juanlopezaranzazu.tasks_service.service;

import com.juanlopezaranzazu.tasks_service.client.UserClient;
import com.juanlopezaranzazu.tasks_service.dto.TaskRequest;
import com.juanlopezaranzazu.tasks_service.dto.TaskResponse;
import com.juanlopezaranzazu.tasks_service.dto.UserResponse;
import com.juanlopezaranzazu.tasks_service.entity.Task;
import com.juanlopezaranzazu.tasks_service.exception.NotFoundException;
import com.juanlopezaranzazu.tasks_service.repository.TaskRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserClient userClient; // servicio de usuarios

    // obtener todas las tareas
    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(task -> TaskResponse.fromEntity(task))
                .collect(Collectors.toList());
    }

    // obtener una tarea por su id
    @Override
    public TaskResponse getTaskById(Long id) {
        // verificar si la tarea existe
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tarea con ID " + id + " no encontrada"));

        return TaskResponse.fromEntity(task);
    }

    // crear una tarea
    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        // verificar si el usuario existe
        UserResponse userResponse;
        try {
            userResponse = userClient.getUserById(taskRequest.getUserId());
        } catch (FeignException e) {
            throw new NotFoundException("Usuario no encontrado");
        }

        // crear una tarea
        Task newTask = new Task();
        newTask.setTitle(taskRequest.getTitle());
        newTask.setDescription(taskRequest.getDescription());
        newTask.setUserId(userResponse.getId());
        // guardar la tarea
        taskRepository.save(newTask);

        return TaskResponse.fromEntity(newTask);
    }

    // editar una tarea por su id
    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        // verificar si la tarea existe
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tarea con ID " + id + " no encontrada"));

        // verificar si el usuario existe
        UserResponse userResponse;
        try {
            userResponse = userClient.getUserById(taskRequest.getUserId());
        } catch (FeignException e) {
            throw new NotFoundException("Usuario no encontrado");
        }

        // editar la tarea
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setUserId(userResponse.getId());
        // guardar la tarea
        Task updatedTask = taskRepository.save(task);

        return TaskResponse.fromEntity(updatedTask);
    }

    // eliminar una tarea por su id
    @Override
    public void deleteTask(Long id) {
        // verificar si la tarea existe
        if (!taskRepository.existsById(id)) {
            throw new NotFoundException("Tarea con ID " + id + " no encontrada");
        }
        taskRepository.deleteById(id);
    }

    // obtener las tareas de un usuario
    @Override
    public List<TaskResponse> getTasksByUserId(Long userId) {
        // verificar si el usuario existe
        UserResponse userResponse;
        try {
            userResponse = userClient.getUserById(userId);
        } catch (FeignException e) {
            throw new NotFoundException("Usuario no encontrado");
        }

        return taskRepository.findByUserId(userResponse.getId()).stream()
                .map(task -> TaskResponse.fromEntity(task))
                .collect(Collectors.toList());
    }
}
