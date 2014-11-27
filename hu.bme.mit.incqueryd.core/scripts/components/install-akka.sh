#!/bin/bash

AKKA_VERSION=2.1.4
INSTALL_DIR=~/incqueryd/
AKKA_PATH=$INSTALL_DIR/akka-$AKKA_VERSION

cd $INSTALL_DIR
tar xf akka-$AKKA_VERSION.tgz
cp -r akka/* akka-2.1.4

cd $INSTALL_DIR
