#!/bin/bash

export COORDINATOR_DIR=~/incqueryd/coordinator

cd $COORDINATOR_DIR

rm -f coordinator.err coordinator.out $COORDINATOR_DIR 2> /dev/null

nohup java -jar hu.bme.mit.incqueryd.core-1.0.0-SNAPSHOT.jar $1 $2 > $COORDINATOR_DIR/coordinator.out 2> $COORDINATOR_DIR/coordinator.err < /dev/null &
