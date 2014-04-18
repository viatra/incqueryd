#!/bin/bash

sudo mount -t nfs 10.82.23.9:/srv/iqd-storage /home/szarnyasg/models

sudo sed -i "s/AllowUsers root/AllowUsers root szarnyasg/" /etc/ssh/sshd_config 
sudo bash -c "echo 'ListenAddress 127.0.0.1' >> /etc/ssh/sshd_config"
sudo service ssh restart
ssh localhost
