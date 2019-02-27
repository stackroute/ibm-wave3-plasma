FROM openjdk:11

ADD ./target/knowledge-query-service-0.0.1-SNAPSHOT.jar /event/src/knowledge-query-service-0.0.1-SNAPSHOT.jar
EXPOSE 8086
WORKDIR event/src
ENTRYPOINT ["java","-jar","knowledge-query-service-0.0.1-SNAPSHOT.jar"]
