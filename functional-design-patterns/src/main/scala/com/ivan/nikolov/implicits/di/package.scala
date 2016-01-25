package com.ivan.nikolov.implicits

package object di {
  implicit val databaseService = new DatabaseServiceImpl
  implicit val userService = new UserServiceImpl
}
