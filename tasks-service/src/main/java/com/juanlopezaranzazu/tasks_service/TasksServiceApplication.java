package com.juanlopezaranzazu.tasks_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TasksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksServiceApplication.class, args);
		System.out.println("Servicio de tareas");
	}

}
