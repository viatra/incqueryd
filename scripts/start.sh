set -e
sudo apt-get install -y docker.io
IMAGE=incqueryd/node
sudo docker build -t=$IMAGE ..
sudo docker run -e IPS=$1 -d -p 2552:2552 -p 2553:2553 -p 2554:2554 -p 2555:2555 -p 8080:8080 -p 9090:9090 $IMAGE /bin/bash -c scripts/init-container.sh
