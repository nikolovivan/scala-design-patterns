package com.ivan.nikolov.creational.lazy_init

import java.util.Properties

object CircleUtils {
  val basicPi = 3.14
  lazy val precisePi: Double = {
    System.out.println("Reading properties for the precise PI.")
    val props = new Properties()
    props.load(getClass.getResourceAsStream("pi.properties"))
    props.getProperty("pi.high").toDouble
  }
  
  def area(radius: Double, isPrecise: Boolean = false): Double = {
    val pi: Double = if (isPrecise) precisePi else basicPi
    pi * Math.pow(radius, 2)
  }
}

object Example {
  def main(args: Array[String]): Unit = {
    System.out.println(s"The basic area for a circle with radius 2.5 is ${CircleUtils.area(2.5)}")
    System.out.println(s"The precise area for a circle with radius 2.5 is ${CircleUtils.area(2.5, true)}")
    System.out.println(s"The basic area for a circle with radius 6.78 is ${CircleUtils.area(6.78)}")
    System.out.println(s"The precise area for a circle with radius 6.78 is ${CircleUtils.area(6.78, true)}")
  }
}
