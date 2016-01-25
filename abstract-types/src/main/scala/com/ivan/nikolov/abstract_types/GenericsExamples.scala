package com.ivan.nikolov.abstract_types

trait Adder {
  def sum[T](a: T, b: T)(implicit numeric: Numeric[T]): T = numeric.plus(a, b)
}

class Container[T](data: T) {
  def compare(other: T) = data.equals(other)
}

object GenericsExamples extends Adder {
  def main(args: Array[String]): Unit = {
    System.out.println(s"1 + 3 = ${sum(1, 3)}")
    System.out.println(s"1.2 + 6.7 = ${sum(1.2, 6.7)}")
    // System.out.println(s"abc + cde = ${sum("abc", "cde")}") // compilation fails
    
    val intContainer = new Container(10)
    System.out.println(s"Comparing with int: ${intContainer.compare(11)}")
    
    val stringContainer = new Container("some text")
    System.out.println(s"Comparing with string: ${stringContainer.compare("some text")}")
  }
}
