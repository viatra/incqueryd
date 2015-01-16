#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

PID_FILE=actor-system.pid
if [ -f "$PID_FILE" ]
then
    kill -9 $(<"$PID_FILE")
    rm $PID_FILE
fi