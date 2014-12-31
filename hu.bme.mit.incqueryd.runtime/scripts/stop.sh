#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

PID_FILE=infrastructure-agent.pid
if [ -f "$PID_FILE" ]
then
	CONTAINER=$(<"$PID_FILE")
    docker stop $CONTAINER
    docker rm $CONTAINER
    rm $PID_FILE
fi