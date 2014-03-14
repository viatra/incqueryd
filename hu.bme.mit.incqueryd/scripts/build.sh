#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
mvn clean install -DskipTests || exit 1
