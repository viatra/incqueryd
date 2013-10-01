#!/bin/bash

titan_master="vcl0"
hadoop_data="/home/meres/data/hadoop/tmp"
hadoop_logs="/usr/local/hadoop/logs"
TITAN_HOME="/home/meres/titan-all-0.3.2"

masters="10.6.23.91"
slaves=("10.6.23.92" "10.6.23.93" "10.6.23.94")
seeds=$masters
servers=("${masters[@]}" "${slaves[@]}")
username="meres"

#export TITAN_JAVA_OPTIONS="-Xms12G -Xmx12G -javaagent:/home/meres/titan/titan-dist/titan-dist-all/target/titan-all-standalone/lib/jamm-0.2.5.jar"
export TITAN_JAVA_OPTIONS="-Xms12G -Xmx12G -javaagent:$TITAN_HOME/lib/jamm-0.2.5.jar"


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
