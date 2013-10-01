#!/bin/bash

#for i in `seq 10`; do

#echo $i >> series.txt

for tool in \
"rete" \
; do

vms=(vcl0 vcl1 vcl2 vcl3)
user=meres
cycles=50
nElemToModify=1

sizes="256"
#sizes="1 2 4 8 16 32 64 128 256 512"
#sizes="1024"
#sizes="128"

for size in $sizes; do

#if [[ "`./checkS`" != "" ]]; then
#  echo "Check environment sanity (no running test process, no mounted tmpfs), then press Ctrl-D" 1>&2
#  cat
# echo "Continuing..." 1>&2
#fi

echo `date` " " $tool " " $size > /dev/stderr

for vm in ${vms[*]}
do
  echo $vm: deploying neo4j
  # this is a (more or less) synchronized call
  ssh ${user}@${vm} '~/distributed-rete/scripts/start-remote.sh'

  if [[ $tool == "rete" ]]; then
    # warning: this call is asynchronous (as there is "no way" of telling when Akka is ready)
    echo $vm: deploying akka
    ssh ${user}@${vm} 'nohup akka-2.1.2/bin/akka distributed.rete.bootable.RemoteBootable > akka.out 2> akka.err < /dev/null &'
  fi
  echo $vm: deployed
done

echo tools started
sleep 60

/usr/bin/java -jar \
  -XX:MaxPermSize=256m -XX:+UseCompressedOops -Xmx512m \
  akka-2.1.2/deploy/distributed.rete.poc.jar $tool $size $cycles $nElemToModify

for vm in ${vms[*]}
do
  # this is a (more or less) synchronized call
  ssh ${user}@${vm} '~/distributed-rete/scripts/stop-remote.sh'
done

sleep 60

# for $ size
done

# for $tool
done

# for $i
#done
