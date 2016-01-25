package com.ivan.nikolov.monads

import scala.collection.GenTraversableOnce

case class ListWrapper(list: List[Int]) {

  // just wrap
  def map[B](f: Int => B): List[B] = list.map(f)
  
  // just wrap
  def flatMap[B](f: Int => GenTraversableOnce[B]): List[B] = list.flatMap(f)
}

object ForComprehensionWithLists {
  def main(args: Array[String]): Unit = {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(5, 6, 7, 8)
    val result = for {
      x <- l1
      y <- l2
    } yield x * y
    // same as
    // val result  = l1.flatMap(i => l2.map(_ * i))
    System.out.println(s"The result is: ${result}")
  }
}


object ForComprehensionWithObjects {
  def main(args: Array[String]): Unit = {
    val wrapper1 = ListWrapper(List(1, 2, 3, 4))
    val wrapper2 = ListWrapper(List(5, 6, 7, 8))
    val result = for {
      x <- wrapper1
      y <- wrapper2
    } yield x * y
    System.out.println(s"The result is: ${result}")
  }
}