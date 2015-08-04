#!/bin/bash

source setnames.sh

INSTANCE_ID=$1;

INSTANCE_IP="10.0.0.100"
INSTANCE_NAME=$YARN_RM
INSTANCE_HOST=$YARN_RM_HOST

if [ "$INSTANCE_ID" != "rm" ]; then
	last=$((INSTANCE_ID+100));
	INSTANCE_IP="10.0.0.$last";
	INSTANCE_NAME="$YARN_NM$INSTANCE_ID";
	INSTANCE_HOST="$YARN_NM_HOST$INSTANCE_ID$IQD_HOST";
fi

echo $INSTANCE_IP
echo $INSTANCE_NAME
echo $INSTANCE_HOST

USE_SSH=false
if [ "$2" = "-use_ssh" ]; then
	USE_SSH=true;
fi

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

# Start containers
TARGET_PATH=`pwd`/../target
weave run $INSTANCE_IP/24 --dns 10.0.0.100 -p 127.0.0.1:53:53/udp -p 127.0.0.1:2181:2181 -p 127.0.0.1:8088:8088 -p 127.0.0.1:50070:50070 --hostname $INSTANCE_HOST --name $INSTANCE_NAME -v $TARGET_PATH:/tmp/target -i -t -d $IMAGE

docker exec $INSTANCE_NAME /etc/fix_hostname.sh $INSTANCE_HOST

IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $INSTANCE_NAME)
echo $IP

sudo sed -i "/$INSTANCE_HOST/d" /etc/hosts
sudo printf $IP' '$INSTANCE_HOST'\n' >> /etc/hosts

if [ "$INSTANCE_ID" = "rm" ]; then
	docker exec $YARN_RM /etc/write-hosts.sh
	docker exec $YARN_RM service dnsmasq start
	docker exec $YARN_RM /etc/write-zoo-myid.sh 1
	docker exec $YARN_RM /etc/bootstrap.sh -bash
else
	docker exec $INSTANCE_NAME /etc/write-zoo-myid.sh $(($INSTANCE_ID+1))
	docker exec $INSTANCE_NAME /usr/local/hadoop/add-yarn-node.sh
	docker exec $INSTANCE_NAME /usr/local/hadoop/copy_runtime_to_hdfs.sh
fi

if $USE_SSH; then
	HOST_RSA=$(cat ~/.ssh/id_rsa.pub)
	docker exec $INSTANCE_NAME /etc/write-auth-keys.sh $HOST_RSA
fi

docker exec $INSTANCE_NAME service ssh start

docker exec $INSTANCE_NAME /usr/local/zookeeper/bin/zkServer.sh start

