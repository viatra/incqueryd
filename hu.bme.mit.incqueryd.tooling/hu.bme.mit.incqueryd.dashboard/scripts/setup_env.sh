#!/bin/bash

wget http://archive.cloudera.com/cdh5/one-click-install/trusty/amd64/cdh5-repository_1.0_all.deb && sudo dpkg -i cdh5-repository_1.0_all.deb

rm cdh5-repository_1.0_all.deb

sudo apt-get update && sudo apt-get -y install hadoop-hdfs-fuse
