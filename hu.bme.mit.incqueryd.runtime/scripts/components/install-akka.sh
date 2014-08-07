#!/bin/bash

AKKA_VERSION=2.1.4
INSTALL_DIR=~/incqueryd/
AKKA_PATH=$INSTALL_DIR/akka-$AKKA_VERSION

mkdir -p $INSTALL_DIR
cd $INSTALL_DIR

wget -nc http://download.akka.io/downloads/akka-$AKKA_VERSION.tgz
tar xf akka-$AKKA_VERSION.tgz
cp -r akka/* akka-2.1.4

cd $INSTALL_DIR
