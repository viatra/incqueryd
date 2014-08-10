#!/bin/bash

# Script for installing IncQuery-D on the cloud. This includes:
# * light mode
#   * IncQuery-D core JAR file
#   * start-akka.sh
# * normal mode
#   * all of the above
#   * the dependencies of IncQuery-D core
#   * Akka microkernel and monitoring components

cd "$( cd "$( dirname "$0" )" && pwd )"
. config.sh
cd ..

AKKA_VERSION="2.1.4"
INSTALL_DIR=~/incqueryd/
AKKA_DEPLOY_DIRECTORY="$INSTALL_DIR/akka-$AKKA_VERSION/deploy/"
COORDINATOR_INSTALL_DIR="$INSTALL_DIR/coordinator/"
COORDINATOR_LIB_DIRECTORY="$COORDINATOR_INSTALL_DIR/lib/"

while [ "$1" != "" ]; do
	case $1 in
		"--light")
		light=true
		;;
	esac
	shift
done

for machine in ${machines[@]}; do
	echo "Deploying IncQuery-D on $machine"

	ssh $machine "mkdir -p $INSTALL_DIR/"

	scp -r scripts/components/* $machine:$INSTALL_DIR
	
	if [[ ! $light ]]; then
		# install Akka
		ssh $machine "$INSTALL_DIR/install-akka.sh"

		# clean the deploy directory
		ssh $machine "rm $AKKA_DEPLOY_DIRECTORY/*"

		# third party dependencies
		scp hu.bme.mit.incqueryd.core/target/lib/* $machine:$AKKA_DEPLOY_DIRECTORY
	fi

	# IncQuery-D's main JAR
	scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $machine:$AKKA_DEPLOY_DIRECTORY
done

# Installing the Main jar with the cordinator actor to the localhost
echo "Deploying IncQuery-D Main jar on localhost"

mkdir -p $COORDINATOR_INSTALL_DIR/
mkdir -p $COORDINATOR_LIB_DIRECTORY/

if [[ ! $light ]]; then
	rm -f $COORDINATOR_LIB_DIRECTORY/*
	# third party dependencies
	scp hu.bme.mit.incqueryd.core/target/lib/* localhost:$COORDINATOR_LIB_DIRECTORY
fi

# IncQuery-D's main JAR
scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar localhost:$COORDINATOR_INSTALL_DIR
