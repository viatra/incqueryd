#!/bin/bash
akka_version=akka-2.1.2
wget http://download.akka.io/downloads/$akka_version.tgz
tar -zxf $akka_version.tgz
cp -R distributed-rete/akka-conf/* $akka_version/
