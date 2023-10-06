FROM maven:3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/appinventiv/eclipse-workspace/docker_mysql_demo/src
RUN mvn -f /home/appinventiv/eclipse-workspace/docker_mysql_demo/pom.xml clean package
EXPOSE 9002
ENTRYPOINT ["java","-jar","/home/appinventiv/eclipse-workspace/docker_mysql_demo/target/docker_mysql_demo-0.0.1-SNAPSHOT.jar"]