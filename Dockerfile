# Use the latest OpenJDK image
FROM openjdk:latest

# Set the working directory
WORKDIR /tmp

# Copy the JAR file to the working directory of the container
COPY target/seMethods-0.1.0.2.jar /tmp/

# Set the entry point
ENTRYPOINT ["java", "-jar", "seMethods-0.1.0.2.jar"]