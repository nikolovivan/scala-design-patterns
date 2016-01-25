package com.ivan.nikolov.behavioral.null_object

import scala.util.Random

case class Message(number: Int) {
  def print(): String = s"This is a message with number: $number."
}

object MessageExample {
  val TIMES_TO_TRY = 10
  val MAX_TIME = 5000
  
  def main(args: Array[String]): Unit = {
    val generator = new DataGenerator
    // start the generator in another thread
    new Thread(generator).start()
    
    val random = new Random()
    (0 to TIMES_TO_TRY).foreach {
      case time =>
        Thread.sleep(random.nextInt(MAX_TIME))
        System.out.println("Getting next message...")
        generator.getMessage().foreach(m => System.out.println(m.print()))
    }
    
    generator.requestStop()
  }
}
