#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

./build.sh && ./install.sh
