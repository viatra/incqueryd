#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

java -cp hu.bme.mit.incqueryd.infrastructureagent/target/hu.bme.mit.incqueryd.infrastructureagent-1.0.0-SNAPSHOT.jar hu.bme.mit.incqueryd.infrastructureagent.InfrastructureAgent server