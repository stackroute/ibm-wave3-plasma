FROM openjdk:11

ADD ./target/concept-storage-0.0.1-SNAPSHOT.jar  /event/src/concept-storage-0.0.1-SNAPSHOT.jar
EXPOSE 8074
WORKDIR event/src
ENTRYPOINT ["java","-jar","concept-storage-0.0.1-SNAPSHOT.jar"]
