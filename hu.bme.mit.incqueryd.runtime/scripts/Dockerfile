FROM n3ziniuka5/ubuntu-oracle-jdk:14.04-JDK7

MAINTAINER IncQuery-D Team

USER root

# install tools
RUN apt-get update && apt-get -y install apt-transport-https
RUN wget http://archive.cloudera.com/cdh5/one-click-install/trusty/amd64/cdh5-repository_1.0_all.deb && sudo dpkg -i cdh5-repository_1.0_all.deb
RUN apt-get update && apt-get -y install curl tar sudo openssh-server openssh-client rsync nano telnet dnsmasq hadoop-hdfs-fuse

# passwordless ssh
# RUN ssh-keygen -q -N "" -t dsa -f /etc/ssh/ssh_host_dsa_key
# RUN ssh-keygen -q -N "" -t rsa -f /etc/ssh/ssh_host_rsa_key
RUN ssh-keygen -q -N "" -t rsa -f /root/.ssh/id_rsa
RUN cp /root/.ssh/id_rsa.pub /root/.ssh/authorized_keys
RUN cp /etc/ssh/ssh_host_rsa_key.pub /root/.ssh/known_hosts

# JAVA_HOME setup
ENV JAVA_HOME /usr/lib/jvm/java-7-oracle
ENV PATH $PATH:$JAVA_HOME/bin

# Download and install YARN (hadoop-2.6.0)
RUN curl -s http://xenia.sote.hu/ftp/mirrors/www.apache.org/hadoop/common/hadoop-2.6.0/hadoop-2.6.0.tar.gz | tar -xz -C /usr/local/
RUN cd /usr/local && ln -s ./hadoop-2.6.0 hadoop

ENV DEBIAN_FRONTEND noninteractive
ENV HADOOP_PREFIX /usr/local/hadoop
ENV HADOOP_COMMON_HOME /usr/local/hadoop
ENV HADOOP_HDFS_HOME /usr/local/hadoop
ENV HADOOP_MAPRED_HOME /usr/local/hadoop
ENV HADOOP_YARN_HOME /usr/local/hadoop
ENV HADOOP_CONF_DIR /usr/local/hadoop/etc/hadoop
ENV YARN_CONF_DIR $HADOOP_PREFIX/etc/hadoop

RUN echo "export HADOOP_PREFIX=/usr/local/hadoop" >> /etc/profile
RUN echo "export HADOOP_COMMON_HOME=/usr/local/hadoop" >> /etc/profile
RUN echo "export HADOOP_HDFS_HOME=/usr/local/hadoop" >> /etc/profile
RUN echo "export HADOOP_MAPRED_HOME=/usr/local/hadoop" >> /etc/profile
RUN echo "export HADOOP_YARN_HOME=/usr/local/hadoop" >> /etc/profile
RUN echo "export HADOOP_CONF_DIR=$HADOOP_PREFIX/etc/hadoop" >> /etc/profile
RUN echo "export YARN_CONF_DIR=$HADOOP_PREFIX/etc/hadoop" >> /etc/profile

RUN cd $HADOOP_PREFIX && ln -s $HADOOP_CONF_DIR conf

RUN sed -i '/^export JAVA_HOME/ s:.*:export JAVA_HOME=/usr/lib/jvm/java-7-oracle\nexport HADOOP_PREFIX=/usr/local/hadoop\nexport HADOOP_HOME=/usr/local/hadoop\n:' $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
RUN sed -i '/^export HADOOP_CONF_DIR/ s:.*:export HADOOP_CONF_DIR=/usr/local/hadoop/etc/hadoop/:' $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
#RUN . $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh

# pseudo distributed
ADD core-site.xml.template $HADOOP_PREFIX/etc/hadoop/core-site.xml.template
RUN sed s/HOSTNAME/localhost/ /usr/local/hadoop/etc/hadoop/core-site.xml.template > /usr/local/hadoop/etc/hadoop/core-site.xml
ADD hdfs-site.xml $HADOOP_PREFIX/etc/hadoop/hdfs-site.xml

ADD mapred-site.xml $HADOOP_PREFIX/etc/hadoop/mapred-site.xml
ADD yarn-site.xml $HADOOP_PREFIX/etc/hadoop/yarn-site.xml

ADD slaves $HADOOP_PREFIX/etc/hadoop/slaves

ADD add-dns-entry.sh /etc/add-dns-entry.sh
RUN chown root:root /etc/add-dns-entry.sh
RUN chmod 700 /etc/add-dns-entry.sh

ADD add-dns-entries.sh /etc/add-dns-entries.sh
RUN chown root:root /etc/add-dns-entries.sh
RUN chmod 700 /etc/add-dns-entries.sh

ADD write-auth-keys.sh /etc/write-auth-keys.sh
RUN chown root:root /etc/write-auth-keys.sh
RUN chmod 700 /etc/write-auth-keys.sh

ADD fix_networking.sh /etc/fix_networking.sh
RUN chown root:root /etc/fix_networking.sh
RUN chmod 700 /etc/fix_networking.sh

