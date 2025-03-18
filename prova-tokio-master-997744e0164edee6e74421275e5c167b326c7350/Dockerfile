FROM maven:3.8.4-openjdk-11 as build

COPY api-java/src /app/src
COPY api-java/pom.xml /app

WORKDIR /app
RUN mvn clean install -X
FROM openjdk:8-jre-alpine
COPY --from=build /app/target/spring-boot-2-hello-world-1.0.2-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java","-jar", "app.jar"]