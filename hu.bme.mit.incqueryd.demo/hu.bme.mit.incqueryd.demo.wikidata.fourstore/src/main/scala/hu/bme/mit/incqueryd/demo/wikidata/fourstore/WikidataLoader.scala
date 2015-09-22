package hu.bme.mit.incqueryd.demo.wikidata.fourstore

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.URL
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import eu.mondo.driver.fourstore.FourStoreGraphDriverReadWrite
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream

object WikidataLoader {

  val defaultDatabaseName = "wikidata"

  def load(driver: FourStoreGraphDriverReadWrite, dumpName: String) {
    val tempDir = new File(System.getProperty("java.io.tmpdir"))
    val compressed = new File(tempDir, "wikidata_compressed.nt.gz")
    println("Downloading dumpfile")
    FileUtils.copyURLToFile(new URL(s"http://tools.wmflabs.org/wikidata-exports/rdf/exports/20150817/wikidata-$dumpName.nt.gz"), compressed)
    val extracted = new File(tempDir, "wikidata_extracted.nt")
    println("Extracting dumpfile")
    extractGzip(compressed, extracted)
    println("Importing dumpfile")
    driver.load(extracted)
  }
  
  private def extractGzip(compressed: File, extracted: File) {
    val in = new FileInputStream(compressed);
    val out = new FileOutputStream(extracted);
    val bzIn = new GzipCompressorInputStream(in);
    try {
    	IOUtils.copyLarge(bzIn, out)
    } finally {
    	out.close();
    	bzIn.close();
    }
  }
  
}