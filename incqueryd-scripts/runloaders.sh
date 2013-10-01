#!/bin/bash

sizes="1 2 4 8 16 32 64 128 256 512 1024 2048"
#sizes="4096"

rm results.txt

for size in $sizes; do
  echo ========================= $size =========================

  cat gremlinscript.txt | sed s/SIZE/$size/ > gremlinscript_current.txt
  (time bin/gremlin.sh -e gremlinscript_current.txt) 2>&1 | tee -a results.txt
done
