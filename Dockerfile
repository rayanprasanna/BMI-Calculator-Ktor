# Build stage
FROM gradle:9.2.1-jdk17-corretto AS builder
WORKDIR /app
COPY . .
RUN gradle build -x test

# Runtime stage
FROM openjdk:26-ea-oraclelinux8
WORKDIR /app

# Copy the built JAR
COPY --from=builder /app/build/libs/bmi-calculator-all.jar app.jar

# Cloud Run sets PORT environment variable
ENV PORT=8080
EXPOSE 8080

# Use environment variable for port
CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]