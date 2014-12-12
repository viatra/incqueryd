#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

PID_FILE=coordinator.pid
if [ -f "$PID_FILE" ]
then
    kill -9 $(<"$PID_FILE")
fi