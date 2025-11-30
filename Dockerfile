# Build stage
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build -x test

# Runtime stage
FROM openjdk:17-slim
WORKDIR /app

# Copy the built JAR
COPY --from=builder /app/build/libs/*.jar app.jar

# Cloud Run sets PORT environment variable
ENV PORT=8080
EXPOSE 8080

# Use environment variable for port
CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]