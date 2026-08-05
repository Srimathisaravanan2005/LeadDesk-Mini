FROM openjdk:21-slim

WORKDIR /app

# Copy the Spring Boot JAR into the container
COPY ./target/demo*.jar app.jar

# Expose the application port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
