#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

echo "Press any key when the Infrastructure Agent is ready"
hu.bme.mit.incqueryd.runtime/scripts/start.sh
read -n 1 -s
hu.bme.mit.incqueryd.test/scripts/test.sh
hu.bme.mit.incqueryd.runtime/scripts/stop.sh