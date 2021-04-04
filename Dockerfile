FROM java:8
MAINTAINER samuel3283@gmail.com
ADD ./target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
