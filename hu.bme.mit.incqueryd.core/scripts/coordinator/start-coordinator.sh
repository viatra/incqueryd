#!/bin/bash

architectureFile=$1
interface=$2

export COORDINATOR_DIR=~/incqueryd/coordinator

cd $COORDINATOR_DIR

rm -f coordinator.err coordinator.out $COORDINATOR_DIR 2> /dev/null

nohup java -jar hu.bme.mit.incqueryd.engine-*-SNAPSHOT.jar --architectureFile $architectureFile --interface $interface > $COORDINATOR_DIR/coordinator.out 2> $COORDINATOR_DIR/coordinator.err < /dev/null &
