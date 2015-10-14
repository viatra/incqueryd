#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

./build.sh -DskipTests
cd ../hu.bme.mit.incqueryd.runtime/scripts
./restart.sh 2
