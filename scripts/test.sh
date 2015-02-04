#!/bin/bash

if (( "$#" != 1 )) 
then
    echo "Required parameter: the running machine's IP address"
exit 1
fi

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

hu.bme.mit.incqueryd.runtime/scripts/start.sh
sleep 15s # XXX
cd hu.bme.mit.incqueryd.test
mvn verify -Dtest=**/Development* -DinstanceIp=$1
cd ..
hu.bme.mit.incqueryd.runtime/scripts/stop.sh