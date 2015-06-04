FROM n3ziniuka5/ubuntu-oracle-jdk:14.04-JDK7
MAINTAINER IncQuery-D Team
EXPOSE 8084 8094 2552 2553
# XXX duplicated ports
COPY . incqueryd/

ADD scripts/write-hosts.sh /etc/write-hosts.sh
RUN chown root:root /etc/write-hosts.sh
RUN chmod 700 /etc/write-hosts.sh
