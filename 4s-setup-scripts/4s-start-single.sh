#!/bin/bash
# kill other running instances
source 4s-kill.sh

export FOURSTORE_CLUSTER_NAME="incqueryd_cluster"

# start new backend
4s-backend-setup -v $FOURSTORE_CLUSTER_NAME
4s-backend $FOURSTORE_CLUSTER_NAME
