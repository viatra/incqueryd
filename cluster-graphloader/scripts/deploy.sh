#!/bin/bash

# constants
#vms="vm0 vm1 vm2 vm3"
#vms="vm0"
vms="localhost"
user=szarnyasg
akkadir=akka-2.1.2
projectdir=~/workspace_java/xmlparser
bootableclass=bootable.RemoteBootable

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
  mvn clean compile package
  # cut the extension
  mv target/xmlparser-*.jar target/xmlparser.jar
fi

# cleanup

# ?
# killall java 2> /dev/null

# see also:
#   pkill -f akka

# 1) run Cassandra nodes
# 2) run remote Akka actors
# 3) run coordinator actor

for vm in $vms; do
  echo $vm
  scp -r target/xmlparser.jar $user@$vm:$akkadir/deploy/

  #ssh ${user}@${vm} "nohup $akkadir/bin/akka $bootableclass > akka.out 2> akka.err < /dev/null &"
done

cd
akka-2.1.2/bin/akka clustergraphloader.bootable.RemoteBootable

# run coordinator
#/usr/bin/java -jar -XX:MaxPermSize=256m -XX:+UseCompressedOops -Xmx512m target/myakka.remote.test $tool $size $cycles $nElemToModify
