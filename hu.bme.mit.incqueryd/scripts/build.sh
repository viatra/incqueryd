#!/bin/bash

cd "$(dirname "$0")/.."

export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
mvn clean install || exit 1
