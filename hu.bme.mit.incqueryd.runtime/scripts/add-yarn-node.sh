#!/bin/bash

cd /usr/local/hadoop

source conf/hadoop-env.sh

export HADOOP_LIBEXEC_DIR=/usr/local/hadoop/libexec && sbin/yarn-daemon.sh start nodemanager && sbin/hadoop-daemon.sh start datanode
