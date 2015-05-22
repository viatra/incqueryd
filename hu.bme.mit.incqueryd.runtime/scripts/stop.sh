#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

./stop-old.sh
./stop-cluster.sh
