FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/registry.jar /webapp/
CMD ["java", "-Xmx200m", "-jar", "/webapp/registry.jar"]

EXPOSE 8761