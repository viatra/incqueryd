#!/bin/bash

# This scripts starts the OS monitoring agent on a machine

monitoringServerIPAddress=$1

export OSAGENT_DIR=~/incqueryd/monitoring/osagent/

cd $OSAGENT_DIR

rm -f osagent.err osagent.out $OSAGENT_DIR 2> /dev/null

nohup java -Djava.library.path=./lib/hyperic-sigar-1.6.5/sigar-bin/lib/ -jar core-*-SNAPSHOT.jar $monitoringServerIPAddress > $OSAGENT_DIR/osagent.out 2> $OSAGENT_DIR/osagent.err < /dev/null &
