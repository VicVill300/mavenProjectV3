FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/mavenprojectV2withmathUtils-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
