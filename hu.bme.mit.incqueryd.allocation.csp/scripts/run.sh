#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

java -Djava.library.path=native/linux/x86_64 -cp target/*:target/lib/* hu.bme.mit.incqueryd.csp.main.AllocationMain -recipe /home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/recipes/switchSensor.recipe -inventory /home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/inventory/Sample.inventory -objectiveFunction communication -architecture /tmp/opt.arch
