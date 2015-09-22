#!/bin/bash

sudo mkdir -p /var/lib/4store
sudo chown $USER:$USER /var/lib/4store/

sudo touch /etc/4store.conf
sudo chown $USER:$USER /etc/4store.conf

sudo apt-get install 4store
