FROM tomcat:9.0.8-jre10
COPY target/anemone-gateway.war anemone.war
EXPOSE 8080
CMD ["catalina.sh", "run", "anemone.war"]