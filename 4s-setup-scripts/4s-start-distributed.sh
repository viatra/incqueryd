#!/bin/bash
# kill other running instances
killall 4s-backend -v

# set query specific variables

# cluster name
clusterName=$1
# number of nodes in cluster
nodesInCluster=$2
# node id: 0...(cluster-1)
nodeId=$3

# start new backend
# TODO check the semantics of the --mirror argument
4s-backend-setup -v --cluster $nodesInCluster --node $nodeId --segments 16 $clusterName
4s-backend $clusterName
