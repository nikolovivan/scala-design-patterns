package com.ivan.nikolov.creational.builder.type_safe

class Person(
  val firstName: String,
  val lastName: String,
  val age: Int/*, // skipped for simplicity
  val departmentId: Int,
  val emailAddress: String,
  val city: String,
  val address: String,
  val mobilePhone: String*/)

sealed trait BuildStep
sealed trait HasFirstName extends BuildStep
sealed trait HasLastName extends BuildStep
// skipped for simplicity
//sealed trait HasAge extends BuildStep
//sealed trait HasDepartmentId extends BuildStep

class PersonBuilder[PassedStep <: BuildStep] private (
  var firstName: String,
  var lastName: String,
  var age: Int/*, // skipped for simplicity
  var departmentId: Int,
  var emailAddress: String,
  var city: String,
  var address: String,
  var mobilePhone: String*/
) {
  protected def this() = this("","",0/*,0,"","","",""*/)
  protected def this(pb: PersonBuilder[_]) = this(
    pb.firstName,
    pb.lastName,
    pb.age/*, // skipped for simplicity
    pb.departmentId,
    pb.emailAddress,
    pb.city,
    pb.address,
    pb.mobilePhone*/
  )

  def setFirstName(firstName: String): PersonBuilder[HasFirstName] = {
    this.firstName = firstName
    new PersonBuilder[HasFirstName](this)
  }

  def setLastName(lastName: String)(implicit ev: PassedStep =:= HasFirstName): PersonBuilder[HasLastName] = {
    this.lastName = lastName
    new PersonBuilder[HasLastName](this)
  }

  def setAge(age: Int): PersonBuilder[PassedStep] = {
    this.age = age
    this
  }
//  def setAge(age: Int)(implicit ev: PassedStep =:= HasLastName): PersonBuilder[HasAge] = {
//    this.age = age
//    new PersonBuilder[HasAge](this)
//  }

  // skipped for simplicity
//  def setDepartmentId(departmentId: Int)(implicit ev: PassedStep =:= HasAge): PersonBuilder[HasDepartmentId] = {
//    this.departmentId = departmentId
//    new PersonBuilder[HasDepartmentId](this)
//  }
//
//  def setEmailAddress(emailAddress: String): PersonBuilder[PassedStep] = {
//    this.emailAddress = emailAddress
//    this
//  }
//
//  def setCity(city: String): PersonBuilder[PassedStep] = {
//    this.city = city
//    this
//  }
//
//  def setAddress(address: String): PersonBuilder[PassedStep] = {
//    this.address = address
//    this
//  }
//
//  def setMobilePhone(mobilePhone: String): PersonBuilder[PassedStep] = {
//    this.mobilePhone = mobilePhone
//    this
//  }

  def build()(implicit ev: PassedStep =:= /*HasDepartmentId*/ HasLastName): Person = new Person(
    firstName,
    lastName,
    age/*, // skipped for simplicity
    departmentId,
    emailAddress,
    city,
    address,
    mobilePhone*/
  )
}

object PersonBuilder {
  def apply() = new PersonBuilder[BuildStep]()
}

object PersonBuilderTypeSafeExample {
  def main(args: Array[String]): Unit = {
    val person = PersonBuilder()
      .setFirstName("Ivan")
      .setLastName("Nikolov")
      .setAge(26)
      //.setDepartmentId(1)
      //.setCity("London")
      .build()
    //System.out.println(s"Person: ${person.firstName} ${person.lastName}. Age: ${person.age}. City: ${person.city}. Department: ${person.departmentId}")
    System.out.println(s"Person: ${person.firstName} ${person.lastName}. Age: ${person.age}.")
  }
}
