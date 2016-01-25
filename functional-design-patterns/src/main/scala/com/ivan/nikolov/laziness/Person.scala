package com.ivan.nikolov.laziness

case class Person(name: String, age: Int)

object Person {
  
  def getFromDatabase(): List[Person] = {
    // simulate we're getting people from database by sleeping
    System.out.println("Retrieving people...")
    Thread.sleep(3000)
    List(
      Person("Ivan", 26),
      Person("Maria", 26),
      Person("John", 25)
    )
  }
  
  def printPeopleBad(people: => List[Person]): Unit = {
    System.out.println(s"Print first time: ${people}")
    System.out.println(s"Print second time: ${people}")
  }

  def printPeopleGood(people: => List[Person]): Unit = {
    lazy val peopleCopy = people
    System.out.println(s"Print first time: ${peopleCopy}")
    System.out.println(s"Print second time: ${peopleCopy}")
  }

  def printPeopleGood2(people: => List[Person]): Unit = {
    val peopleCopy = () => people
    System.out.println(s"Print first time: ${peopleCopy()}")
    System.out.println(s"Print second time: ${peopleCopy()}")
  }
}

object Example {
  import Person._
  def main(args: Array[String]): Unit = {
    System.out.println("Now printing bad.")
    printPeopleBad(getFromDatabase())
    System.out.println("Now printing good.")
    printPeopleGood2(getFromDatabase())
  }
}
