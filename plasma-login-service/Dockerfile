FROM openjdk:11

ADD ./target/plasma-login-0.0.1-SNAPSHOT.jar /event/src/plasma-login-0.0.1-SNAPSHOT.jar
EXPOSE 8132
WORKDIR event/src
ENTRYPOINT ["java","-jar","plasma-login-0.0.1-SNAPSHOT.jar"]