#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

containers=`docker inspect --format='{{.Name}}' $(docker ps -aq --no-trunc) | grep yarn-docker`

for cont in $containers
do
	cont=${cont:1:${#cont}}
	docker stop $cont 
	docker rm $cont
done
