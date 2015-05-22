#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

source start-cluster.sh
source start-old.sh

docker exec $CONTAINER /etc/write-hosts.sh $YARN_RM_IP $YARN_RM_HOST
docker exec $CONTAINER /etc/write-hosts.sh $YARN_NM1_IP $YARN_NM1_HOST
docker exec $CONTAINER /etc/write-hosts.sh $YARN_NM2_IP $YARN_NM2_HOST

CONTAINER_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $CONTAINER)
echo "Actor Service IP: $CONTAINER_IP"
