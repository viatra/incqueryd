package hu.bme.mit.incqueryd.yarn

import org.apache.hadoop.hdfs.HdfsConfiguration
import org.apache.hadoop.fs.FileSystem
import java.io.File
import java.io.FileInputStream
import org.apache.hadoop.fs.Path
import java.io.InputStream
import org.apache.commons.io.IOUtils
import org.apache.hadoop.hdfs.DFSConfigKeys
import org.apache.hadoop.security.UserGroupInformation

object HdfsUtils {

  def getDistributedFileSystem(fileSystemUri: String): FileSystem = {
    val conf = new HdfsConfiguration
    conf.set("fs.defaultFS", fileSystemUri)
    conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
    conf.set("dfs.replication", "1")
    FileSystem.get(conf)
  }

  def upload(fileSystem: FileSystem, file: File, pathString: String) {
    val outputStream = fileSystem.create(new Path(pathString), true)
    IOUtils.copy(new FileInputStream(file), outputStream)
    outputStream.close
  }

}