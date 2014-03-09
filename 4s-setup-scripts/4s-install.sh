#!/bin/bash
# installs 4store's dependencies, compiles and installs 4store

# prompting for sudo password if necessary
sudo echo > /dev/null

mkdir 4s-install
cd 4s-install

fourstore_version=1.1.5
raptor_version=2.0.6
rasqal_version=0.9.28

wget http://download.librdf.org/source/raptor2-$raptor_version.tar.gz
wget http://download.librdf.org/source/rasqal-$rasqal_version.tar.gz
wget http://4store.org/download/4store-v$fourstore_version.tar.gz

tar -xf raptor2-$raptor_version.tar.gz 
tar -xf rasqal-$rasqal_version.tar.gz 
tar -xf 4store-v$fourstore_version.tar.gz 

# dependencies
sudo apt-get install -y gcc make libxml2-dev uuid-dev avahi-discover libnss-mdns build-essential libpcre3-dev libtool libglib2.0-dev ncurses-dev libreadline-dev libavahi-client-dev libavahi-glib-dev

cd raptor2-$raptor_version
./configure
make
sudo make install

cd ..
cd rasqal-$rasqal_version
./configure
make
sudo make install

sudo ldconfig
cd ..
cd 4store-v$fourstore_version
./configure 
make
sudo make install
make test

