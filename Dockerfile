FROM openjdk:23-ea-30-jdk-oracle

COPY build/libs/learning-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar" , "/app/application.jar"]