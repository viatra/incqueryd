#!/bin/bash

FOURSTORE_CLUSTER_NAME="incqueryd_cluster"
SPARQL="SPARQL/vertex-pairs.sparql"

4s-query $FOURSTORE_CLUSTER_NAME "`cat $SPARQL`" -s -1 > results.txt
head -n 50 results.txt
wc -l results.txt
rm results.txt
