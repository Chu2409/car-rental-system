FROM eclipse-temurin:21-jdk-jammy 
COPY target/*.jar app.jar
COPY .env .env
ENTRYPOINT [ "java", "-jar", "app.jar" ]