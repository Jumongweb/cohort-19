FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17

ARG DATABASE_HOST
ARG DATABASE_USER
ARG DATABASE_PASSWORD

ENV DATABASE_HOST=${DATABASE_HOST}
ENV DATABASE_USER=${DATABASE_USER}
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}

COPY --from=build target/*.jar UserApp.jar

ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "UserApp.jar"]
