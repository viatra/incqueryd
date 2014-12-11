#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

kill -9 $(<coordinator.pid)