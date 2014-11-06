#!/bin/bash

# This scripts starts the monitoring server on a machine

export SERVER_DIR=~/incqueryd/monitoring/server/

cd $SERVER_DIR

rm -f monserver.err monserver.out $SERVER_DIR 2> /dev/null

nohup java -jar dw-server-*-SNAPSHOT.jar server config.yml > $SERVER_DIR/monserver.out 2> $SERVER_DIR/monserver.err < /dev/null &
