package com.ivan.nikolov.lens

import scalaz.{LensFamily, Lens}

case class Country(name: String, code: String)
case class City(name: String, country: Country)
case class Address(number: Int, street: String, city: City)
case class Company(name: String, address: Address)
case class User(name: String, company: Company, address: Address)

object User {
  val userCompany = Lens.lensu[User, Company](
    (u, company) => u.copy(company = company),
    _.company
  )
  
  val userAddress = Lens.lensu[User, Address](
    (u, address) => u.copy(address = address),
    _.address
  )
  
  val companyAddress = Lens.lensu[Company, Address](
    (c, address) => c.copy(address = address),
    _.address
  )
  
  val addressCity = Lens.lensu[Address, City](
    (a, city) => a.copy(city = city),
    _.city
  )
  
  val cityCountry = Lens.lensu[City, Country](
    (c, country) => c.copy(country = country),
    _.country
  )
  
  val countryCode = Lens.lensu[Country, String](
    (c, code) => c.copy(code = code),
    _.code
  )
  
  val userCompanyCountryCode = userCompany >=> companyAddress >=> addressCity >=> cityCountry >=> countryCode
  
  val userCompanyCountryCodeCompose = countryCode <=< cityCountry <=< addressCity <=< companyAddress <=< userCompany
}

object UserVerboseExample {
  def main(args: Array[String]): Unit = {
    val uk = Country("United Kingdom", "uk")
    val london = City("London", uk)
    val buckinghamPalace = Address(1, "Buckingham Palace Road", london)
    val castleBuilders = Company("Castle Builders", buckinghamPalace)
    
    val switzerland = Country("Switzerland", "CH")
    val geneva = City("geneva", switzerland)
    val genevaAddress = Address(1, "Geneva Lake", geneva)
    
    val ivan = User("Ivan", castleBuilders, genevaAddress)
    System.out.println(ivan)
    
    System.out.println("Capitalize UK code...")

    val ivanFixed = ivan.copy(
      company = ivan.company.copy(
        address = ivan.company.address.copy(
          city = ivan.company.address.city.copy(
            country = ivan.company.address.city.country.copy(
              code = ivan.company.address.city.country.code.toUpperCase
            )
          )
        )
      )
    )
    System.out.println(ivanFixed)
  }
}

object UserLensExample {
  import User._

  def main(args: Array[String]): Unit = {
    val uk = Country("United Kingdom", "uk")
    val london = City("London", uk)
    val buckinghamPalace = Address(1, "Buckingham Palace Road", london)
    val castleBuilders = Company("Castle Builders", buckinghamPalace)

    val switzerland = Country("Switzerland", "CH")
    val geneva = City("geneva", switzerland)
    val genevaAddress = Address(1, "Geneva Lake", geneva)

    val ivan = User("Ivan", castleBuilders, genevaAddress)
    System.out.println(ivan)

    System.out.println("Capitalize UK code...")
    
    val ivanFixed = userCompanyCountryCode.mod(_.toUpperCase, ivan)
    System.out.println(ivanFixed)
  }
  
}