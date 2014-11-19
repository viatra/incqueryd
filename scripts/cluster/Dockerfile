FROM n3ziniuka5/ubuntu-oracle-jdk:14.04-JDK7
MAINTAINER IncQuery-D Team
RUN apt-get update && \
	apt-get install -y git
RUN git clone https://github.com/FTSRG/4store-graph-driver && \
	4store-graph-driver/scripts/4s-install.sh
RUN apt-get update && \
	apt-get install -y openssh-server && \
	mkdir /var/run/sshd && \
	echo 'root:root' |chpasswd && \
	sed -ri 's/^PermitRootLogin\s+.*/PermitRootLogin yes/' /etc/ssh/sshd_config && \
	sed -ri 's/UsePAM yes/#UsePAM yes/g' /etc/ssh/sshd_config
EXPOSE 22 2552 8080 9090
COPY init-container.sh .
