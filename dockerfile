FROM openjdk:11
ADD target/expense.jar expense.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","expense.jar"]
