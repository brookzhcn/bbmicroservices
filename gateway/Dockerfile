FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/gateway.jar /webapp/
CMD ["java", "-Xmx200m", "-jar", "/webapp/gateway.jar"]

EXPOSE 4000