#!/bin/bash

AKKA_VERSION=2.1.4
INSTALL_DIR=~
AKKA_PATH=$INSTALL_DIR/akka-$AKKA_VERSION

cd $INSTALL_DIR
wget -nc http://download.akka.io/downloads/akka-$AKKA_VERSION.tgz
tar xf akka-$AKKA_VERSION.tgz

# patch Akka to use monitoring
cd $AKKA_PATH/bin
mv $INSTALL_DIR/akka.patch .
patch < akka.patch
cd ../..

mv $INSTALL_DIR/application.conf $AKKA_PATH/config

wget -nc http://trainbenchmark.inf.mit.bme.hu/akka/typesafe-console-developer-1.3.1.tar.gz

# SIGAR
tar xf typesafe-console-developer-1.3.1.tar.gz
mkdir -p $AKKA_PATH/lib/akka/weaver
cp typesafe-console-developer-1.3.1/lib/weaver/aspectjweaver.jar $AKKA_PATH/lib/akka/weaver

# Akka ATMOS
cp -r typesafe-console-developer-1.3.1/lib/sigar $AKKA_PATH/lib/akka
cd $AKKA_PATH/lib/akka
wget -nc http://repo.typesafe.com/typesafe/releases/com/typesafe/atmos/trace-akka-2.1.4/1.3.1/trace-akka-2.1.4-1.3.1.jar
wget -nc http://repo.typesafe.com/typesafe/releases/com/typesafe/atmos/trace-scala-2.10.2/1.3.1/trace-scala-2.10.2-1.3.1.jar
wget -nc http://repo.typesafe.com/typesafe/releases/com/typesafe/atmos/atmos-event_2.10/1.3.1/atmos-event_2.10-1.3.1.jar
wget -nc http://repo.typesafe.com/typesafe/releases/com/typesafe/atmos/atmos-trace_2.10/1.3.1/atmos-trace_2.10-1.3.1.jar
wget -nc http://central.maven.org/maven2/org/fusesource/sigar/1.6.4/sigar-1.6.4.jar
wget -nc http://labs.consol.de/maven/repository/org/jolokia/jolokia-jvm/1.1.5/jolokia-jvm-1.1.5-agent.jar

cd $INSTALL_DIR
