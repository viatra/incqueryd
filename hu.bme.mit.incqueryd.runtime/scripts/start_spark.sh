#!/bin/bash

$SPARK_HOME/bin/spark-submit \
	--class hu.bme.mit.incqueryd.spark.IQDSparkMain \
	--master yarn-cluster \
	--num-executors 3 \
	--driver-memory 1g \
	--executor-memory 512m \
	--driver-java-options -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n \
	/tmp/target/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar
