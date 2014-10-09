#!/bin/bash

java -Djava.library.path=native/linux/x86_64 -cp target/*:target/lib/* hu.bme.mit.incqueryd.csp.main.Main -recipe /home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/recipes/switchSensor.recipe -inventory /home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/inventory/Sample.inventory -objectivefunction communication -architecture /tmp/opt.arch -objectivefunction cost
