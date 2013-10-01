#!/bin/bash

cd /usr/local/hadoop
bin/hadoop namenode -format -force
bin/start-all.sh
