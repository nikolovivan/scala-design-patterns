package com.ivan.nikolov.cake

object Application {
  import ApplicationComponentRegistry._
  def main(args: Array[String]): Unit = {
    migrationService.runMigrations()
    System.out.println(dao.getPeople)
    System.out.println(dao.getClasses)
    System.out.println(dao.getPeopleInClass("Scala Design Patterns"))
    System.out.println(dao.getPeopleInClass("Mountain Biking"))
    System.out.println(s"Average age of everyone in Scala Design Patterns: ${userService.getAverageAgeOfUsersInClass("Scala Design Patterns")}")
  }
}
