#!/bin/bash

# Script for deploying the IncQuery-D on the cloud. This includes:
# * light mode
#   * IncQuery-D core JAR file
#   * start-akka.sh
# * full mode
#   * all of the above
#   * the dependencies of IncQuery-D core

cd "$( cd "$( dirname "$0" )" && pwd )"
. config.sh

while [ "$1" != "" ]; do
	case $1 in
		"--light")
		light=true
		;;
	esac
	shift
done

for machine in ${machines[@]}; do
  echo "Deploying IncQuery-D on $machine"

  cat scripts/start-akka-default.sh | sed "s/export localHost=/export localHost=$machine/" > start-akka.sh
  chmod +x start-akka.sh
  scp start-akka.sh $machine:
  rm start-akka.sh

  if [ ! $light ]; then
    # third party dependencies
    scp hu.bme.mit.incqueryd.core/target/lib/* $machine:akka-2.1.4/deploy
  fi

  # IncQuery-D's main JAR
  scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $machine:akka-2.1.4/deploy/
done

