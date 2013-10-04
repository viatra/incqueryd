#!/bin/bash

source cluster-data.sh

wd=`pwd`

echo Starting Titan cluster.
./init-titan-cluster.sh

# stop Hadoop
echo Stopping Hadoop.
cd /usr/local/hadoop
bin/stop-mapred.sh
bin/stop-dfs.sh

echo Deleting Hadoop data and logs.
# sending asynchronous termination for all servers
for server in ${servers[*]}; do
	echo "rm -rf $hadoop_data/*" | ssh ${username}@${server} bash -s
	echo "rm -rf $hadoop_logs/*" | ssh ${username}@${server} bash -s
done

echo Formatting HDFS.
bin/hadoop namenode -format -force
echo Starting Hadoop
bin/start-dfs.sh
bin/start-mapred.sh

# - either manual control (press CTRL+C to continue)
watch --interval 1 ~/apache-cassandra/bin/nodetool status
# - or some sensible amount of sleep
#sleep 20

# initialize Titan indices
echo Initializing Titan indices.
cd $wd
scriptfile=`mktemp`
sed "s/<HOSTNAME>/$titan_master/" titan-scripts/init-index.txt > $scriptfile 
$TITAN_HOME/bin/gremlin.sh < $scriptfile

echo
