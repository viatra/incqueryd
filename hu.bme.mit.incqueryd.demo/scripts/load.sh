#!/bin/bash

set -e

COMPRESSED=wikidata.nt.gz
curl -o $COMPRESSED 'http://tools.wmflabs.org/wikidata-exports/rdf/exports/20150817/wikidata-simple-statements.nt.gz'
EXTRACTED=wikidata.nt
gunzip $COMPRESSED
ESCAPED=wikidata_escaped.nt
uni2ascii -a U $EXTRACTED > $ESCAPED
sudo 4s-import wikidata $ESCAPED