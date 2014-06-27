#!/bin/bash

#4s-ssh-all "~/start-server.sh --hazelcast"
4s-ssh-all "~/start-server.sh"
echo "Waiting for the servers to start."
sleep 5
