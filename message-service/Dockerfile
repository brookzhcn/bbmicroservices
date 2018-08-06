FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/message-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/message-service.jar"]

EXPOSE 7005