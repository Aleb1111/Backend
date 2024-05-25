FROM openjdk:22
ADD ./back.jar back.jar
ENTRYPOINT ["java","-jar","back.jar"]