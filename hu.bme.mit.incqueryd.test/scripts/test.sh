#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

mvn verify -Dtest=**/ITDevelopment*