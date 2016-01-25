package com.ivan.nikolov.functors

object FunctorsExample {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6)
    val mapping = Map(
      1 -> "one", 
      2 -> "two",
      3 -> "three",
      4 -> "four",
      5 -> "five",
      6 -> "six"
    )
    
    System.out.println(s"The numbers doubled are: ${listFunctor.map(numbers)(_ * 2)}")
    System.out.println(s"The numbers with strings are: ${listFunctor.map(numbers)(i => (i, mapping(i)))}")
  }
}
