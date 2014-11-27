#!/bin/bash

# Script for uninstalling IncQuery-D

cd "$( cd "$( dirname "$0" )" && pwd )/.."

INSTALL_DIR=incqueryd/

# iterating through the hostnames of the machines
for machine in "$@"; do
	echo "Uninstalling IncQuery-D from $machine"

	ssh $machine "rm -rf $INSTALL_DIR/"
done
