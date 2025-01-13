# FROM eclipse-temurin:21-jdk-alpine AS build
# WORKDIR /workspace/app

# COPY mvnw .
# COPY .mvn .mvn 
# COPY pom.xml .
# COPY src src

# RUN chmod +x mvnw
# RUN ./mvnw clean package -DskipTests

# FROM eclipse-temurin:21-jre-alpine
# WORKDIR /app
# # Cambiamos .jar por .war en la copia
# COPY --from=build /workspace/app/target/*.jar app.jar

# EXPOSE 8080
# # Cambiamos .jar por .war en el ENTRYPOINT
# ENTRYPOINT ["java", "-jar", "/app.jar"]

# Dockerfile
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn 
COPY pom.xml .
COPY src src
# COPY .env .

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
COPY --from=build /workspace/app/target/*.jar app.jar
EXPOSE 8080
# COPY --from=build /workspace/app/.env .env
ENTRYPOINT ["java","-jar","/app.jar"]