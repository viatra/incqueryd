#!/bin/bash

# run it on yarn-rm.docker host

cd /usr/local/hadoop

JARFILE=hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar
# create folder on hdfs and put the jar - run only once

# Create dir if not exists
bin/hdfs dfs -test -e /jars
if [ $? -eq 1 ]; then
	bin/hdfs dfs -mkdir /jars
fi

# Remove jar if exists
bin/hdfs dfs -test -e /jars/$JARFILE
if [ $? -eq 0 ]; then
	bin/hdfs dfs -rm /jars/$JARFILE
fi

bin/hdfs dfs -put /tmp/target/$JARFILE /jars/

#hdfs://yarn-rm.docker:9000/jars/$JARFILE
