#FROM openjdk:11
#ARG JAR_FILE=target/taxcalc-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY wait-for-it.sh wait-for-it.sh
ENTRYPOINT ["./wait-for-it.sh", "db:3312", "--", "java", "-jar", "app.jar"]