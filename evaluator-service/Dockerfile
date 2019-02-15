FROM openjdk:11

ADD ./target/evaluator-0.0.1-SNAPSHOT.jar /event/src/evaluator-0.0.1-SNAPSHOT.jar
EXPOSE 8082
WORKDIR event/src
ENTRYPOINT ["java","-jar","evaluator-0.0.1-SNAPSHOT.jar"]