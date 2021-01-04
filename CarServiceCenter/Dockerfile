FROM openjdk:8-jdk-alpine
COPY target/CarServiceCenter-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "CarServiceCenter-0.0.1-SNAPSHOT.jar"]