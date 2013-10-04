#!/bin/bash

# 4store benchmark sequence script

#for i in `seq 10`; do
#echo $i >> series.txt

#for tool in \
#"rete" \
#; do

AKKADIR=akka-2.1.4
FOURSTORE_CLUSTER_NAME="incqueryd_cluster"

max_size=1
size=1

# $size <= $max_size
while [ $size -le $max_size ]
do
  echo `date` " " $tool " " $size
  
  4s-cluster-stop $FOURSTORE_CLUSTER_NAME
  echo killing processes
  4s-ssh-all "pkill -f akka"
  4s-ssh-all "pkill -f incquery"
  echo deleting 4store data directory
  4s-ssh-all "rm -rf /var/lib/4store/*"

  echo starting akka
  4s-ssh-all-parallel "nohup $AKKADIR/bin/akka distributed.rete.bootable.RemoteBootable > akka.out 2> akka.err < /dev/null &"
  
  sleep 20

  echo starting 4store cluster
  4s-cluster-create $FOURSTORE_CLUSTER_NAME
  4s-cluster-start $FOURSTORE_CLUSTER_NAME

  java -jar \
    -XX:MaxPermSize=256m -XX:+UseCompressedOops -Xms1G -Xmx1G \
    $AKKADIR/deploy/incqueryd-prototype.jar 4store /home/szarnyasg/models/owl/testBig_User_${size} load

  sleep 10

  size="$(($size * 2))"
# for $size
done

# for $tool
#done

# for $i
#done
