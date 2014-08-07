#!/bin/bash

export HOSTNAME=<hostname>
export JAVA_OPTS="-Xms1G -Xmx1G"

while [[ ! -z `ps auxw | grep java | grep akka` ]]; do
  echo Waiting for Akka to finish.
  sleep 1
done

cd

rm ~/akka.* 2> /dev/null

cd ~/akka-2.1.4
nohup bin/akka hu.bme.mit.incqueryd.rete.actors.IncQueryDMicrokernel > ~/akka.out 2> ~/akka.err < /dev/null &
