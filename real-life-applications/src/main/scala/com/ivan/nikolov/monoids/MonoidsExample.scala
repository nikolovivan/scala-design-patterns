package com.ivan.nikolov.monoids

import scalaz._
import Scalaz._

object MonoidsExample {

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6)
    System.out.println(s"The sum is: ${numbers.foldMap(identity)}")
    System.out.println(s"The product (6!) is: ${numbers.foldMap(Tags.Multiplication.apply)}")
    val strings = List("This is\n", "a list of\n", "strings!")
    System.out.println(strings.foldMap(identity)(stringConcatenation))
  }
}
