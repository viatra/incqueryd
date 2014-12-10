#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

java -cp hu.bme.mit.incqueryd.infrastructureagent/target/hu.bme.mit.incqueryd.infrastructureagent-*.jar hu.bme.mit.incqueryd.infrastructureagent.InfrastructureAgentApplication server