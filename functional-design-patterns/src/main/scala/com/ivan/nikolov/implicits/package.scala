package com.ivan.nikolov

package object implicits {

  implicit def doubleToInt(a: Double): Int =
    Math.round(a).toInt
  
  
  implicit def intsToString(ints: List[Int]): String =
    ints.map(_.toChar).mkString
}
