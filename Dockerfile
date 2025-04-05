FROM openjdk:21-jdk-slim
WORKDIR /app
COPY COPY target/*SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
