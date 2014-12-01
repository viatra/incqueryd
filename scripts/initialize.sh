#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/../"

scripts/build.sh --resolveDependencies --noTooling
