#!/bin/sh

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

java -jar ../target/hu.bme.mit.incqueryd.dashboard-0.0.1-SNAPSHOT-jar-with-dependencies.jar
