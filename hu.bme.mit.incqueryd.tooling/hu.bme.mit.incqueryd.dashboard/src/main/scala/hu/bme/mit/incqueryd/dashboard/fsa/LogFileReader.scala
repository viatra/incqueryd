package hu.bme.mit.incqueryd.dashboard.fsa

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.Scanner

class LogFileReader(filepath : String) {
  
    val file = new File(filepath)
		if (file != null && !file.exists) {
			file.createNewFile
		}
    
    def getFilePath() : String = {
      file.getPath
    }
    
		val logInputStream = new FileInputStream(file);
		val logReader = new BufferedReader(new InputStreamReader(logInputStream, "UTF-8"))
		
		def readAppended() : String = {
		  val appendedLines = new StringBuilder
		  var line : String = ""
		  while(line != null) {
		    appendedLines.append(line)
		    line = logReader.readLine()
		  }
		  appendedLines.toString()
		}
		
		def close() {
		  logReader.close()
		  logInputStream.close()
		}
		
}
