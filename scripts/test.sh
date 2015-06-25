#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

cd ../hu.bme.mit.incqueryd.runtime/scripts
./stop.sh || true
./start.sh
sleep 15s # XXX
cd ../../hu.bme.mit.incqueryd.test
mvn verify -Dtest=**/IT*
cd ../hu.bme.mit.incqueryd.runtime/scripts
./stop.sh
