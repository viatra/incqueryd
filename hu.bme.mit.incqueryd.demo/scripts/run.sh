#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

java -jar hu.bme.mit.incqueryd.demo.wikidata.main/target/hu.bme.mit.incqueryd.demo.wikidata.main-1.0.0-SNAPSHOT.jar