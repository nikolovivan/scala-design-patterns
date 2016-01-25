package com.ivan.nikolov.creational.builder.case_classes

case class Person(
  firstName: String = "",
  lastName: String = "",
  age: Int = 0/*, // skipped for simplicity.
  departmentId: Int = 0,
  emailAddress: String = "",
  city: String = "",
  address: String = "",
  mobilePhone: String = ""*/
)

object PersonCaseClassExample {
  def main(args: Array[String]): Unit = {
    val person1 = Person(
      firstName = "Ivan",
      lastName = "Nikolov",
      age = 26/*, // skipped for simplicity.
      departmentId = 1,
      city = "London"*/
    )
    
    val person2 = Person(
      firstName = "John"/*, // skipped for simplicity.
      address = "21 Regent Street",
      mobilePhone = "1234567890",
      city = "London"*/
    )
    
    System.out.println(s"Person 1: ${person1}")
    System.out.println(s"Person 2: ${person2}")
  }
}