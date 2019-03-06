FROM openjdk:11

ADD ./target/document-crawler-0.0.1-SNAPSHOT.jar /event/src/document-crawler-0.0.1-SNAPSHOT.jar
EXPOSE 8193
WORKDIR event/src
ENTRYPOINT ["java","-jar","document-crawler-0.0.1-SNAPSHOT.jar"]