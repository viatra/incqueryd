#!/bin/bash
rm -rf /tmp/cassandra/*
export JAVA_OPTIONS="-Xms8G -Xmx8G -javaagent:/home/meres/titan/lib/jamm-0.2.5.jar"
bin/titan.sh config/titan-server-rexster.xml config/titan-server-cassandra.properties
