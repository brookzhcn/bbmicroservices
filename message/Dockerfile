FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/message.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/message.jar"]

EXPOSE 7000