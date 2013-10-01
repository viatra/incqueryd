 #!/bin/bash 
rm log.txt
COUNTER=0
while [  $COUNTER -lt 1000 ]; do
  let COUNTER=COUNTER+1 
  echo $COUNTER
  java -jar target/distributed.rete.poc-0.0.1-SNAPSHOT-jar-with-dependencies.jar >> log.txt
  cat log.txt | grep "Join resulted in 186"
done
