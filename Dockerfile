FROM openjdk:8-jdk-alpine
MAINTAINER yaegar.com
VOLUME /tmp
ADD build/libs/yaegar-books-rest-service.jar yaegar-books-rest-service.jar
ENTRYPOINT ["java","-jar","/yaegar-books-rest-service.jar"]
