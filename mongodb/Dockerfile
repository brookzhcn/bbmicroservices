FROM mongo:3
MAINTAINER Brook Zhang <brook.zhang@aon.com>

ADD init.sh /init.sh
ADD ./dump /

RUN \
 echo "deb http://mirrors.aliyun.com/debian wheezy main contrib non-free
       deb-src http://mirrors.aliyun.com/debian wheezy main contrib non-free
       deb http://mirrors.aliyun.com/debian wheezy-updates main contrib non-free
       deb-src http://mirrors.aliyun.com/debian wheezy-updates main contrib non-free
       deb http://mirrors.aliyun.com/debian-security wheezy/updates main contrib non-free
       deb-src http://mirrors.aliyun.com/debian-security wheezy/updates main contrib non-free"
       > /etc/apt/sources.list && \
 chmod +x /init.sh && \
 apt-get update && apt-get dist-upgrade -y && \
 apt-get install psmisc -y -q && \
 apt-get autoremove -y && apt-get clean && \
 rm -rf /var/cache/* && rm -rf /var/lib/apt/lists/*

ENTRYPOINT ["/init.sh"]