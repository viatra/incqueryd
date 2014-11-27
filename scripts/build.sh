#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

while [ "$1" != "" ]; do
	case $1 in
		"--resolveDependencies")
		resolveDependencies=true
		;;
		"--noTooling")
		noTooling=true
		;;
	esac
	shift
done

if [ $resolveDependencies ]; then
	scripts/resolve-dependencies.sh || exit 1
fi

export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
mvn clean install || exit 1

if [ ! $noTooling ]; then
	hu.bme.mit.incqueryd.tooling/scripts/build.sh || exit 1
fi
