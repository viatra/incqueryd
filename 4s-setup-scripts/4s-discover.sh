#!/bin/bash
HOSTS=`avahi-browse -at | grep IPv4 | grep _4store | cut -d " " -f 6 | cut -d "-" -f 1`
while read -r HOSTS; do
  hostToIP="$HOSTS"; avahi-browse -atr 2> /dev/null | sed -n '/Workstation/,+2p' | sed -n '/IPv4/,+2p' | sed -n '/'$hostToIP'/,+2p' | grep 'address' | cut -d "[" -f 2 | cut -d "]" -f 1
done <<< "$HOSTS"

