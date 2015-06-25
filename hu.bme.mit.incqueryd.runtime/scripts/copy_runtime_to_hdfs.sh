#!/bin/bash

# run it on yarn-rm.docker host

cd /usr/local/hadoop

JARFILE=hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar
# create folder on hdfs and put the jar - run only once

bin/hdfs dfs -mkdir /jars

# Remove jar if exists
bin/hdfs dfs -rm /jars/$JARFILE
bin/hdfs dfs -put /tmp/target/$JARFILE /jars/

#hdfs://yarn-rm.docker:9000/jars/$JARFILE
