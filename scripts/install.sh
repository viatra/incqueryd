#!/bin/bash

# This script is for installing the monitoring components of IncQuery-D
# Recently it installs the OS monitoring agents to the required hosts

cd "$( cd "$( dirname "$0" )" && pwd )/.."

INSTALL_DIR=~/incqueryd/monitoring/osagent/
INSTALL_LIB_DIR="$INSTALL_DIR/lib/"

case $1 in
	"--light")
	light=true
	shift
	;;
esac

if [[ $# -le 0 ]] ; then
    echo 'Usage: install.sh [--light] <machine-0-address> <machine-1-address> ...'
    exit 0
fi

# iterating through the hostnames of the machines
for machine in "$@"; do
	echo "Installing OS monitoring agent on $machine"

	ssh $machine "mkdir -p $INSTALL_DIR/"

	scp -r scripts/osagent/* $machine:$INSTALL_DIR
	
	if [[ ! $light ]]; then
		# clean the lib directory
		ssh $machine "rm -rf $INSTALL_LIB_DIR"

		# third party dependencies
		scp -r hu.bme.mit.incqueryd.osmonitoragent/target/lib/ $machine:$INSTALL_LIB_DIR
	fi

	# OS agent main JAR
	scp hu.bme.mit.incqueryd.osmonitoragent/target/osmonitor.core.jar $machine:$INSTALL_DIR
done
