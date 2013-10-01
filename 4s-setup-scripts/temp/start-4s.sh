#!/bin/bash
killall 4s-backend -v
killall 4s-httpd -v
4s-backend-setup test
4s-backend test
4s-httpd -p 8000 -s -1 test
