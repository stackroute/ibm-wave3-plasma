FROM openjdk:11

ADD ./target/search-service-0.0.1-SNAPSHOT.jar /event/src/search-service-0.0.1-SNAPSHOT.jar
EXPOSE 8098
WORKDIR event/src
ENTRYPOINT ["java","-jar","search-service-0.0.1-SNAPSHOT.jar"]
