package com.ivan.nikolov.abstract_types

trait ContainerAT {
  type T
  val data: T
  
  def compare(other: T) = data.equals(other) 
}

class StringContainer(val data: String) extends ContainerAT {
  override type T = String
}

object AbstractTypesExamples {
  def main(args: Array[String]): Unit = {
    val stringContainer = new StringContainer("some text")
    System.out.println(s"Comparing with string: ${stringContainer.compare("some text")}")
  }
}
