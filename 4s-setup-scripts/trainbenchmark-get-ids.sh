#!/bin/bash
4s-query incqueryd_cluster -f text "`cat SPARQL/$1.sparql`" -s -1 | tail -n +2 | sed "s/<http:\/\/www.semanticweb.org\/ontologies\/2011\/1\/TrainRequirementOntology.owl#//g" | sed "s/>//g" | sort -n
