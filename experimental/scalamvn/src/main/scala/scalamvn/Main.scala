package scalamvn

object Main {
	def main(args: Array[String]) {
		println("We're running scala..")
		val service = new SomeJavaService
		println(service.getInfo())
	}
 }