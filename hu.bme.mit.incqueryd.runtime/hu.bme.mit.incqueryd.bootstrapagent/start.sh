#!/bin/sh
FILE=main.py
wget https://raw.githubusercontent.com/FTSRG/incqueryd/issues/35/hu.bme.mit.incqueryd.runtime/hu.bme.mit.incqueryd.bootstrapagent/$FILE
sudo apt-get install python python-setuptools
sudo easy_install Werkzeug
python $FILE