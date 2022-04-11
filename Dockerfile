FROM openjdk:11
ADD build/libs/*.jar inventario-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "inventario-app.jar"]