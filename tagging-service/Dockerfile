FROM openjdk:11

ADD ./target/tagging-service-0.0.1-SNAPSHOT.jar /event/src/tagging-service-0.0.1-SNAPSHOT.jar
ADD ./dictionary/basic.csv /event/src/dictionary/basic.csv
ADD ./dictionary/concept.csv /event/src/dictionary/concept.csv
ADD ./dictionary/example.csv /event/src/dictionary/example.csv
ADD ./dictionary/gettingstarted.csv /event/src/dictionary/gettingstarted.csv
ADD ./dictionary/intent.csv /event/src/dictionary/intent.csv
ADD ./dictionary/reference.csv /event/src/dictionary/reference.csv
ADD ./dictionary/term.csv /event/src/dictionary/term.csv
ADD ./dictionary/trouleshooting.csv /event/src/dictionary/trouleshooting.csv
ADD ./dictionary/tutorials.csv /event/src/dictionary/tutorials.csv
EXPOSE 8087
WORKDIR event/src
ENTRYPOINT ["java","-jar","tagging-service-0.0.1-SNAPSHOT.jar"]