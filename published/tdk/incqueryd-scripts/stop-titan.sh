#!/bin/bash

# kill Cassandra process asynchronously
# look for the "bin/../lib/cassandra-thrift-x.y.z.jar" string
pkill -f "cassandra-thrift"
pkill -f "bin/titan\.sh"
