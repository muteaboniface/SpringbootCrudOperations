#FROM openjdk:11
#COPY target/taxcalc-0.0.1-SNAPSHOT.jar taxcalc-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","taxcalc-0.0.1-SNAPSHOT.jar"]


FROM openjdk:11
ARG JAR_FILE=target/*.jarjav
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["a", "-jar", "app.jar"]