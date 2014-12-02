FROM n3ziniuka5/ubuntu-oracle-jdk:14.04-JDK7
MAINTAINER IncQuery-D Team
EXPOSE 2552 2553 2554 2555 8080 9090 
COPY ./ /incqueryd
WORKDIR /incqueryd