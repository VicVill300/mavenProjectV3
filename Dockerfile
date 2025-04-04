# Use official OpenJDK image
FROM openjdk:17-slim

# Set working directory inside the container
WORKDIR /app

# Copy the compiled JAR from Maven build
COPY target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
