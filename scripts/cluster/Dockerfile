FROM ubuntu:14.04
MAINTAINER IncQuery-D Team
RUN apt-get update && apt-get install -y \
	ssh \
	git
RUN apt-get install -y software-properties-common && bash -c "echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections" && add-apt-repository -y ppa:webupd8team/java && apt-get update && apt-get install -y oracle-java7-installer
RUN git clone https://github.com/FTSRG/4store-graph-driver && cd 4store-graph-driver/scripts && ./4s-install.sh && ./4s-init-single-node.sh $IPS