FROM openjdk:8-jdk-alpine
MAINTAINER yaegar.com
VOLUME /tmp
ADD build/libs/yaegar-books-rest-service-0.0.1-SNAPSHOT.jar yaegar-books-rest-service.jar
ENTRYPOINT ["java","-jar","/yaegar-books-rest-service.jar"]
