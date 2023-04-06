FROM amazoncorretto:17

COPY e-commerce-backed-main/target/ECommerce*.jar e-commerce.jar

ENTRYPOINT ["java", "-jar", "/e-commerce.jar"]

EXPOSE 7777