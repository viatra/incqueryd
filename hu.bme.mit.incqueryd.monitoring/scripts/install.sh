#!/bin/bash

# This script is for installing the monitoring components of IncQuery-D
# Recently it installs the OS monitoring agents to the required hosts

cd "$( cd "$( dirname "$0" )" && pwd )/.."

INSTALL_DIR=incqueryd/monitoring/osagent/
SERVER_INSTALL_DIR=incqueryd/monitoring/server/
INSTALL_LIB_DIR="$INSTALL_DIR/lib/"

case $1 in
	"--light")
	light=true
	shift
	;;
esac

if [[ $# -le 0 ]] ; then
    echo 'Usage: install.sh [--light] <monitoring-address> <machine-0-address> <machine-1-address> ...'
    exit 0
fi

monitoring=$1
shift

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

ssh $monitoring "mkdir -p $SERVER_INSTALL_DIR/"

# Copying the server starting script(s) to the coordinator's install idrectory
scp -r scripts/server/* $monitoring:$SERVER_INSTALL_DIR

# Server main JAR
scp hu.bme.mit.incqueryd.monitoringserver.dw-server/target/dw-server-*-SNAPSHOT.jar $monitoring:$SERVER_INSTALL_DIR

ssh $monitoring "echo \"collectorInterface: $monitoring\" > $SERVER_INSTALL_DIR/config.yml"

echo Monitoring components installed.
