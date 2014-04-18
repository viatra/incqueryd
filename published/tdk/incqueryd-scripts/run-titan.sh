#!/bin/bash

#export TITAN_HOME=~/titan/titan-all/target/titan-all-0.4.0-SNAPSHOT-standalone
export TITAN_HOME=~/titan
export JAVA_OPTIONS="-Xms8G -Xmx8G -javaagent:$TITAN_HOME/lib/jamm-0.2.5.jar"

cd ~/titan
#nohup bin/titan.sh config/titan-server-rexster.xml config/titan-server-cassandra.properties > ~/titan.out.txt 2> ~/titan.err.txt < /dev/null &
