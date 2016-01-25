package com.ivan.nikolov.unification.adts

sealed case class RGB(red: Int, green: Int, blue: Int)

object RGBDemo {
  def main(args: Array[String]): Unit = {
    val magenta = RGB(255, 0, 255)
    System.out.println(s"Magenta in RGB is: $magenta")
  }
}
