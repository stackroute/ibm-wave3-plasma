FROM openjdk:11

ADD ./target/tagging-service-0.0.1-SNAPSHOT.jar /event/src/tagging-service-0.0.1-SNAPSHOT.jar
EXPOSE 8070
WORKDIR event/src
ENTRYPOINT ["java","-jar","tagging-service-0.0.1-SNAPSHOT.jar"]