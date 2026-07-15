FROM openjdk:24
COPY ./target/flightservice.jar	flightservice.jar
CMD ["java","-jar","flightservice.jar"]