FROM openjdk:16-alpine

WORKDIR /micro
COPY target/micro-0.1-SNAPSHOT.jar /micro
EXPOSE 8080
CMD ["java", "-jar", "/micro/micro-0.1-SNAPSHOT.jar"]