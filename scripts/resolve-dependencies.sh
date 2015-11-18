#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

cd ..
git clone https://github.com/FTSRG/mondo-utils.git
cd mondo-utils
git pull
scripts/build.sh --resolveDependencies

cd ..
git clone https://github.com/FTSRG/rdf-graph-drivers.git
cd rdf-graph-drivers
git pull
scripts/build.sh --resolveDependencies

cd ..
git clone http://git.eclipse.org/gitroot/paho/org.eclipse.paho.mqtt.java.git
cd org.eclipse.paho.mqtt.java
git pull
mvn clean install -DskipTests -Dmaven.javadoc.skip=true
