FROM openjdk:11

ADD concept-storage-0.0.1-SNAPSHOT.jar  /event/src/concept-storage-0.0.1-SNAPSHOT.jar
EXPOSE 8097
WORKDIR event/src
ENTRYPOINT ["java","-jar","concept-storage-0.0.1-SNAPSHOT.jar"]