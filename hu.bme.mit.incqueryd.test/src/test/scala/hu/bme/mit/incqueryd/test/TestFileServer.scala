package hu.bme.mit.incqueryd.test

import java.io.File
import java.net.URL

import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.engine.AkkaUtils

object TestFileServer {

  def start(workingDirectory: File) {
    val processBuilder = new ProcessBuilder("python", "-m", "SimpleHTTPServer", port.toString)
    processBuilder.directory(workingDirectory)
    processBuilder.redirectOutput(new File(s"${getClass.getSimpleName}.out"))
    processBuilder.redirectError(new File(s"${getClass.getSimpleName}.err"))
    processBuilder.start
    val testUrl = new URL(s"http://${NetworkUtils.getLocalIpAddress}:${port}")
    AkkaUtils.retry(AkkaUtils.defaultRetryCount)(AkkaUtils.defaultDelayMillis) {
      testUrl.openConnection.connect
    }
  }

  val port = 50000

}

