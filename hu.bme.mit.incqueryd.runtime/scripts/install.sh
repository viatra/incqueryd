#!/bin/bash

# Script for installing IncQuery-D on the cloud. This includes:
# * light mode
#   * IncQuery-D core JAR file
#   * start-akka.sh
# * full mode (default)
#   * all of the above
#   * the dependencies of IncQuery-D core
#   * Akka microkernel and monitoring components

cd "$( cd "$( dirname "$0" )" && pwd )/.."

AKKA_VERSION="2.1.4"
INSTALL_DIR=~/incqueryd/
AKKA_DEPLOY_DIR="$INSTALL_DIR/akka-$AKKA_VERSION/deploy/"
COORDINATOR_INSTALL_DIR="$INSTALL_DIR/coordinator/"
COORDINATOR_LIB_DIR="$COORDINATOR_INSTALL_DIR/lib/"

case $1 in
	"--light")
	light=true
	shift
	;;
esac

if [[ $# -le 1 ]] ; then
    echo 'Usage: install.sh [--light] <coordinator-address> <machine-0-address> <machine-1-address> ...'
    exit 0
fi

coordinator=$1
shift

# iterating through the hostnames of the machines
for machine in "$@"; do
	echo "Deploying IncQuery-D on $machine"

	ssh $machine "mkdir -p $INSTALL_DIR/"

	scp -r scripts/components/* $machine:$INSTALL_DIR
	
	if [[ ! $light ]]; then
		# install Akka
		ssh $machine "$INSTALL_DIR/install-akka.sh"

		# clean the deploy directory
		ssh $machine "rm $AKKA_DEPLOY_DIR/*"

		# third party dependencies
		scp hu.bme.mit.incqueryd.core/target/lib/* $machine:$AKKA_DEPLOY_DIR
	fi

	# IncQuery-D's main JAR
	scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $machine:$AKKA_DEPLOY_DIR
done

# deploying to the coordinator

echo "Creating directories on the coordinator."

ssh $coordinator "mkdir -p $COORDINATOR_INSTALL_DIR"
ssh $coordinator "mkdir -p $COORDINATOR_LIB_DIR"
ssh $coordinator "mkdir -p $COORDINATOR_INSTALL_DIR/arch/"
ssh $coordinator "mkdir -p $COORDINATOR_INSTALL_DIR/recipes/"

# Installing the Main jar with the cordinator actor to the localhost
echo "Deploying IncQuery-D Main jar to the coordinator."

if [[ ! $light ]]; then
	rm -f $COORDINATOR_LIB_DIR/*
	# third party dependencies
	scp hu.bme.mit.incqueryd.core/target/lib/* $coordinator:$COORDINATOR_LIB_DIR
fi

# Copying the coordinator starting script(s) to the coordinator's install idrectory
scp scripts/coordinator/* $coordinator:$COORDINATOR_INSTALL_DIR

# IncQuery-D's main JAR
scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $coordinator:$COORDINATOR_INSTALL_DIR
