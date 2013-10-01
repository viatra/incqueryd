#!/bin/bash
# kill other running instances
source kill-4s.sh

# delete previous data
sudo rm -rf /var/lib/4store/*

export FOURSTORE_CLUSTER_NAME="incqueryd_cluster"

# start new backend
4s-backend-setup -v $FOURSTORE_CLUSTER_NAME
4s-backend $FOURSTORE_CLUSTER_NAME
