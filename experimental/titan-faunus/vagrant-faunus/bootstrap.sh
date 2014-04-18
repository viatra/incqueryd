#!/bin/bash

function purge_directory() {
	dir=$1

	# create directory if it does not exist, delete content if it does
	if [ ! -d $1 ]; then
		sudo mkdir $1
	else
		rm -rf $1/*
	fi

	sudo chown -R $OWNER:$GROUP $1
}

SOURCE_DIR=/vagrant
HOME_DIR=/home/vagrant
OWNER=vargant
GROUP=vagrant

cd $HOME_DIR
cat .bashrc $SOURCE_DIR/hadoop-bashrc > .bashrc-new
mv .bashrc-new .bashrc

# creating hadoop tmp dir
sudo mkdir -p /app/hadoop/tmp
sudo chown $OWNER:$GROUP /app/hadoop/tmp

# unpacking hadoop
cd /usr/local
sudo tar xzf $SOURCE_DIR/installers/hadoop-1.1.2-bin.tar.gz
sudo mv hadoop-1.1.2 hadoop
sudo chown -R $OWNER:$GROUP hadoop
cp $SOURCE_DIR/hadoop-conf/* /usr/local/hadoop/conf/

# unzipping Aurelius applications
cd $HOME_DIR
unzip -q $SOURCE_DIR/installers/faunus-0.3.1.zip
unzip -q $SOURCE_DIR/installers/titan-all-0.3.1.zip 

# copying Faunus/Gremlin script
cp $SOURCE_DIR/faunus-script/* $HOME_DIR/faunus-0.3.1

# copying scripts
cp $SOURCE_DIR/faunus-scripts/* $HOME_DIR/faunus
cp $SOURCE_DIR/titan-scripts/* $HOME_DIR/titan

# setting up keyless SSH for Hadoop
ssh-keygen -t rsa -f .ssh/id_rsa -P ""
cat .ssh/id_rsa.pub >> .ssh/authorized_keys
ssh -oStrictHostKeyChecking=no localhost

# unzipping Cassadra
cd $HOME_DIR
tar xf $SOURCE_DIR/installers/apache-cassandra-1.2.8-bin.tar.gz

purge_directory "/var/lib/cassandra"
purge_directory "/var/log/cassandra"
