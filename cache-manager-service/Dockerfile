FROM openjdk:11

ADD ./target/cache-manager-service-0.0.1-SNAPSHOT.jar /event/src/cache-manager-service-0.0.1-SNAPSHOT.jar
EXPOSE 8095
WORKDIR event/src
ENTRYPOINT ["java","-jar","cache-manager-service-0.0.1-SNAPSHOT.jar"]