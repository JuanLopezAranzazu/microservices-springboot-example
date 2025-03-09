# Microservicios Spring Boot

Este proyecto es un ejemplo de cómo conectar microservicios utilizando Spring Cloud y API Gateway.

## Cargar Dependencias y Ejecutar Aplicaciones Spring Boot

Para cargar las dependencias y ejecutar las aplicaciones Spring Boot, sigue estos pasos:

1. **Cargar Dependencias**:
  Ejecuta el siguiente comando en la raíz del proyecto para cargar todas las dependencias necesarias:
  ```bash
  ./mvnw clean install
  ```

2. **Ejecutar Aplicaciones**:
  Navega a cada uno de los directorios de los microservicios y ejecuta el siguiente comando para iniciar cada aplicación:
  ```bash
  ./mvnw spring-boot:run
  ```

  Alternativamente, puedes empaquetar las aplicaciones y ejecutarlas como archivos JAR:
  ```bash
  ./mvnw clean package
  java -jar target/nombre-del-archivo.jar
  ```
