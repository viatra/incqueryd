#!/bin/sh

HOSTS_FOLDER="/etc/hosts"

sudo printf '10.0.0.100 yarn-rm.docker\n' >> $HOSTS_FOLDER

for i in $(seq 1 99);
do
	if [ $i -lt 10 ]; then
		sudo printf "10.0.0.10$i yarn-node$i.docker\n" >> $HOSTS_FOLDER
	else
		sudo printf "10.0.0.1$i yarn-node$i.docker\n" >> $HOSTS_FOLDER
	fi
done
