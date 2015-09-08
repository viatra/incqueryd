#!/bin/bash

USE_SSH=false
if [ "$1" = "-use_ssh" ]; then
	USE_SSH=true;
fi

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

source setnames.sh

./build_image.sh

# Start containers
TARGET_PATH=`pwd`/../../hu.bme.mit.incqueryd.runtime/hu.bme.mit.incqueryd.actorservice.server/target
docker run --dns 127.0.0.1 -p 127.0.0.1:53:53/udp -p 127.0.0.1:2181:2181 --hostname $YARN_RM_HOST --name $YARN_RM -v $TARGET_PATH:/tmp/target -i -t -d $IMAGE
YARN_RM_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_RM)

docker run --dns $YARN_RM_IP -p 127.0.0.1:5701:5701 --hostname $YARN_NM1_HOST --name $YARN_NM1 -v $TARGET_PATH:/tmp/target -i -t -d $IMAGE
docker run --dns $YARN_RM_IP --hostname $YARN_NM2_HOST --name $YARN_NM2 -v $TARGET_PATH:/tmp/target -i -t -d $IMAGE

# Containers HOSTS config
YARN_NM1_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_NM1)
YARN_NM2_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_NM2)

echo "RM IP:    " $YARN_RM_IP
echo "Node1 IP: " $YARN_NM1_IP
echo "Node2 IP: " $YARN_NM2_IP

# Add existing hosts to DNS server
docker exec $YARN_RM /etc/write-hosts.sh $YARN_RM_IP $YARN_RM_HOST
docker exec $YARN_RM /etc/write-hosts.sh $YARN_NM1_IP $YARN_NM1_HOST
docker exec $YARN_RM /etc/write-hosts.sh $YARN_NM2_IP $YARN_NM2_HOST

# SSH config
YARN_RM_RSA=$(docker exec $YARN_RM cat /root/.ssh/id_rsa.pub)
YARN_NM1_RSA=$(docker exec $YARN_NM1 cat /root/.ssh/id_rsa.pub)
YARN_NM2_RSA=$(docker exec $YARN_NM2 cat /root/.ssh/id_rsa.pub)

# Enable SSH from host
if $USE_SSH; then
	HOST_RSA=$(cat ~/.ssh/id_rsa.pub)

	docker exec $YARN_RM /etc/write-auth-keys.sh $HOST_RSA
	docker exec $YARN_NM1 /etc/write-auth-keys.sh $HOST_RSA
	docker exec $YARN_NM2 /etc/write-auth-keys.sh $HOST_RSA
fi

# Start ssh service on slaves
docker exec $YARN_NM1 service ssh start
docker exec $YARN_NM2 service ssh start

# Start DNS service
docker exec $YARN_RM service dnsmasq start

# Zookeeper config
docker exec $YARN_RM /etc/write-zoo-myid.sh 1
docker exec $YARN_NM1 /etc/write-zoo-myid.sh 2
docker exec $YARN_NM2 /etc/write-zoo-myid.sh 3

# Start Zookeeper
docker exec $YARN_RM /usr/local/zookeeper/bin/zkServer.sh start
docker exec $YARN_NM1 /usr/local/zookeeper/bin/zkServer.sh start
docker exec $YARN_NM2 /usr/local/zookeeper/bin/zkServer.sh start

# Start Hazelcast on nodes
echo "Start hazelcast nodes ... "
docker exec -d $YARN_NM1 sh /usr/local/hazelcast/bin/server.sh
docker exec -d $YARN_NM2 sh /usr/local/hazelcast/bin/server.sh

# Start HDFS on slaves
# docker exec $YARN_NM1 /usr/local/hadoop/sbin/start-dfs.sh
# docker exec $YARN_NM2 /usr/local/hadoop/sbin/start-dfs.sh

docker exec $YARN_RM /etc/bootstrap.sh -bash

docker exec $YARN_RM /usr/local/hadoop/copy_runtime_to_hdfs.sh
