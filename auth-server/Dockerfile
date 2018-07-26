FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/auth-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service.jar"]

EXPOSE 5000