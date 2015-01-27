#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

CONTAINER=incqueryd
docker stop $CONTAINER
docker rm $CONTAINER