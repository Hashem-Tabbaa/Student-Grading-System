FROM openjdk:17-jdk-alpine
COPY ./target/AuthenticationService-0.0.1-SNAPSHOT.jar authenticationService.jar
ENTRYPOINT ["java","-jar","/authenticationService.jar"]
EXPOSE 8081
