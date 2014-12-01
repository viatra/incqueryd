#!/bin/bash

if [[ $# -lt 2 ]] ; then
    echo 'Usage: start-akka.sh <port> <memorysize>'
    exit 0
fi

port=$1
memory=$2

m="m"

export JAVA_OPTS="-Xms128m -Xmx$memory$m"
export INSTALL_DIR=~/incqueryd
export AKKA_VERSION=2.1.4

cd $INSTALL_DIR

rm akka-$port.err akka-$port.out $INSTALL_DIR 2> /dev/null

cd akka-$AKKA_VERSION

echo "$port"
nohup bin/akka hu.bme.mit.incqueryd.engine.rete.actors.IncQueryDMicrokernel $port > $INSTALL_DIR/akka-$port.out 2> $INSTALL_DIR/akka-$port.err < /dev/null &


