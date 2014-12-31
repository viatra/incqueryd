#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

mvn clean install
hu.bme.mit.incqueryd.runtime/scripts/start.sh
sleep 15s # XXX
cd hu.bme.mit.incqueryd.test
mvn verify -Dtest=**/ITDevelopment* -DinstanceIp=$1
cd ..
hu.bme.mit.incqueryd.runtime/scripts/stop.sh