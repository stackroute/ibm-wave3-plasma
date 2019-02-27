FROM openjdk:11

ADD ./target/knowledge-indexer-service-0.0.1-SNAPSHOT.jar /event/src/knowledge-indexer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8097
WORKDIR event/src
ENTRYPOINT ["java","-jar","knowledge-indexer-service-0.0.1-SNAPSHOT.jar"]
