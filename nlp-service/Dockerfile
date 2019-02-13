FROM openjdk:11

ADD ./target/nlp-service-0.0.1-SNAPSHOT.jar /event/src/nlp-service-0.0.1-SNAPSHOT.jar
EXPOSE 8098
WORKDIR event/src
ENTRYPOINT ["java","-jar","nlp-service-0.0.1-SNAPSHOT.jar"]