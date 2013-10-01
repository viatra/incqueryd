#!/bin/bash
export JAVA_OPTIONS="-Xms6G -Xmx6G"
bin/gremlin.sh < load.txt
