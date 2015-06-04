#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

nohup java -cp ../hu.bme.mit.incqueryd.actorservice.server/target/hu.bme.mit.incqueryd.actorservice.server-*.jar hu.bme.mit.incqueryd.actorservice.server.ActorServiceApplication server > actor-service.log 2>&1
