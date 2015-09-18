#!/bin/bash
. ./constants.sh

set -e

sudo 4s-backend-setup $DATABASE
sudo 4s-backend $DATABASE