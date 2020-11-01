FROM openjdk:8-jre-alpine
LABEL maintainer="singh.gagandeep3911@gmail.com"
ADD target/*.jar app.jar
EXPOSE 9400
ENTRYPOINT [ "java", "-jar", "app.jar" ]
