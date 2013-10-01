# script if Debian/Ubuntu was installed with the sources.list pointing to the US servers
cd /etc/apt
mv sources.list sources.list.original
cat sources.list.original | sed "s/\.us\./\.hu\./" > sources.list
apt-get update
