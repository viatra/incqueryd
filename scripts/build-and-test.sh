#!/bin/bash

if (( "$#" != 1 )) 
then
    echo "Required parameter: the running machine's IP address"
exit 1
fi

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

./build.sh
./test.sh $1