package com.ivan.nikolov.type_classes
import Stats._

object StatsExample {
  def main(args: Array[String]): Unit = {
    val intVector = Vector(1, 3, 5, 6, 10, 12, 17, 18, 19, 30, 36, 40, 42, 66)
    val doubleVector = Vector(1.5, 3.6, 5.0, 6.6, 10.9, 12.1, 17.3, 18.4, 19.2, 30.9, 36.6, 40.2, 42.3, 66.0)
    
    System.out.println(s"Mean (int): ${mean(intVector)}")
    System.out.println(s"Median (int): ${median(intVector)}")
    System.out.println(s"Std dev (int): ${stddev(intVector)}")

    System.out.println(s"Mean (double): ${mean(doubleVector)}")
    System.out.println(s"Median (double): ${median(doubleVector)}")
    System.out.println(s"Std dev (double): ${stddev(doubleVector)}")
  }
}
