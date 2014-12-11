#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

[ ! -f coordinator.pid ] && kill -9 $(<coordinator.pid)
