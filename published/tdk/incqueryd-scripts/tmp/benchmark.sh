#!/bin/bash

rm results.txt

sizes="1 2"
#sizes="1 2 4 8 16 32 64 128 256 512 1024 2048 4096"
#sizes="2048 4096"

for size in $sizes; do
	cowsay $size
	./init-titan-cluster-snapshot.sh
	sleep 120
	java -jar titan.rexster.client-0.0.1-SNAPSHOT-jar-with-dependencies.jar $size | tee -a results.txt
done

#username=meres
#servers=("10.6.23.91" "10.6.23.92" "10.6.23.93" "10.6.23.94")
#servers=("10.6.23.91")

# sending asynchronous termination for the servers
#for server in ${servers[*]}; do
#	cat stop-titan.sh | ssh ${username}@${server} bash -s
#done

