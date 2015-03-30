#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

./build.sh
./test.sh $1