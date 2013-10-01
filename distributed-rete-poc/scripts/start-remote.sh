#!/bin/bash
killall java 2> /dev/null
sleep 4
cd ~
sudo ./clearCache.sh
rm -rf neo4j-community-1.8.2
distributed-rete/scripts/neo4j-config.sh
distributed-rete/scripts/neo4j-start.sh
nohup akka-2.1.2/bin/akka distributed.rete.bootable.RemoteBootable &
