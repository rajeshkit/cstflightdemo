FROM openjdk:21-ea-1-jdk-slim
COPY ./target/flightservice.jar	flightservice.jar
EXPOSE 9090
CMD ["java","--enable-preview","-jar","flightservice.jar"]