FROM openjdk:11

ADD ./target/userservice-0.0.1-SNAPSHOT.jar /event/src/userservice-0.0.1-SNAPSHOT.jar
EXPOSE 8999
WORKDIR event/src
ENTRYPOINT ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]