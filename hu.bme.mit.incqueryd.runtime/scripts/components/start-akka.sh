#!/bin/bash

export JAVA_OPTS="-Xms1G -Xmx1G"
export INSTALL_DIR=~/incqueryd
export AKKA_VERSION=2.1.4

while [[ ! -z `ps auxw | grep java | grep akka` ]]; do
  echo Waiting for Akka to finish.
  sleep 1
done

cd $INSTALL_DIR

rm akka*.err akka*.out $INSTALL_DIR 2> /dev/null

cd akka-$AKKA_VERSION

for port in "$@"
do
    echo "$port"
    nohup bin/akka hu.bme.mit.incqueryd.rete.actors.IncQueryDMicrokernel $port > $INSTALL_DIR/akka-$port.out 2> $INSTALL_DIR/akka-$port.err < /dev/null &
done

