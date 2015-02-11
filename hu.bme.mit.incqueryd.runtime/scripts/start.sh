#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

IMAGE=incqueryd/node
docker build -t=$IMAGE .
CONTAINER=incqueryd
docker run -d --name $CONTAINER -p 8084:8084 -p 8094:8094 -p 2552:2552 -p 2553:2553 $IMAGE /bin/bash -c incqueryd/scripts/start-without-docker.sh # XXX duplicated ports and path
echo "Started container $CONTAINER"