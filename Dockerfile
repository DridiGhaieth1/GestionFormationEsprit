FROM maven:3.8.1-jdk-8
ADD target/Gesf.jar Gesf.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "Gesf.jar"]
