#!/bin/bash

# constants
#vms="localhost"
#vms="vm0"
vms="vm0 vm1 vm2 vm3"

user=szarnyasg
akkadir=akka-2.1.2
projectdir=~/workspace_java/clustergraphloader
bootableclass=clustergraphloader.bootable.RemoteBootable

# variables
maven=true

while getopts ":n" opt; do
  case $opt in
    n)
      echo "Running with no Maven compilation." >&2
      maven=false
      ;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      ;;
  esac
done

cd $projectdir

if $maven ; then
  # skip tests for faster compilation
  mvn clean compile package assembly:single -DskipTests
  # cut the extension
  mv target/clustergraphloader-1.0.0.war target/clustergraphloader.war
  mv target/clustergraphloader-1.0.0*.jar target/clustergraphloader.jar
  cp target/clustergraphloader.war ~/apache-tomcat-7.0.40/webapps/clustergraphloader.war
fi

# cleanup
# 1) run Cassandra nodes
# 2) run remote Akka microkernels

for vm in $vms; do
  echo $vm
  scp -r target/clustergraphloader.jar $user@$vm:$akkadir/deploy/clustergraphloader.jar

  # akka
  ssh ${user}@${vm} "rm akka.*"
  ssh ${user}@${vm} "pkill -f akka"
  ssh ${user}@${vm} "nohup $akkadir/bin/akka $bootableclass > akka.out 2> akka.err < /dev/null &"
  
done

