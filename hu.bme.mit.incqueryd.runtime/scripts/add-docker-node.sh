#!/bin/bash

source setnames.sh

YARN_NEW_NODE=yarn-docker-node3

YARN_NEW_NODE_HOST=yarn-node3.docker

docker run --hostname $YARN_NEW_NODE_HOST --name $YARN_NEW_NODE -i -t -d $IMAGE

printf 'docker stop '$YARN_NEW_NODE'\n' >> stop.sh
printf 'docker rm '$YARN_NEW_NODE'\n' >> stop.sh

YARN_NEW_NODE_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_NEW_NODE)
YARN_RM_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_RM)
YARN_NM1_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_NM1)
YARN_NM2_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_NM2)

echo "RM IP:    " $YARN_RM_IP
echo "Node1 IP: " $YARN_NM1_IP
echo "Node2 IP: " $YARN_NM2_IP
echo "New Node IP: " $YARN_NEW_NODE_IP

docker exec $YARN_RM /etc/write-hosts.sh $YARN_NEW_NODE_IP $YARN_NEW_NODE_HOST
docker exec $YARN_NM1 /etc/write-hosts.sh $YARN_NEW_NODE_IP $YARN_NEW_NODE_HOST
docker exec $YARN_NM2 /etc/write-hosts.sh $YARN_NEW_NODE_IP $YARN_NEW_NODE_HOST

docker exec $YARN_NEW_NODE /etc/write-hosts.sh $YARN_RM_IP $YARN_RM_HOST
docker exec $YARN_NEW_NODE /etc/write-hosts.sh $YARN_NM1_IP $YARN_NM1_HOST
docker exec $YARN_NEW_NODE /etc/write-hosts.sh $YARN_NM2_IP $YARN_NM2_HOST

docker exec $YARN_NEW_NODE /etc/write-hosts.sh $YARN_NEW_NODE_IP $YARN_NEW_NODE_HOST

if grep $YARN_NEW_NODE_HOST /etc/hosts; then
   sudo sed -i "/$YARN_NEW_NODE_HOST/ s/.*/$YARN_NEW_NODE_IP\t$YARN_NEW_NODE_HOST/g" /etc/hosts
else
   sudo ./write-hosts.sh $YARN_NEW_NODE_IP $YARN_NEW_NODE_HOST
fi

HOST_RSA=$(cat ~/.ssh/id_rsa.pub)
docker exec $YARN_NEW_NODE /etc/write-auth-keys.sh $HOST_RSA

docker exec $YARN_NEW_NODE service ssh start
docker exec $YARN_NEW_NODE /etc/write-zoo-myid.sh 4

docker exec $YARN_NEW_NODE /usr/local/zookeeper/bin/zkServer.sh start

docker exec $YARN_NEW_NODE /usr/local/hadoop/add-yarn-node.sh


