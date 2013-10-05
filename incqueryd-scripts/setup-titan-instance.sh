#!/bin/bash

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

if [ $# -ne 2 ]; then
  echo "Usage: setup-titan.sh token listen_address"
  exit
fi

# naming arguments
token=$1
listen_address=$2

# wait for the cassandra process to finish
while [[ ! -z `ps auxw | grep cassandra-thrif[t]` || ! -z `ps auxw | grep "bin/titan\.sh"` ]]; do
	sleep 1
done

# creating directories for data storage and logs
purge_directory "/tmp/cassandra"
purge_directory "/var/log/cassandra"

cd ~

# cleanup
## unlink titan
rm -rf titan-all-0.3.2

# unpacking Titan
unzip -o -q titan-all-0.3.2.zip

# create a symbolic link to the current version
## ln -s titan-all-0.3.2 titan

cd $TITAN_HOME/config

# cassandra.yaml

# mandatory configurations
sed -i "s/initial_token:$/initial_token: $token/" cassandra.yaml
sed -i "s/- seeds: \"127.0.0.1\"$/- seeds: \"$seeds\"/" cassandra.yaml
sed -i "s/listen_address: localhost$/listen_address: $listen_address/" cassandra.yaml
sed -i "s/rpc_address: localhost$/rpc_address: $listen_address/" cassandra.yaml
sed -i "s/thrift_framed_transport_size_in_mb:$/thrift_framed_transport_size_in_mb: 110/" cassandra.yaml
sed -i "s/thrift_max_message_length_in_mb:$/thrift_max_message_length_in_mb: 120/" cassandra.yaml
