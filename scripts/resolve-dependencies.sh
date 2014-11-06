#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

cd ../..
git clone https://github.com/FTSRG/4store-graph-driver.git
cd 4store-graph-driver
git pull
scripts/build.sh --resolveDependencies

