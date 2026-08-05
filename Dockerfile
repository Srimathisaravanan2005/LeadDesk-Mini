# ---------- Build Stage ----------
FROM maven:3.9.11-eclipse-temurin-27 AS builder

WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM openjdk:27-ea-21-slim-trixie

WORKDIR /app

COPY --from=builder /app/target/demo*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
