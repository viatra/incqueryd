#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

IMAGE=incqueryd/node
docker build -t=$IMAGE .
CONTAINER=incqueryd
docker run -d --name $CONTAINER -p 8084:8084 -p 9090:9090 $IMAGE /bin/bash -c incqueryd/scripts/start-without-docker.sh # XXX duplicated ports and path
echo "Started container $CONTAINER"