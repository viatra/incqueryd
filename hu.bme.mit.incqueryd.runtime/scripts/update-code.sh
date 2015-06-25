#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

./stop.sh
../../scripts/build.sh -DskipTests=true
./start.sh
