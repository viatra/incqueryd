package hu.bme.mit.incqueryd.demo.wikidata.fourstore

object FourstoreUtils {

  def setup(databaseName: String) {
    Runtime.getRuntime.exec(s"4s-backend-setup $databaseName")
    Runtime.getRuntime.exec(s"4s-backend $databaseName")
  }
  
  def destroy(databaseName: String) {
    Runtime.getRuntime.exec(s"4s-backend-destroy $databaseName")
  }

}