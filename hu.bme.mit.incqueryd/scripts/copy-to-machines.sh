#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

machines="vm0 vm1"

for machine in ${machines[@]}; do
  echo $machine

  # third party dependencies
  scp hu.bme.mit.incqueryd.core/target/lib/* $machine:akka-2.1.4/deploy
  
  # IncQuery-D's main JAR
  scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $machine:akka-2.1.4/deploy/
done
