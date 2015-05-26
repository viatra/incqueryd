#!/bin/bash

set -e
cd "$( cd "$( dirname "$0" )" && pwd )"

CLUSTER_DNS_SERVER='127.0.0.1'
HOSTS='/etc/hosts'
RESOLV_CONF='/etc/resolv.conf'

# First clear hosts file
source setnames.sh
sudo sed -i "/$YARN_RM_HOST/d" $HOSTS
sudo sed -i "/$YARN_NM1_HOST/d" $HOSTS
sudo sed -i "/$YARN_NM2_HOST/d" $HOSTS

sudo sed -i "/$CLUSTER_DNS_SERVER/d" $RESOLV_CONF
sudo sed -i "1inameserver $CLUSTER_DNS_SERVER" $RESOLV_CONF

