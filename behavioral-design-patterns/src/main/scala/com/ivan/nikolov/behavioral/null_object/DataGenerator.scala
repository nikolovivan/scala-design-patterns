package com.ivan.nikolov.behavioral.null_object

import java.util.concurrent.ConcurrentLinkedQueue

import scala.util.Random

class DataGenerator extends Runnable {

  val MAX_VAL = 10
  val MAX_TIME = 10000
  
  private var isStop = false
  
  private val queue: ConcurrentLinkedQueue[Int] = new ConcurrentLinkedQueue[Int]()
  
  override def run(): Unit = {
    val random = new Random()
    while (!isStop) {
      Thread.sleep(random.nextInt(MAX_TIME))
      queue.add(random.nextInt(MAX_VAL))
    }
  }
  
  def getMessage(): Option[Message] =
    Option(queue.poll()).map {
      case number => Message(number)
    }

  def requestStop(): Unit = this.synchronized {
    isStop = true
  }
}
