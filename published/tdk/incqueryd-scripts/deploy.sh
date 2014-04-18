#!/bin/bash

# constants
user=szarnyasg
akkaver=2.1.4
akkadir=~/akka-$akkaver
projectname=incqueryd-prototype
projectdir=~/workspace_java/$projectname
bootableclass=bootable.RemoteBootable

# variables
maven=true
coordinator=${machines[0]}

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
  mvn clean install
  mv target/$projectname*.jar target/$projectname.jar
fi

# copying to coordinator
echo $coordinator
scp target/$projectname.jar $user@$coordinator:$akkadir/deploy/

for ((i = 1; i < ${#machines[@]}; ++i))
do
  machine=${machines[i]}
  echo $machine
  ssh $user@$coordinator "scp $akkadir/deploy/$projectname.jar $user@$machine:$akkadir/deploy"
done

echo Done.
