#!/bin/bash

FOURSTORE_CLUSTER_NAME="trainbenchmark_cluster"
SPARQL="SPARQL/$1.sparql"

echo TrainBenchmark query: $1

4s-query $FOURSTORE_CLUSTER_NAME -f text "`cat $SPARQL`" -s -1 | tail -n +2 > results.txt
head -n 10 results.txt
wc -l results.txt
rm results.txt
