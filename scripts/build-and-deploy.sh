#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

source hu.bme.mit.incqueryd.runtime/scripts/setnames.sh

mvn install -DskipTests
docker exec $YARN_RM /usr/local/hadoop/copy_runtime_to_hdfs.sh
