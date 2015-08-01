package hu.bme.mit.incqueryd.demo.dbpedia.fourstore

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.URL

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils

import eu.mondo.driver.fourstore.FourStoreGraphDriverReadWrite

object DBpediaLoader {

  def load(driver: FourStoreGraphDriverReadWrite, languageCode: String) {
    val tempDir = new File(System.getProperty("java.io.tmpdir"))
    val compressed = new File(tempDir, "dbpedia_compressed.ttl.bz2")
    FileUtils.copyURLToFile(new URL(s"http://downloads.dbpedia.org/2015-04/core-i18n/$languageCode/labels_$languageCode.ttl.bz2"), compressed)
    val extracted = new File(tempDir, "dbpedia_extracted.ttl")
    extractBz2(compressed, extracted)
    driver.load(extracted)
  }
  
  def extractBz2(compressed: File, extracted: File) {
    val in = new FileInputStream(compressed);
    val out = new FileOutputStream(extracted);
    val bzIn = new BZip2CompressorInputStream(in);
    try {
    	IOUtils.copyLarge(bzIn, out)
    } finally {
    	out.close();
    	bzIn.close();
    }
  }
  
}