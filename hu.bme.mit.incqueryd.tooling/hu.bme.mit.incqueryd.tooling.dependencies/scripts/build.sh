#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

mvn p2:site
