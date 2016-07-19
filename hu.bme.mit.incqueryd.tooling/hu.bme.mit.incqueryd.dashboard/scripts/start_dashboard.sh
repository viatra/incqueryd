#!/bin/sh

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

HDFS_MOUNT_POINT=/mnt/iqdhdfs

sudo umount -f $HDFS_MOUNT_POINT

sudo mkdir -p $HDFS_MOUNT_POINT || true

sudo hadoop-fuse-dfs dfs://yarn-rm.docker:9000 $HDFS_MOUNT_POINT || true

sudo chown -R root:root $HDFS_MOUNT_POINT

sudo java -jar ../target/hu.bme.mit.incqueryd.dashboard-0.0.1-SNAPSHOT-jar-with-dependencies.jar
