#!/bin/bash

killall java
sleep 4

for tool in \
"control" \
"rete" \
; do

vms=(vcl0 vcl1 vcl2 vcl3)
user=meres

sizes="1"
#todo
#sizes="1 2 4 8 16 32 64 128 256 512"

for size in $sizes; do

if [[ "`./checkS`" != "" ]]; then
  echo "Check environment sanity (no running test process, no mounted tmpfs), then press Ctrl-D" 1>&2
  cat
 echo "Continuing..." 1>&2
fi

echo `date` " " $tool " " $size > /dev/stderr

for vm in ${vms[*]}
do
  echo deploying on $vm
  #ssh ${user}@${vm} 'bash -s' < start-remote.sh
  ssh ${user}@${vm} './start-remote.sh' &
done

sleep 25 # todo change to 60

/usr/bin/java -jar \
  -XX:MaxPermSize=256m -XX:+UseCompressedOops -Xmx512m \
  akka-2.1.2/deploy/distributed.rete.poc-0.0.1-SNAPSHOT.jar $tool $size

for vm in ${vms[*]}
do
  ssh ${user}@${vm} 'bash -s' < stop-remote.sh
done

sleep 10 # todo change to 60

done
done
