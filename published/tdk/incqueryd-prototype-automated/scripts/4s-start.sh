#!/bin/bash

FOURSTORE_DIR=/var/lib/4store
FOURSTORE_CLUSTER_NAME="incquery_d_cluster"

# kill other running instances
killall 4s-backend -v
killall 4s-backend -v
killall 4s-httpd -v
killall 4s-httpd -v

# delete previous data
sudo rm -rf FOURSTORE_DIR/*

# start new backend
4s-backend-setup -v $FOURSTORE_CLUSTER_NAME
4s-backend $FOURSTORE_CLUSTER_NAME
