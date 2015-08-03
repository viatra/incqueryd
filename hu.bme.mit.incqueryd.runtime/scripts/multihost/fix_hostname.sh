#!/bin/sh

sudo printf '%s\n\n' "$(tail -n +2 /etc/hosts)" > /etc/hosts
sudo echo $1 > /etc/hostname
