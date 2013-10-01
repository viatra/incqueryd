#!/bin/bash
# kill other running instances
source kill-4s.sh

export FOURSTORE_CLUSTER_NAME="demo1"

# start new backend
4s-backend-setup -v $FOURSTORE_CLUSTER_NAME
4s-backend $FOURSTORE_CLUSTER_NAME

cd RDF-models
4s-import $FOURSTORE_CLUSTER_NAME $1
cd ..

