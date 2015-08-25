package hu.bme.mit.incqueryd.spark.client

import org.apache.spark.launcher.SparkLauncher
import org.apache.spark.SparkConf
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.spark.ProcessingMethod
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * @author pappi
 */
object IQDSparkClient {

  def getSparkLauncher(): SparkLauncher = {
    new SparkLauncher()
      .setSparkHome(SPARK_HOME)
      .setAppResource(APP_RESOURCE)
      .setMaster("yarn-cluster")
      .setDeployMode("cluster")
      .setMainClass(MAIN_CLASS)
      .setConf(SparkLauncher.DRIVER_MEMORY, "512m")
      .setConf(SparkLauncher.EXECUTOR_MEMORY, "512m")
  }

  def loadDataFromFile(databaseURL: String) {

    val exit_code = getSparkLauncher()
      .setAppName(s"HDFS LOAD")
      .addAppArgs("-method", ProcessingMethod.HDFS_LOAD.toString())
      .addAppArgs("-duration", DEFAULT_DURATION.toString())
      .addAppArgs("-ds_url", databaseURL)
      .addAppArgs("-single")
      .launch().waitFor()

  }

  def loadDataFrom4Store(databaseURL: String) {
    // TODO: submit spark streaming application to perform initial load from 4Store database
    throw new UnsupportedOperationException("Not implemented yet")
  }

  def startWikipediaStreaming(streamURL: String) {
    // TODO: submit spark streaming application to process stream received from Wikipedia
    throw new UnsupportedOperationException("Not implemented yet")
  }

  def stopWikipediaStreaming() {
    // TODO: terminate Wikipedia stream processing application
    throw new UnsupportedOperationException("Not implemented yet")
  }

}