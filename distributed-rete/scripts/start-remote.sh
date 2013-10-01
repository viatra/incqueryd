#!/bin/bash
cd ~
sudo distributed-rete/scripts/clearCache.sh
rm -rf neo4j-community-1.9
distributed-rete/scripts/neo4j-config.sh
distributed-rete/scripts/neo4j-start.sh
