FROM openjdk:11.0-jdk
ADD ./target/userservice-0.0.1-SNAPSHOT.jar /event/src/userservice-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java", "-jar", "userservice-0.0.1-SNAPSHOT.jar"]
EXPOSE 8089