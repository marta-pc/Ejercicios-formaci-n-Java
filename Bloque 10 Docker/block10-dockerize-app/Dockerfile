#FROM <image>:<tag>
FROM openjdk:17
EXPOSE 8080
COPY /target/*.jar /url/local/lib/spring.jar
#ENTRYPOINT ["executable", "param1", "param2"]
ENTRYPOINT ["java", "-jar","/url/local/lib/spring.jar"]