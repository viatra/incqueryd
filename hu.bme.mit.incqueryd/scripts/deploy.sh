#!/bin/bash

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

cd "$( cd "$( dirname "$0" )" && pwd )/.."

for machine in ${machines[@]}; do
  echo $machine

  cat scripts/init-default.sh | sed "s/export localHost=/export localHost=$machine/" > init.sh

  chmod +x init.sh
  scp init.sh $machine:
  rm init.sh

  if [ ! $light ]; then
    # third party dependencies
    scp hu.bme.mit.incqueryd.core/target/lib/* $machine:akka-2.1.4/deploy
  fi

  # IncQuery-D's main JAR
  scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $machine:akka-2.1.4/deploy/
done

4s-ssh-all "~/init.sh"