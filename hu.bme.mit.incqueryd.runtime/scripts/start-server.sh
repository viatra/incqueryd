#!/bin/bash

while [ "$1" != "" ]; do
	case $1 in
		"--hazelcast")
		hazelcast=true
		;;
	esac
	shift
done


killall -9 java
./start-akka.sh

if $hazelcast; then
	./start-hazelcast.sh
fi
