#!/bin/sh

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

java -Xdebug -agentlib:jdwp=transport=dt_socket,address=7779,server=y,suspend=n -jar ../target/hu.bme.mit.incqueryd.dashboard-0.0.1-SNAPSHOT-jar-with-dependencies.jar
