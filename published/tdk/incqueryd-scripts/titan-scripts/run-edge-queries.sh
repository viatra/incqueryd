#!/bin/bash

labels="ROUTE_ENTRY ROUTE_EXIT ROUTE_ROUTEDEFINITION ROUTE_SWITCHPOSITION SWITCHPOSITION_SWITCH TRACKELEMENT_SENSOR TRACKELEMENT_CONNECTSTO"
for label in $labels; do
  echo $label
  sed "s/<LABEL>/$label/" ~/titan-scripts/titan-scripts/edge-query-template.txt > edge-query.txt
  time bin/gremlin.sh < edge-query.txt > edges-$label.txt
done
