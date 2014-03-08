#!/bin/bash

./4s-import.sh RDF-models/t1.owl
. trainbenchmark-poslength.sh
. trainbenchmark-routesensor.sh
. trainbenchmark-signalneighbor.sh
. trainbenchmark-switchsensor.sh
