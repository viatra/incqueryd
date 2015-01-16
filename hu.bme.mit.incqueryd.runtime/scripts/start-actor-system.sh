#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

NAME=actor-system
nohup java -jar ../hu.bme.mit.incqueryd.actorsystem/target/hu.bme.mit.incqueryd.actorsystem-*.jar "$@" > ${NAME}.out 2> ${NAME}.err < /dev/null &
echo $! > ${NAME}.pid