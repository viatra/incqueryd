#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

while [ "$1" != "" ]; do
	case $1 in
		"--resolveDependencies")
		resolveDependencies=true
		;;
	esac
	shift
done

if [ $resolveDependencies ]; then
	scripts/resolve-dependencies.sh || exit 1
fi

hu.bme.mit.incqueryd.monitoring/scripts/build.sh && \
hu.bme.mit.incqueryd.arch/scripts/build.sh && \
hu.bme.mit.incqueryd.allocation.csp/scripts/build.sh && \
hu.bme.mit.incqueryd.stats/scripts/build.sh && \
hu.bme.mit.incqueryd.runtime/scripts/build.sh && \
hu.bme.mit.incqueryd.tooling/scripts/build.sh
