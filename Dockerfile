FROM openjdk:11
RUN adduser spring 
USER spring:spring
ARG JAR_FILE=target/springdemo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


