FROM adoptopenjdk/opdenjdk11:latest
LABEL maintainer="author@vedernikov.com"
VOLUME /main-app
ADD target/spring-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]
