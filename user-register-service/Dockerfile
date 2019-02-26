FROM openjdk:11.0-jdk
ADD ./target/user-register-service-0.0.1-SNAPSHOT.jar /event/src/user-register-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java", "-jar", "user-register-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8089