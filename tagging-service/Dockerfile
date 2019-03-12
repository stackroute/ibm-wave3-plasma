FROM openjdk:11

ADD ./target/tagging-service-0.0.1-SNAPSHOT.jar /event/src/tagging-service-0.0.1-SNAPSHOT.jar
ADD ./dict/basic.csv /event/src/dictionary/basic.csv
ADD ./dict/concept.csv /event/src/dictionary/concept.csv
ADD ./dict/example.csv /event/src/dictionary/example.csv
ADD ./dict/gettingstarted.csv /event/src/dictionary/gettingstarted.csv
ADD ./dict/intent.csv /event/src/dictionary/intent.csv
ADD ./dict/reference.csv /event/src/dictionary/reference.csv
ADD ./dict/term.csv /event/src/dictionary/term.csv
ADD ./dict/trouleshooting.csv /event/src/dictionary/trouleshooting.csv
ADD ./dict/tutorials.csv /event/src/dictionary/tutorials.csv
EXPOSE 8087
WORKDIR event/src
ENTRYPOINT ["java","-jar","tagging-service-0.0.1-SNAPSHOT.jar"]