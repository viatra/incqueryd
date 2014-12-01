FILE=main.py
wget https://raw.githubusercontent.com/FTSRG/incqueryd/master/BootstrapAgent/$FILE
sudo apt-get install python python-setuptools
sudo easy_install Werkzeug
python $FILE