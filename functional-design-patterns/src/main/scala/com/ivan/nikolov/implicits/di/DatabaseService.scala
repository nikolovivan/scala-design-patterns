package com.ivan.nikolov.implicits.di

import com.ivan.nikolov.implicits.di.model.Person

trait DatabaseService {
  def getPeople(): List[Person]
}

class DatabaseServiceImpl extends DatabaseService {
  override def getPeople(): List[Person] = List(
    Person("Ivan", 26),
    Person("Maria", 26),
    Person("John", 25)
  )
}
