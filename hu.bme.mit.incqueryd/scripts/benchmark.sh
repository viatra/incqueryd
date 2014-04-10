#!/bin/bash

cleanup()
{
  return $?
}

control_c()
# run if user hits control-c
{
  echo -en "\nInterrupt received, exiting.\n"
  cleanup
  exit $?
}

# trap keyboard interrupt (control-c)
trap control_c SIGINT

cd "$( cd "$( dirname "$0" )" && pwd )"

./deploy.sh --light

cd ..
cd hu.bme.mit.incqueryd.core/

rm executables.txt results.txt results_err.txt series.txt 2> /dev/null

minSize=1
maxSize=4
#seriesCount=1
seriesCount=2
#queries="PosLength"
queries="PosLength RouteSensor SignalNeighbor SwitchSensor"
timeout="12m"
scenario="XForm"
workspacePath="/home/szarnyasg/mondo-trainbenchmark/src/"
xmx=4G
maxPermSize=256M

rm results.txt 2> /dev/null
for i in `seq $seriesCount`; do
for query in ${queries[@]}; do

  echo $i >> series.txt

  # $size <= $max_size
  for ((size = $minSize; size <= $maxSize; size *= 2)); do
    echo `date` " 4store " $size $query

    sudo sync
    sudo bash -c "echo 3 > /proc/sys/vm/drop_caches"
    
    4s-ssh-all "~/init.sh"
    echo "Waiting for Akka to start."
    sleep 5

    vmargs="-XX:+UseCompressedOops -XX:MaxPermSize=$maxPermSize -Xmx$xmx"
    args="$defaultArgs -scenario $scenario -workspacePath $workspacePath -sizes $size -queries $query -seriesCount $i"
    args="$args -clusterName localvm"
    executable="java $vmargs -jar target/hu.bme.mit.incqueryd.core-0.0.1-SNAPSHOT.jar $args"

    echo $executable | tee -a executables.txt
    timeout -s KILL $timeout $executable | tee -a results.txt 2>> results_err.txt
    
    # do not try for larger sizes if this one timed out
    if [[ $? -eq 137 ]]; then
        break;
    fi

  # for $size
  done

# for $query
done

# for $i
done
