FROM java:8
MAINTAINER consoleadm2020@gmail.com
WORKDIR /app
ADD ./target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app/app.jar"]
