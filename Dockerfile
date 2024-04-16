FROM openjdk:17-jdk
WORKDIR /app
COPY target/banking.jar /app/banking.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/banking.jar"]
