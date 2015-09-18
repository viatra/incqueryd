#!/bin/sh

ZMYID=$1
NODEID=$2
LEADER=$3

cd /usr/local/zookeeper

if [ -n "$LEADER" ]; then
	echo "`bin/zkCli.sh -server $LEADER:2181 get /zookeeper/config|grep ^server`" >> ./conf/zoo.cfg.dynamic
	echo "server.$ZMYID=yarn-node$NODEID.docker:2888:3888:observer;2181" >> ./conf/zoo.cfg.dynamic
	cp ./conf/zoo.cfg.dynamic ./conf/zoo.cfg.dynamic.org
	./bin/zkServer-initialize.sh --force --myid=$ZMYID
	ZOO_LOG_DIR=/var/log ZOO_LOG4J_PROP='INFO,CONSOLE,ROLLINGFILE' ./bin/zkServer.sh start
	./bin/zkCli.sh -server $LEADER:2181 reconfig -add "server.$ZMYID=yarn-node$NODEID.docker:2888:3888:participant;2181"
else
	echo "server.$ZMYID=yarn-rm.docker:2888:3888;2181" >> ./conf/zoo.cfg.dynamic
	./bin/zkServer-initialize.sh --force --myid=$ZMYID
	ZOO_LOG_DIR=/var/log ZOO_LOG4J_PROP='INFO,CONSOLE,ROLLINGFILE' ./bin/zkServer.sh start
	
fi
