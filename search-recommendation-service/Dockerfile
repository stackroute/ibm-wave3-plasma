FROM openjdk:11

ADD ./target/search-recommendation-service-0.0.1-SNAPSHOT.jar /event/src/search-recommendation-service-0.0.1-SNAPSHOT.jar
EXPOSE 8083
WORKDIR event/src
ENTRYPOINT ["java","-jar","search-recommendation-service-0.0.1-SNAPSHOT.jar"]
