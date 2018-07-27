FROM mongo:3
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD init.sh /init.sh
ADD ./dump /
ADD sources.list /etc/apt/sources.list

RUN \
 chmod +x /init.sh && \
 apt-get update && apt-get dist-upgrade -y && \
 apt-get install psmisc -y -q && \
 apt-get autoremove -y && apt-get clean && \
 rm -rf /var/cache/* && rm -rf /var/lib/apt/lists/*

ENTRYPOINT ["/init.sh"]