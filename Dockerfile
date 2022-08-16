FROM openjdk:8-jdk-alpine
WORKDIR ./
COPY ./build/libs/hotelmenu-0.0.1-SNAPSHOT.jar hotelmenu.jar
ENTRYPOINT ["java", "-Xms512m", "-Xms256m", "-jar", "hotelmenu.jar"]
