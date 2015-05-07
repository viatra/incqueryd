#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

scp ../hu.bme.mit.incqueryd.runtime/hu.bme.mit.incqueryd.actorservice.server/target/hu.bme.mit.incqueryd.actorservice.server-*.jar root@yarn-rm.docker:/tmp/
