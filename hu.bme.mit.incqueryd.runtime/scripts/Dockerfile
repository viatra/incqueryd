FROM n3ziniuka5/ubuntu-oracle-jdk:14.04-JDK7

MAINTAINER IncQuery-D Team

USER root

# install tools
RUN apt-get update && apt-get -y install curl tar sudo openssh-server openssh-client rsync nano telnet dnsmasq maven

# passwordless ssh
# RUN ssh-keygen -q -N "" -t dsa -f /etc/ssh/ssh_host_dsa_key
# RUN ssh-keygen -q -N "" -t rsa -f /etc/ssh/ssh_host_rsa_key
RUN ssh-keygen -q -N "" -t rsa -f /root/.ssh/id_rsa
RUN cp /root/.ssh/id_rsa.pub /root/.ssh/authorized_keys
RUN cp /etc/ssh/ssh_host_rsa_key.pub /root/.ssh/known_hosts

# JAVA_HOME setup
ENV JAVA_HOME /usr/lib/jvm/java-7-oracle
ENV PATH $PATH:$JAVA_HOME/bin
ENV MAVEN_OPTS="-Xmx2048m -XX:MaxPermSize=1024m"

# Download and install YARN (hadoop-2.6.0)
RUN curl -s http://www.eu.apache.org/dist/hadoop/common/hadoop-2.6.0/hadoop-2.6.0.tar.gz | tar -xz -C /usr/local/
RUN cd /usr/local && ln -s ./hadoop-2.6.0 hadoop

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
ADD write-hosts.sh /etc/write-hosts.sh
RUN chown root:root /etc/write-hosts.sh
RUN chmod 700 /etc/write-hosts.sh


ADD write-auth-keys.sh /etc/write-auth-keys.sh
RUN chown root:root /etc/write-auth-keys.sh
RUN chmod 700 /etc/write-auth-keys.sh


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
RUN curl -s http://mirrors.ukfast.co.uk/sites/ftp.apache.org/zookeeper/stable/zookeeper-3.4.6.tar.gz | tar -xz -C /usr/local/
RUN cd /usr/local && ln -s ./zookeeper-3.4.6 zookeeper

RUN mkdir -p /var/lib/zookeeper

ADD zoo.cfg /usr/local/zookeeper/conf/zoo.cfg

ADD write-zoo-myid.sh /etc/write-zoo-myid.sh
RUN chown root:root /etc/write-zoo-myid.sh
RUN chmod 700 /etc/write-zoo-myid.sh

ADD zkServer.sh /usr/local/zookeeper/bin/zkServer.sh
RUN chown root:root /usr/local/zookeeper/bin/zkServer.sh
RUN chmod 700 /usr/local/zookeeper/bin/zkServer.sh

# Install SPARK

# Build spark
# RUN curl -s http://xenia.sote.hu/ftp/mirrors/www.apache.org/spark/spark-1.4.1/spark-1.4.1.tgz | tar xz -C /usr/local/
# RUN cd /usr/local && ln -s ./spark-1.4.1 spark
# RUN /usr/local/spark/dev/change-version-to-2.11.sh
# RUN cd /usr/local/spark/ && mvn -Pyarn -Phadoop-2.6 -Dscala-2.11 -DskipTests clean package

# Install pre-build spark
RUN curl -s http://apache.mirrorcatalogs.com/spark/spark-1.4.1/spark-1.4.1-bin-hadoop2.6.tgz | tar xz -C /usr/local/
RUN cd /usr/local && ln -s ./spark-1.4.1-bin-hadoop2.6 spark

ENV SPARK_HOME=/usr/local/spark
RUN echo "export SPARK_HOME=/usr/local/spark" >> /etc/profile
RUN echo "export SPARK_CLASSPATH=$SPARK_HOME/lib/" >> /etc/profile

ADD start_spark.sh /usr/local/spark/start_spark.sh
RUN chown root:root /usr/local/spark/start_spark.sh
RUN chmod 700 /usr/local/spark/start_spark.sh

# Add dnsmasq.conf file
ADD dnsmasq.conf /etc/dnsmasq.conf
ADD dnsmasq.resolv.conf /etc/dnsmasq.resolv.conf

# Add scripts
ADD copy_runtime_to_hdfs.sh /usr/local/hadoop/copy_runtime_to_hdfs.sh
RUN chmod 700 /usr/local/hadoop/copy_runtime_to_hdfs.sh

# CMD ["/etc/bootstrap.sh", "-d"]

EXPOSE 50020 50090 50070 50010 50075 8031 8032 8033 8040 8042 49707 22 8088 8030 19888 2888 3888 2181 9990 10020 19888 2552
# XXX duplicated ports
