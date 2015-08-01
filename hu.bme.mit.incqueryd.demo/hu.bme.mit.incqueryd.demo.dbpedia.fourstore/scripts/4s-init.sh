#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

echo "[4s-boss]
discovery = sole
nodes = 127.0.0.1

[dbpedia]
port = 7891" > /etc/4store.conf
