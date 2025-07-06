# Étape 1 : build avec Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : image finale avec JDK + app + wait-for-it
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
COPY wait-for-it.sh .
RUN chmod +x wait-for-it.sh
ENTRYPOINT ["sh", "-c", "./wait-for-it.sh mysql 3306 && java -jar app.jar"]
