set -e
: ${1?"Required parameter: list of node IPs (semicolon separated)"}
sudo apt-get install -y docker.io
IMAGE=incqueryd/node
sudo docker build -t=$IMAGE .
sudo docker run -e IPS=$1 -d -p 50022:22 -p 9090:9090 $IMAGE /bin/bash -c ./init-container.sh
