#!/bin/bash
sh kill-4s.sh
4s-backend-setup test
4s-backend test
4s-httpd -p 8000 -s -1 test
