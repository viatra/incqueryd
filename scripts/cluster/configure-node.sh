set -e
: ${1?"Required parameter: list of node IPs (semicolon separated)"}
sudo apt-get install -y docker.io
IMAGE=incqueryd/node
export IPS=$1
sudo docker build -t=$IMAGE .
sudo docker run -t -i --net=host $IMAGE /bin/bash