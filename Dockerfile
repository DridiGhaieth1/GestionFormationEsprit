FROM openjdk:8-alpine
ADD target/GesF-1.0.jar GesF-1.0.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","GesF-1.0.jar"]




