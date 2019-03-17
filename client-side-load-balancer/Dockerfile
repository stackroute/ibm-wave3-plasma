FROM openjdk:11

ADD ./target/client-side-load-balancer-0.0.1-SNAPSHOT.jar /event/src/client-side-load-balancer-0.0.1-SNAPSHOT.jar
EXPOSE 8071
WORKDIR event/src
ENTRYPOINT ["java","-jar","client-side-load-balancer-0.0.1-SNAPSHOT.jar"]
