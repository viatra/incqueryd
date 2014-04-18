#!/bin/bash

sizes="1 2 4 8 16 32 64 128 256 512 1024 2048 4096"
rm results.txt

for size in $sizes; do
  echo Size: $size | tee -a results.txt
  sed "s/User_SIZE/User_$size/" gs.txt > gs_current.txt
  (time bin/gremlin.sh < gs_current.txt) 2>&1 | tee -a results.txt
done
