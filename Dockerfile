FROM openjdk:latest
COPY ./target/seMethods-0.1.0.4.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods-0.1.0.4.jar", "db:3306", "30000"]
