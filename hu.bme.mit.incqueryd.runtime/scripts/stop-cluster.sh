#!/bin/bash

source setnames.sh

docker stop $YARN_RM
docker stop $YARN_NM1
docker stop $YARN_NM2

docker rm $YARN_RM
docker rm $YARN_NM1
docker rm $YARN_NM2

