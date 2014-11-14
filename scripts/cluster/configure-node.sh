set -e
: ${1?"Required parameter: list of node IPs (semicolon separated)"}
sudo apt-get install -y docker.io
IMAGE=incqueryd/node
sudo docker build -t=$IMAGE .
export IPS=$1
sudo docker run $IMAGE sed -i "s/127\.0\.0\.1/$IPS/" /etc/4store.conf
sudo docker run -t -i --net=host $IMAGE /bin/bash