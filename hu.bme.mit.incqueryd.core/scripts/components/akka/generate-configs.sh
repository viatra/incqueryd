#!/bin/bash

# Usage: generate-configs.sh port1 port2 ...

cd "$( cd "$( dirname "$0" )" && pwd )"

ip_address=$(ifconfig eth0 | grep 'inet addr:' | cut -d: -f2 | awk '{ print $1}')
ports=$@

rm -r config-* 2> /dev/null

for port in $ports
do
	mkdir config-$port
	cat application.conf.template | sed "s/<ip_address>/$ip_address/" | sed "s/<port>/$port/" > config-$port/application.conf
done
