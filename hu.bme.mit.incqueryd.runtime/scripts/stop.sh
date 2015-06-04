#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

source setnames.sh

docker stop $YARN_RM
docker stop $YARN_NM1
docker stop $YARN_NM2

docker rm $YARN_RM
docker rm $YARN_NM1
docker rm $YARN_NM2

# Legacy Actor Service

docker stop $OLD_CONTAINER
docker rm $OLD_CONTAINER
