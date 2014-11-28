#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/../"

hu.bme.mit.incqueryd.core/scripts/download-akka.sh
scripts/build.sh --resolveDependencies --noTooling
