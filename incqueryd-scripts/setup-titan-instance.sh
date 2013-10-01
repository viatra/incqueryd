#!/bin/bash

TITAN_HOME=/home/meres/titan-all-0.3.2

function purge_directory() {
	dir=$1

	# create directory if it does not exist, delete content if it does
	if [ ! -d $1 ]; then
		sudo mkdir $1
	else
		rm -rf $1/*
	fi

	sudo chown -R $USER: $GROUP $1
}

if [ $# -ne 3 ]; then
  echo "Usage: setup-titan.sh token seeds listen_address"
  exit
fi

# naming arguments
token=$1
seeds=$2
listen_address=$3

# wait for the cassandra process to finish
while [[ ! -z `ps auxw | grep cassandra-thrif[t]` || ! -z `ps auxw | grep "titan\.sh"` ]]; do
	sleep 1
done

# creating directories for data storage and logs
purge_directory "/tmp/cassandra"
purge_directory "/var/log/cassandra"

cd ~

# cleanup
## unlink titan
## rm -rf titan-all-0.3.2

# unpacking Titan
## unzip -o -q titan-all-0.3.2.zip

# create a symbolic link to the current version
## ln -s titan-all-0.3.2 titan

cd $TITAN_HOME
cd config

# cassandra.yaml

# mandatory configurations
sed -i "s/initial_token:$/initial_token: $token/" cassandra.yaml
sed -i "s/- seeds: \"127.0.0.1\"$/- seeds: \"$seeds\"/" cassandra.yaml
sed -i "s/listen_address: localhost$/listen_address: $listen_address/" cassandra.yaml
sed -i "s/rpc_address: localhost$/rpc_address: $listen_address/" cassandra.yaml
sed -i "s/thrift_framed_transport_size_in_mb:$/thrift_framed_transport_size_in_mb: 110/" cassandra.yaml
sed -i "s/thrift_max_message_length_in_mb:$/thrift_max_message_length_in_mb: 120/" cassandra.yaml

# optional configurations
# sed -i "s/cluster_name: 'Test Cluster'/cluster_name: 'Titan Cluster'/" cassandra.yaml
# sed -i "s/# num_tokens: 256/num_tokens: 256/" cassandra.yaml
#sed -i "s/endpoint_snitch: SimpleSnitch/endpoint_snitch: RackInferringSnitch/" cassandra.yaml

# titan-server-cassandra.properties
# maybe worth bumping it to 250 000
# echo >> titan-server-cassandra.properties

#echo "ids.block-size=100000" >> titan-server-cassandra.properties
#echo "ids.block-size=250000" >> titan-server-cassandra.properties
