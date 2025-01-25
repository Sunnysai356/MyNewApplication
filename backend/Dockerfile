# Use JDK 17 to build the application
FROM openjdk:17-slim as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw
RUN ./mvnw install -DskipTests

# Use JRE 17 for the runtime environment to reduce the image size (if available, otherwise use JDK)
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /workspace/app/target/backend-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