ADD add-yarn-node.sh /usr/local/hadoop/add-yarn-node.sh
RUN chown root:root /usr/local/hadoop/add-yarn-node.sh
RUN chmod 700 /usr/local/hadoop/add-yarn-node.sh

RUN $HADOOP_PREFIX/bin/hdfs namenode -format

ADD ssh_config /root/.ssh/config
RUN chmod 600 /root/.ssh/config
RUN chown root:root /root/.ssh/config

ADD bootstrap.sh /etc/bootstrap.sh
RUN chown root:root /etc/bootstrap.sh
RUN chmod 700 /etc/bootstrap.sh

ENV BOOTSTRAP /etc/bootstrap.sh

# workingaround docker.io build error
RUN ls -la /usr/local/hadoop/etc/hadoop/*-env.sh
RUN chmod +x /usr/local/hadoop/etc/hadoop/*-env.sh
RUN ls -la /usr/local/hadoop/etc/hadoop/*-env.sh

# Download and install ZooKeeper
RUN curl -s http://mirrors.ukfast.co.uk/sites/ftp.apache.org/zookeeper/zookeeper-3.5.1-alpha/zookeeper-3.5.1-alpha.tar.gz | tar -xz -C /usr/local/
RUN cd /usr/local && ln -s ./zookeeper-3.5.1-alpha zookeeper

RUN mkdir -p /var/lib/zookeeper

ADD zoo.cfg /usr/local/zookeeper/conf/zoo.cfg

ADD write-zoo-myid.sh /etc/write-zoo-myid.sh
RUN chown root:root /etc/write-zoo-myid.sh
RUN chmod 700 /etc/write-zoo-myid.sh

ADD start-zk-server.sh /usr/local/zookeeper/bin/start-zk-server.sh
RUN chown root:root /usr/local/zookeeper/bin/start-zk-server.sh
RUN chmod 700 /usr/local/zookeeper/bin/start-zk-server.sh

# Install Spark
RUN curl -s http://static.incquerylabs.com/projects/incquery-d/spark-iqd-1.5.0.tgz | tar -xz -C /usr/local/
RUN cd /usr/local && ln -s ./spark-1.5.0-bin-iqd-spark-1.5 spark

ENV SPARK_HOME=/usr/local/spark
RUN echo "export SPARK_HOME=/usr/local/spark" >> /etc/profile
RUN echo "export SPARK_CLASSPATH=$SPARK_HOME/lib/" >> /etc/profile

ADD start_spark.sh /usr/local/spark/start_spark.sh
RUN chown root:root /usr/local/spark/start_spark.sh
RUN chmod 700 /usr/local/spark/start_spark.sh

# Install Hazelcast
RUN cd /tmp/ && curl -s -o hazelcast-3.4.5.tar.gz http://download.hazelcast.com/download.jsp --data "version=hazelcast-3.4.5&type=tar&p=118961842"
RUN tar -xzf /tmp/hazelcast-3.4.5.tar.gz -C /usr/local/
RUN cd /usr/local && ln -s ./hazelcast-3.4.5 hazelcast

ENV HZ_HOME /usr/local/hazelcast
RUN echo "export HZ_HOME=/usr/local/hazelcast" >> /etc/profile
RUN cd $HZ_HOME/lib && curl -s -o snowcast-1.0.0-RC1.jar http://central.maven.org/maven2/com/noctarius/snowcast/snowcast/1.0.0-RC1/snowcast-1.0.0-RC1.jar

ADD hz_server.sh $HZ_HOME/bin/server.sh
RUN chown root:root $HZ_HOME/bin/server.sh
RUN chmod 700 $HZ_HOME/bin/server.sh

ADD hazelcast.xml $HZ_HOME/bin/hazelcast.xml

# Add dnsmasq.conf file
ADD dnsmasq.conf /etc/dnsmasq.conf
ADD dnsmasq.resolv.conf /etc/dnsmasq.resolv.conf

# Install mosquitto
RUN curl -s -o mosquitto-repo.gpg.key http://repo.mosquitto.org/debian/mosquitto-repo.gpg.key
RUN apt-key add mosquitto-repo.gpg.key
RUN cd /etc/apt/sources.list.d/ && curl -s -o mosquitto-wheezy.list http://repo.mosquitto.org/debian/mosquitto-wheezy.list
RUN apt-get update
RUN apt-get -y install mosquitto

# Add scripts
ADD copy_runtime_to_hdfs.sh /usr/local/hadoop/copy_runtime_to_hdfs.sh
RUN chmod 700 /usr/local/hadoop/copy_runtime_to_hdfs.sh

# Initialize HDFS mount
RUN sudo mkdir -p /mnt/hdfs # XXX duplicated

EXPOSE 50020 50090 50070 50010 50075 8031 8032 8033 8040 8042 49707 22 8088 8030 19888 2888 3888 2181 2182 10020 19888 2552
# XXX duplicated ports
