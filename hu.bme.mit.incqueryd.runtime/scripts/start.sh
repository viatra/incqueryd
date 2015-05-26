#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

source setnames.sh

./build_image.sh

# Start containers
docker run --dns 127.0.0.1 -p 127.0.0.1:53:53/udp --hostname $YARN_RM_HOST --name $YARN_RM -i -t -d $IMAGE
YARN_RM_IP=$(docker inspect --format="{{.NetworkSettings.IPAddress}}" $YARN_RM)

docker run --dns $YARN_RM_IP --hostname $YARN_NM1_HOST --name $YARN_NM1 -i -t -d $IMAGE 
docker run --dns $YARN_RM_IP --hostname $YARN_NM2_HOST --name $YARN_NM2 -i -t -d $IMAGE 

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
HOST_RSA=$(cat ~/.ssh/id_rsa.pub)

docker exec $YARN_RM /etc/write-auth-keys.sh $HOST_RSA
docker exec $YARN_NM1 /etc/write-auth-keys.sh $HOST_RSA
docker exec $YARN_NM2 /etc/write-auth-keys.sh $HOST_RSA

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

# Start HDFS on slaves
# docker exec $YARN_NM1 /usr/local/hadoop/sbin/start-dfs.sh
# docker exec $YARN_NM2 /usr/local/hadoop/sbin/start-dfs.sh

docker exec $YARN_RM /etc/bootstrap.sh -bash

./scp_to_rm.sh

docker exec $YARN_RM /usr/local/hadoop/run_demo.sh

# Legacy Actor Service

cd ..
docker build -t=$OLD_IMAGE .
docker run -d --name $OLD_CONTAINER -p 8084:8084 -p 8094:8094 -p 2552:2552 -p 2553:2553 $OLD_IMAGE /bin/bash -c incqueryd/scripts/bootstrap-old.sh # XXX duplicated ports and path
echo "Started container $OLD_CONTAINER"

docker exec $OLD_CONTAINER /etc/write-hosts.sh $YARN_RM_IP $YARN_RM_HOST
docker exec $OLD_CONTAINER /etc/write-hosts.sh $YARN_NM1_IP $YARN_NM1_HOST
docker exec $OLD_CONTAINER /etc/write-hosts.sh $YARN_NM2_IP $YARN_NM2_HOST
