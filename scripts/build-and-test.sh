#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

mvn clean install --offline
hu.bme.mit.incqueryd.runtime/scripts/start.sh
sleep 15s # XXX
cd hu.bme.mit.incqueryd.test
mvn verify -Dtest=**/ITDevelopment*
cd ..
hu.bme.mit.incqueryd.runtime/scripts/stop.sh