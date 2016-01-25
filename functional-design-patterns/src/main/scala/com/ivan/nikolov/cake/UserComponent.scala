package com.ivan.nikolov.cake

trait UserComponent {
  this: DaoComponent =>
  
  val userService: UserService
  class UserService {
    def getAverageAgeOfUsersInClass(className: String): Double = {
      val (ageSum, peopleCount) = dao.getPeopleInClass(className).foldLeft((0, 0)) {
        case ((sum, count), person) =>
          (sum + person.age, count + 1)
      }
      if (peopleCount != 0) {
        ageSum.toDouble / peopleCount.toDouble
      } else {
        0.0
      }
    }
  }
}
