# Use the official Maven image as the build environment
FROM maven:3.8.3-openjdk-17-slim AS build

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml and all source code to the container
COPY pom.xml .
COPY src/ ./src/

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use the official OpenJDK 17 image as the runtime environment
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the built JAR file from the build environment to the runtime environment
COPY --from=build /app/target/ace-service-api-1.0.0-SNAPSHOT.jar ./ace-service-api-1.0.0-SNAPSHOT.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "ace-service-api-1.0.0-SNAPSHOT.jar"]
