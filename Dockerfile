FROM openjdk:8-jdk-alpine
WORKDIR ./
COPY build/libs/hotel-menu-0.0.1-SNAPSHOT.jar Hotelmenu.jar
ENTRYPOINT ["java", "-Xms512m", "-Xms256m", "-jar", "Hotelmenu.jar"]

