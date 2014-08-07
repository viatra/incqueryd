#!/bin/bash

ip_address=$1
shift
ports=$@

rm -r config-* 2> /dev/null

for port in $ports
do
	mkdir config-$port
	cat application.conf.template | sed "s/<ip_address>/$ip_address/" | sed "s/<port>/$port/" > config-$port/application.conf
done
