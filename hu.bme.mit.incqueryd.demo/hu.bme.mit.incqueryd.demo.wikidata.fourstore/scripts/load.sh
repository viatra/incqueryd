#!/bin/bash
. ./constants.sh

set -e

COMPRESSED=wikidata.nt.gz
curl -o $COMPRESSED 'http://tools.wmflabs.org/wikidata-exports/rdf/exports/20150817/wikidata-simple-statements.nt.gz'
gunzip $COMPRESSED
EXTRACTED=wikidata.nt
PREFIX=wikidata_part
split -d -l 5000000 $EXTRACTED $PREFIX 
for FILE in $PREFIX*
do
  SUFFIXED=$FILE.nt
  mv "$FILE" "$SUFFIXED"
  ESCAPED=$FILE_escaped.nt
  uni2ascii -a U $SUFFIXED > $ESCAPED
  sudo 4s-import $DATABASE $ESCAPED
done
