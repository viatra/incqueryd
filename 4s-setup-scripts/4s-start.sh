#!/bin/bash
# kill other running instances
./4s-kill.sh

export FOURSTORE_CLUSTER_NAME="incqueryd_cluster"

rm -rf /var/lib/4store/$FOURSTORE_CLUSTER_NAME/*

# start new backend
4s-backend-setup -v $FOURSTORE_CLUSTER_NAME
4s-backend $FOURSTORE_CLUSTER_NAME
