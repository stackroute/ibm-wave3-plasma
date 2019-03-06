FROM openjdk:11

ADD ./target/evaluator-0.0.1-SNAPSHOT.jar /event/src/evaluator-0.0.1-SNAPSHOT.jar
ADD ./assets/tagweights.json /event/src/assets/tagweights.json
ADD ./assets/data.json /event/src/assets/data.json

EXPOSE 8082
WORKDIR event/src
ENTRYPOINT ["java","-jar","evaluator-0.0.1-SNAPSHOT.jar"]



