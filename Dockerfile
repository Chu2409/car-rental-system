# Usa la imagen oficial de OpenJDK 21
FROM eclipse-temurin:21-jdk-jammy

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo jar y el .env
COPY target/*.jar app.jar
COPY .env .env

# Puerto que expone la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]