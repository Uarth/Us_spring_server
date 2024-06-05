FROM openjdk:17-alpine as builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY src src
RUN chmod +x gradlew
RUN ./gradlew build

FROM openjdk:17-alpine
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]