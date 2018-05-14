FROM tomcat
ADD target/anemone-gateway.war anemone.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "anemone.war"]