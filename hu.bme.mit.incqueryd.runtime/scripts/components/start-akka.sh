#!/bin/bash

if [[ $# -lt 2 ]] ; then
    echo 'Usage: start-akka.sh <port> <memorysize>'
    exit 0
fi

port=$1
memory=$2

m="m"

export JAVA_OPTS="-Xms256m -Xmx$memory$m"
export INSTALL_DIR=~/incqueryd
export AKKA_VERSION=2.1.4

while [[ ! -z `ps auxw | grep java | grep akka` ]]; do
  pkill -f akka
  echo Waiting for Akka to finish.
  sleep 1
done

cd $INSTALL_DIR

rm akka*.err akka*.out $INSTALL_DIR 2> /dev/null

cd akka-$AKKA_VERSION

echo "$port"
nohup bin/akka hu.bme.mit.incqueryd.core.rete.actors.IncQueryDMicrokernel $port > $INSTALL_DIR/akka-$port.out 2> $INSTALL_DIR/akka-$port.err < /dev/null &


