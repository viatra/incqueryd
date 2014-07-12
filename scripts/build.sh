#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

hu.bme.mit.incqueryd.arch/scripts/build.sh && \
hu.bme.mit.incqueryd.runtime/scripts/build.sh && \
hu.bme.mit.incqueryd.tooling/scripts/build.sh

