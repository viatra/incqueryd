package main

import akka.actor.Actor
import scala.concurrent.ops._

class DummyActor extends Actor {

  def receive = {
    case "work" => spawn { work }
    case "monitor" => monitor
    case _ => {}
  }

  def work = {
    println("working")
    println("Thread: " + Thread.currentThread().getId())
    for (i <- -1000000000 until 1000000000) {
      var k = i + 2 - 2 + 2 - 2 + 2 - 3 + 4
      k - 3
      if (k == 0) println("0")
      //Thread.sleep(200)
    }
    println("finished")
  }

  def monitor = {
    println("monitor")
    println("Thread: " + Thread.currentThread().getId())
    sender ! "hello"
  }

}