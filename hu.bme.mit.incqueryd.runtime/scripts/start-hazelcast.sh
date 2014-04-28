#!/bin/bash

while [[ ! -z `ps auxw | grep java | grep hazelcast` ]]; do
  echo Waiting for Hazelcast to finish.
  sleep 1
done

cd ~/hazelcast-3.2/bin
nohup ./server.sh > ~/hazelcast.out 2> ~/hazelcast.err < /dev/null &
