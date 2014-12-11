#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

nohup java -jar ../hu.bme.mit.incqueryd.coordinator/target/hu.bme.mit.incqueryd.coordinator-*.jar > coordinator.out 2> coordinator.err < /dev/null &