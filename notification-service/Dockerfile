FROM openjdk:11.0-jdk
ADD ./target/notification-service-0.0.1-SNAPSHOT.jar /event/src/notification-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java", "-jar", "notification-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8095
