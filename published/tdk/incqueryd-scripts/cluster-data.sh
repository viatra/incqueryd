#!/bin/bash

export username=szarnyasg
export masters="10.6.21.191"
export slaves=("10.6.21.193" "10.6.21.195" "10.6.21.197")
export seeds="10.6.21.191"
export servers=("${masters[@]}" "${slaves[@]}")

export titan_master="vcl0"
export hadoop_data="/home/szarnyasg/hadoop/tmp"
export hadoop_logs="/usr/local/hadoop/logs"

export TITAN_HOME="/home/szarnyasg/titan-all-0.3.2"
export TITAN_JAVA_OPTIONS="-Xms4G -Xmx4G -javaagent:$TITAN_HOME/lib/jamm-0.2.5.jar"
