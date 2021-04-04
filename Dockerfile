FROM java:8
MAINTAINER samuel3283@gmail.com
ADD ./target/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]
