FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/message.jar /webapp/
CMD ["java", "-Xmx200m", "-jar", "/webapp/message.jar"]

EXPOSE 7000