#!/bin/bash

export username=szarnyasg
export masters="10.6.21.191"
export slaves("10.6.21.193" "10.6.21.195" "10.6.21.197")
export seeds="10.6.21.191"
export servers=("${masters[@]}" "${slaves[@]}")

export titan_master="vcl0"
export hadoop_data="/home/meres/data/hadoop/tmp"
export hadoop_logs="/usr/local/hadoop/logs"

export TITAN_HOME="~/titan-all-0.3.2"
export TITAN_JAVA_OPTIONS="-Xms12G -Xmx12G -javaagent:$TITAN_HOME/lib/jamm-0.2.5.jar"
