#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

java -cp hu.bme.mit.incqueryd.agent/target/hu.bme.mit.incqueryd.agent-1.0.0-SNAPSHOT.jar hu.bme.mit.incqueryd.agent.Agent server