package com.ivan.nikolov.monads.model

case class Person(name: String, age: Int)

object Person {
  def fromArray(arr: Array[String]): Option[Person] =
    arr match {
      case Array(name, age) => Some(Person(name, age.toInt))
      case _ => None
      
    }
}
