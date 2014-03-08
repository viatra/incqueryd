#!/bin/bash

./4s-import RDF-models/testBig1.owl
. trainbenchmark-poslength.sh
. trainbenchmark-routesensor.sh
. trainbenchmark-signalneighbor.sh
. trainbenchmark-switchsensor.sh
