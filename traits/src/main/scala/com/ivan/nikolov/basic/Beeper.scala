package com.ivan.nikolov.basic

trait Beeper {
  def beep(times: Int): Unit = {
    assert(times >= 0)
    1 to times foreach(i => System.out.println(s"Beep number: $i"))
  }
}

object BeeperRunner {
  val TIMES = 10
  
  def main (args: Array[String]): Unit = {
    val beeper = new Beeper {}
    beeper.beep(TIMES)
  }
}
