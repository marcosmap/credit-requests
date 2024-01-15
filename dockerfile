# Use a base image with OpenJDK
FROM openjdk:17
# Set the working directory inside the container
WORKDIR /app
# Copy the JAR file into the container at /app
COPY target/credit-request.jar /app/
# Expose the port that your application runs on
EXPOSE 8080
# Command to run your application
CMD ["java", "-jar", "credit-request.jar"]
