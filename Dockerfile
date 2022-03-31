FROM java:8
MAINTAINER consoleadm2020@gmail.com
ADD ./target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
