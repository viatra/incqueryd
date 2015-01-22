#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

cd ..
git clone https://github.com/FTSRG/mondo-utils.git
cd mondo-utils
git pull
scripts/build.sh --resolveDependencies

cd ..
git clone https://github.com/FTSRG/rdf-graph-drivers.git
cd rdf-graph-drivers
git pull
scripts/build.sh --resolveDependencies