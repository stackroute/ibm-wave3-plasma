FROM openjdk:11

ADD ./target/nlp-service-0.0.1-SNAPSHOT.jar /event/src/nlp-service-0.0.1-SNAPSHOT.jar
ADD ./dictionary/stopwords.csv /event/src/dictionary/stopwords.csv
EXPOSE 8098
WORKDIR event/src
ENTRYPOINT ["java","-jar","nlp-service-0.0.1-SNAPSHOT.jar"]