#!/bin/bash

stop lightdm
stop bluetooth
stop whoopsie
stop cron
stop atd
stop mysql

for i in `seq 0 1`; do
cpufreq-set -g performance -c $i
done
