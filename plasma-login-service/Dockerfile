FROM openjdk:11

ADD ./target/plasma-0.0.1-SNAPSHOT.jar /event/src/plasma-0.0.1-SNAPSHOT.jar
EXPOSE 8132
WORKDIR event/src
ENTRYPOINT ["java","-jar","plasma-0.0.1-SNAPSHOT.jar"]