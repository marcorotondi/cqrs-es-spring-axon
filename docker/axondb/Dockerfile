FROM openjdk:8-jre-alpine
VOLUME /tmp /opt/data
EXPOSE 8023 8123
COPY axondb-server.jar /opt/axondb/
COPY axondb.properties /opt/axondb/
WORKDIR /opt/axondb
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512M", "-Xmx512M", "-jar", "axondb-server.jar"]