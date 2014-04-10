#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

machines="172.16.70.135 172.16.70.137"
#machines="vcl0 vcl1 vcl2 vcl3"

for machine in ${machines[@]}; do
  echo $machine

  cat scripts/init-default.sh | sed "s/export localHost=/export localHost=$machine/" > init.sh

  chmod +x init.sh
  scp init.sh $machine:
  rm init.sh

  # third party dependencies
  scp hu.bme.mit.incqueryd.core/target/lib/* $machine:akka-2.1.4/deploy
  
  # IncQuery-D's main JAR
  scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $machine:akka-2.1.4/deploy/
done

4s-ssh-all "~/init.sh"
