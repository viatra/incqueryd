#!/bin/bash

# Script for deploying IncQuery-D on the cloud. This includes:
# * light mode
#   * IncQuery-D core JAR file
#   * start-akka.sh
# * normal mode
#   * all of the above
#   * the dependencies of IncQuery-D core
# * install mode
#   * Akka microkernel and monitoring components

cd "$( cd "$( dirname "$0" )" && pwd )"
. config.sh
cd ..

AKKA_DEPLOY_DIRECTORY="akka-2.1.4/deploy"

while [ "$1" != "" ]; do
	case $1 in
		"--install")
		install=true
		;;
	esac
	case $1 in
		"--normal")
		normal=true
		;;
	esac
	case $1 in
		"--light")
		light=true
		;;
	esac
	shift
done

for machine in ${machines[@]}; do
	echo "Deploying IncQuery-D on $machine"

	cd scripts/deployable
	cat start-akka-default.sh | sed "s/export localHost=/export localHost=$machine/" > start-akka.sh
	chmod +x start-akka.sh
	scp * $machine:
	rm start-akka.sh
	cd ../..

	if [ $install ]; then
		ssh $machine "~/install-akka.sh"
	fi

	if [[ $normal || $install ]]; then
		# clean the deploy directory
		ssh $machine "rm $AKKA_DEPLOY_DIRECTORY/*"

		# third party dependencies
		scp hu.bme.mit.incqueryd.core/target/lib/* $machine:$AKKA_DEPLOY_DIRECTORY
	fi

	# IncQuery-D's main JAR
	scp hu.bme.mit.incqueryd.core/target/hu.bme.mit.incqueryd.core-*-SNAPSHOT.jar $machine:$AKKA_DEPLOY_DIRECTORY
done

