#!/bin/bash
# kill other running instances
source 4s-start-multiple.sh

# set query specific variables
name="demo1"
sparql="PosLength.sparql"
grepped="xSegment"

# start new backend
4s-backend-setup -v --cluster 2 --node 0 --segments 16 $name
4s-backend $name
cd RDF-models
4s-import $name t1.owl 
4s-query $name "`cat $sparql`" -s -1 
4s-query demo1 "`cat PosLength.sparql`" -s -1
