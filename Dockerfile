# Giai đoạn 1: Build ứng dụng
FROM maven:3.9.0-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Giai đoạn 2: Chạy ứng dụng với OpenJDK
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/demo-github-actions-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar -Dspring.datasource.url=$SPRING_DATASOURCE_URL app.jar"]