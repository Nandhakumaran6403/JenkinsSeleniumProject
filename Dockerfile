FROM openjdk:18
WORKDIR /app
COPY ./target/backend-0.0.1-SNAPSHOT.jar /app
EXPOSE 1010
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]