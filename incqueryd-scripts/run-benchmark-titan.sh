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
size=1

# $size <= $max_size
while [ $size -le $max_size ]
do
  echo `date` " Titan " $size

  sudo sync
  sudo bash -c "echo 3 > /proc/sys/vm/drop_caches"
  
  4s-ssh-all "pkill -f akk[a]"

  echo Starting Titan/Faunus cluster
  cd ~/incqueryd/incqueryd-scripts/
  ./restart-faunus-cluster.sh

  echo Starting Akka
  4s-ssh-all-parallel "nohup $AKKADIR/bin/akka distributed.rete.bootable.RemoteBootable > akka.out 2> akka.err < /dev/null &"
  
  sleep 20

  /usr/local/hadoop/bin/hadoop dfs -copyFromLocal /home/szarnyasg/models/faunus-graphson/testBig_User_${size}.faunus-graphson /user/szarnyasg/testBig_User_${size}.faunus-graphson

  cd
#  java -jar \
#    -XX:MaxPermSize=256m -XX:+UseCompressedOops -Xms512M -Xmx512M \
#    $AKKADIR/deploy/incqueryd-prototype.jar Titan testBig_User_${size} load

#  java -jar \
#    -XX:MaxPermSize=256m -XX:+UseCompressedOops -Xms1G -Xmx1G \
#    $AKKADIR/deploy/incqueryd-prototype.jar Titan /home/szarnyasg/models/faunus-graphson/testBig_User_${size} load
  java -XX:MaxPermSize=256m -XX:+UseCompressedOops -Xms512M -Xmx512M -cp "akka-2.1.4/deploy/*:/usr/local/hadoop/conf" distributed.rete.main.ReteMain Titan testBig_User_${size} load



  sleep 10

  size="$(($size * 2))"
# for $size
done

# for $tool
#done

# for $i
done
