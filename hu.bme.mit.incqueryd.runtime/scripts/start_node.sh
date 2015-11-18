#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

source setnames.sh

# Read parameters
INSTANCE_ID=$1

RM=false
if [ "$INSTANCE_ID" = "rm" ]; then
	RM=true
fi

LOCAL=false
if [ "$2" = "-local" ]; then
	LOCAL=true;
fi

USE_SSH=false
if [ "$3" = "-use_ssh" ]; then
	USE_SSH=true;
fi

# Variables and constants
TARGET_PATH=`pwd`/../../hu.bme.mit.incqueryd.runtime/hu.bme.mit.incqueryd.actorservice.server/target
WEAVE_IP=" "
DNS_IP=" "

# Define weave IP if running on EC2 cluster
if ! $LOCAL; then
	WEAVE_IP="10.0.0.100"
	if [ "$INSTANCE_ID" != "rm" ]; then
		last=$((INSTANCE_ID+100));
		WEAVE_IP="10.0.0.$last";
	fi
fi

# Define instance name and hostname based on instance ID
INSTANCE_NAME=$YARN_RM
INSTANCE_HOST=$YARN_RM_HOST
if ! $RM; then
	INSTANCE_NAME="$YARN_NM$INSTANCE_ID";
	INSTANCE_HOST="$YARN_NM_HOST$INSTANCE_ID$IQD_HOST";
fi

# Add port binding parameters if starting RM
BINDING_PORTS=" "
if $RM; then
	BINDING_PORTS="-p 127.0.0.1:53:53/udp -p 127.0.0.1:2181:2181 -p 127.0.0.1:2182:2182 -p 127.0.0.1:5701:5701 -p 127.0.0.1:9876:9876 -p 127.0.0.1:8088:8088 -p 127.0.0.1:50070:50070"
fi

# Start docker container
if $LOCAL; then
	# Define DNS IP
	if [ "$INSTANCE_ID" = "rm" ]; then
		DNS_IP="127.0.0.1"
	else
		DNS_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_RM)
	fi
	
	docker run --dns $DNS_IP $BINDING_PORTS --hostname $INSTANCE_HOST --name $INSTANCE_NAME -v $TARGET_PATH:/tmp/target -i -t -d $IMAGE
else
	# DNS IP is fix if working with weave (multihost mode)
	DNS_IP="10.0.0.100"
	weave run $WEAVE_IP/24 --dns $DNS_IP $BINDING_PORTS --hostname $INSTANCE_HOST --name $INSTANCE_NAME -v $TARGET_PATH:/tmp/target -i -t -d $IMAGE
fi

# Fix container hostname and used nameserver
docker exec $INSTANCE_NAME /etc/fix_networking.sh $INSTANCE_HOST $DNS_IP

# Define container IP in docker subnetwork
DOCKER_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $INSTANCE_NAME)

# Resolve cluster node from host
sudo sed -i "/$INSTANCE_HOST/d" /etc/hosts
sudo -- sh -c "printf $DOCKER_IP' '$INSTANCE_HOST'\n' >> /etc/hosts"

if $LOCAL; then
	docker exec $YARN_RM /etc/add-dns-entry.sh $DOCKER_IP $INSTANCE_HOST
fi

# Enable ssh form host
if $USE_SSH; then
	HOST_RSA=$(cat ~/.ssh/id_rsa.pub)
	docker exec $INSTANCE_NAME /etc/write-auth-keys.sh $HOST_RSA
fi

# Start ssh service
docker exec $INSTANCE_NAME service ssh start

# Start cluster applications
if $RM; then
	if ! $LOCAL; then
		docker exec $INSTANCE_NAME /etc/add-dns-entries.sh
	fi
	docker exec $INSTANCE_NAME service dnsmasq start
	docker exec $INSTANCE_NAME /etc/bootstrap.sh -bash
	docker exec $INSTANCE_NAME /etc/write-zoo-myid.sh 1
	docker exec $INSTANCE_NAME /usr/local/zookeeper/bin/start-zk-server.sh 1 "RM"
	docker exec -d $INSTANCE_NAME sh /usr/local/hazelcast/bin/server.sh
	docker exec -d $INSTANCE_NAME mosquitto -d -p 9876 > /dev/null 2>&1
else
	if $LOCAL; then
		docker exec $YARN_RM service dnsmasq restart
	fi
	docker exec $INSTANCE_NAME /usr/local/hadoop/add-yarn-node.sh
	docker exec $INSTANCE_NAME /etc/write-zoo-myid.sh $(($INSTANCE_ID+1))
	docker exec $INSTANCE_NAME /usr/local/zookeeper/bin/start-zk-server.sh $(($INSTANCE_ID+1)) $INSTANCE_ID $YARN_RM_HOST
	docker exec -d $INSTANCE_NAME sh /usr/local/hazelcast/bin/server.sh
fi
