#!/bin/bash

export localHost=""
export JAVA_OPTS="-Xms10G -Xmx10G"

killall -9 java
while [[ ! -z `ps auxw | grep akk[a]` ]]; do
  echo Waiting for Akka to finish.Â
  sleep 1
done

cd ~/akka-2.1.4
nohup bin/akka hu.bme.mit.incqueryd.rete.actors.IncQueryDMicrokernel > akka.out 2> akka.err < /dev/null &
