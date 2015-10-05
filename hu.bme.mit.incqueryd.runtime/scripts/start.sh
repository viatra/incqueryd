#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

source setnames.sh

./build_image.sh

./start_node.sh rm -local ${@:2}

for i in $(seq 1 $1);
do
	./start_node.sh $i -local ${@:2}
done

docker exec $YARN_RM /usr/local/hadoop/copy_runtime_to_hdfs.sh
