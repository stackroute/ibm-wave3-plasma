FROM openjdk:11

ADD ./target/tagging-service-0.0.1-SNAPSHOT.jar /event/src/tagging-service-0.0.1-SNAPSHOT.jar
ADD ./dict/basic.csv /event/src/dict/basic.csv
ADD ./dict/concept.csv /event/src/dict/concept.csv
ADD ./dict/example.csv /event/src/dict/example.csv
ADD ./dict/gettingstarted.csv /event/src/dict/gettingstarted.csv
ADD ./dict/intent.csv /event/src/dict/intent.csv
ADD ./dict/reference.csv /event/src/dict/reference.csv
ADD ./dict/term.csv /event/src/dict/term.csv
ADD ./dict/trouleshooting.csv /event/src/dict/trouleshooting.csv
ADD ./dict/tutorials.csv /event/src/dict/tutorials.csv
EXPOSE 8087
WORKDIR event/src
ENTRYPOINT ["java","-jar","tagging-service-0.0.1-SNAPSHOT.jar"]
