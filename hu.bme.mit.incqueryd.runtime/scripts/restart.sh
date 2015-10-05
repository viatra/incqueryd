#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

./stop.sh
./start.sh "$@"
