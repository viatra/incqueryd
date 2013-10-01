#!/bin/bash
clusterName=$1
4s-httpd -p 8000 -s -1 $clusterName
