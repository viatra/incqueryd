#!/bin/bash

if [ -d "neo4j-community-1.9" ]; then
  bash distributed-rete/scripts/neo4j-stop.sh
fi

rm -rf neo4j-community-1.9
rm -rf neo4j-community-1.9-b
tar -xzf distributed-rete/neo4j-community-1.9-unix.tar.gz 

# clone
cp -r neo4j-community-1.9 neo4j-community-1.9-b

cp distributed-rete/neo4j-conf/*.* neo4j-community-1.9/conf/
cp distributed-rete/neo4j-conf-b/*.* neo4j-community-1.9-b/conf