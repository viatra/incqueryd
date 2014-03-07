#!/bin/bash

pkill -f 4s-backen[d]

while [[ ! -z `ps auxw | grep 4s-backen[d]` ]]; do
	sleep 1
done
