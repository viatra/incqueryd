#!/bin/bash

minSize=1
maxSize=4
seriesCount=1
queries="PosLength RouteSensor SignalNeighbor SwitchSensor"
timeout="12m"
scenario="XForm"
workspacePath="/home/szarnyasg/git/mondo-trainbenchmark/src/"
xmx=4G
maxPermSize=256M

[ -f config-override.sh ] && . config-override.sh
