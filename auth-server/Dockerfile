FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/auth-server.jar /webapp/
CMD ["java", "-Xmx200m", "-jar", "/webapp/auth-service.jar"]

EXPOSE 5000