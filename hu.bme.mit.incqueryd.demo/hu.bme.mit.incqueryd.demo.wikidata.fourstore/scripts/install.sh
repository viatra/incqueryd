#!/bin/bash

sudo mkdir -p /var/lib/4store
sudo chown $USER:$USER /var/lib/4store/

sudo touch /etc/4store.conf
sudo chown $USER:$USER /etc/4store.conf

sudo apt-get install -y software-properties-common
sudo apt-add-repository "deb http://ppa.launchpad.net/yves-raimond/ppa/ubuntu precise main"
sudo apt-add-repository "deb-src http://ppa.launchpad.net/yves-raimond/ppa/ubuntu precise main"
sudo apt-get update
sudo apt-get install -y --force-yes 4store

