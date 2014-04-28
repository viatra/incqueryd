#!/bin/bash

4s-ssh-all "~/start-server.sh --hazelcast"
echo "Waiting for the servers to start."
sleep 5
