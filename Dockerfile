# Base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application code from the build context to the container
COPY . /app

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Define the command to run your application
CMD ["./mvnw", "spring-boot:run"]
