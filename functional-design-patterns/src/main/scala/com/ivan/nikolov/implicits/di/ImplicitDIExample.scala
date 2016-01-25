package com.ivan.nikolov.implicits.di

object ImplicitDIExample {
  def main(args: Array[String]): Unit = {
    System.out.println(s"The average age of the people is: ${userService.getAverageAgeOfPeople()}")
  }
}
