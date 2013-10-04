#!/bin/bash

source cluster-data.sh

function download_and_deploy() {
	url=$1
	filename=$2

	echo "Downloading and deploying: $filename to $servers"
	if [ ! -f $filename ]; then
		wget $url
		for server in ${servers[*]}; do
			echo "Copying $filename to $server"
			scp $filename $server:
		done
	fi
}

function run_titan() {
	username=$1
	host=$2
	ssh ${username}@${host} 'export JAVA_OPTIONS="'$TITAN_JAVA_OPTIONS'"; cd '$TITAN_HOME'; nohup bin/titan.sh config/titan-server-rexster.xml config/titan-server-cassandra.properties > titan.out.txt 2> titan.err.txt < /dev/null &'
}

# set these values for the current URLs/versions
titan_url="http://s3.thinkaurelius.com/downloads/titan/titan-all-0.3.2.zip"
titan_filename="titan-all-0.3.2.zip"

# set these values for your cluster
number_of_servers=${#servers[@]}
wd=`pwd`

cd

# downloading Titan
# download_and_deploy $titan_url $titan_filename

# going back to the working directory (where the scripts are stored)
cd $wd

# sending asynchronous termination for all servers
for server in ${servers[*]}; do
	cat stop-titan.sh | ssh ${username}@${server} bash -s
done

echo

# running synchronous scripts on all servers which waits for Titan to finish
for ((i = 0; i < $number_of_servers; i++)); do
	server=${servers[$i]}
	echo "$server: setting up Titan."
	listen_address=$server
	server_index=$i

	line_number=$(($server_index + 1))
	token=`$wd/token-generator.py $number_of_servers | sed $line_number"q;d"`

	cat setup-titan-instance.sh | ssh ${username}@${server} bash -s - $token $seeds $listen_address
	echo "$server: Titan set up."
	echo
done

# start Titan on the master node
for master in ${masters[*]}; do
	echo "Starting Titan on master: $master"
	run_titan $username $master
done

# start Titan on the slave nodes
for slave in ${slaves[*]}; do
	echo "Starting Titan on slave: $slave"
	run_titan $username $slave
done

watch --interval 1 ~/apache-cassandra/bin/nodetool status
