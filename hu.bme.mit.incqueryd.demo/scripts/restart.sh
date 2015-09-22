#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

cd ../hu.bme.mit.incqueryd.runtime/scripts
./restart.sh 2
cd ../../hu.bme.mit.incqueryd.demo/scripts
./build.sh
./run.sh
