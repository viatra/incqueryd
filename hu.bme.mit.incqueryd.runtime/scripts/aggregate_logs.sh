#!/bin/bash

for i in {1..3}
do
	/usr/local/hadoop/bin/hadoop fs -copyFromLocal -f /usr/local/hadoop/logs/userlogs/* /logs
	sleep 20
done
