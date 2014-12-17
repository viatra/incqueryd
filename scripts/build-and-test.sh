#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

mvn clean install
echo "Press any key when the Infrastructure Agent is ready"
hu.bme.mit.incqueryd.runtime/scripts/start.sh
read -n 1 -s
cd hu.bme.mit.incqueryd.test
mvn verify -Dtest=**/ITDevelopment*
cd ..
hu.bme.mit.incqueryd.runtime/scripts/stop.sh