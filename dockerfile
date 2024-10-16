FROM openjdk:23-oracle
COPY ./target/Security-Microservice-0.0.1-SNAPSHOT.jar security-microservices.jar
CMD ["java","-jar","security-microservices.jar"]