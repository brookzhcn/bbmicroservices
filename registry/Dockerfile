FROM java:8-jre
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD ./target/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 7003