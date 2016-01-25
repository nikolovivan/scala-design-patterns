package com.ivan.nikolov.creational.builder.java_way

class Person(builder: PersonBuilder) {
  val firstName = builder.firstName
  val lastName = builder.lastName
  val age = builder.age
  // skipped for simplicity.
//  val departmentId = builder.departmentId
//  val emailAddress = builder.emailAddress
//  val city = builder.city
//  val address = builder.address
//  val mobilePhone = builder.mobilePhone
}

class PersonBuilder {
  var firstName = ""
  var lastName = ""
  var age = 0
  // skipped for simplicity
//  var departmentId = 0
//  var emailAddress = ""
//  var city = ""
//  var address = ""
//  var mobilePhone = ""
  
  def setFirstName(firstName: String): PersonBuilder = {
    this.firstName = firstName
    this
  }
  
  def setLastName(lastName: String): PersonBuilder = {
    this.lastName = lastName
    this
  }
  
  def setAge(age: Int): PersonBuilder = {
    this.age = age
    this
  }
  
  // skipped for simplicity
//  def setDepartmentId(departmentId: Int): PersonBuilder = {
//    this.departmentId = departmentId
//    this
//  }
//  
//  def setEmailAddress(emailAddress: String): PersonBuilder = {
//    this.emailAddress = emailAddress
//    this
//  }
//  
//  def setCity(city: String): PersonBuilder = {
//    this.city = city
//    this
//  }
//  
//  def setAddress(address: String): PersonBuilder = {
//    this.address = address
//    this
//  }
//  
//  def setMobilePhone(mobilePhone: String): PersonBuilder = {
//    this.mobilePhone = mobilePhone
//    this
//  }
  
  def build(): Person = new Person(this)
}

object PersonBuilderExample {
  def main(args: Array[String]): Unit = {
    val person: Person = new PersonBuilder()
      .setFirstName("Ivan")
      .setLastName("Nikolov")
      //.setCity("London")
      .setAge(26)
      //.setDepartmentId(1)
      .build()
    //System.out.println(s"Person: ${person.firstName} ${person.lastName}. Age: ${person.age}. City: ${person.city}")
    System.out.println(s"Person: ${person.firstName} ${person.lastName}. Age: ${person.age}.")
  }
}
