#!/bin/bash

# 4store benchmark sequence script

for i in `seq 5`; do
echo $i >> series.txt

#for tool in \
#"rete" \
#; do

AKKADIR=akka-2.1.4
FOURSTORE_CLUSTER_NAME="incqueryd_cluster"

max_size=1024
size=1024

# $size <= $max_size
while [ $size -le $max_size ]
do
  echo `date` " 4store " $size

  sudo sync
  sudo bash -c "echo 3 > /proc/sys/vm/drop_caches"
  
  4s-cluster-stop $FOURSTORE_CLUSTER_NAME
  sleep 10
  echo deleting 4store data directory
  4s-ssh-all "rm -rf /var/lib/4store/*"

  echo starting 4store cluster
  4s-cluster-create $FOURSTORE_CLUSTER_NAME
  4s-cluster-start $FOURSTORE_CLUSTER_NAME
  sleep 10

  java -jar -Xms1G -Xmx1G incqueryd-4s-control/target/incqueryd-4s-control-0.0.1-SNAPSHOT.jar /home/szarnyasg/models/owl/testBig_User_${size} 50

  size="$(($size * 2))"
# for $size
done

# for $tool
#done

# for $i
done
