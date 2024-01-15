FROM openjdk:17
ADD credit-requests.jar credit-requests.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/credit-requests.jar"]
