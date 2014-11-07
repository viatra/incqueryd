#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/../"

hu.bme.mit.incqueryd.runtime/scripts/download-akka.sh
scripts/build.sh --resolveDependencies --noTooling
