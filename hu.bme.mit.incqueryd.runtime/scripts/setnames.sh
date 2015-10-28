#!/bin/bash

export IMAGE_VERSION=0.1

export IMAGE=incquerylabs/incqueryd:$IMAGE_VERSION

export YARN_RM=yarn-docker-rm

export YARN_NM=yarn-docker-node
export YARN_NM_HOST=yarn-node
export IQD_HOST=".docker"

export YARN_NM1=yarn-docker-node1

export YARN_NM2=yarn-docker-node2

export YARN_RM_HOST=yarn-rm.docker
export YARN_NM1_HOST=yarn-node1.docker
export YARN_NM2_HOST=yarn-node2.docker

export HDFS_MOUNT_POINT=/mnt/hdfs
export NAMENODE_PORT=9000
