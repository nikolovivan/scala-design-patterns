package com.ivan.nikolov.cake

import java.sql.{ResultSet, PreparedStatement}

import com.ivan.nikolov.cake.model.{Person, Class}

trait DaoComponent {
  this: DatabaseComponent =>
  
  val dao: Dao
  
  class Dao() {
    def getPeople: List[Person] = {
      val connection = databaseService.getConnection
      try {
        executeSelect(
          connection.prepareStatement("SELECT id, name, age FROM people")
        ) {
          rs =>
            readResultSet(rs) {
              row =>
                Person(row.getInt(1), row.getString(2), row.getInt(3))
            }
        }
      } finally {
        connection.close()
      }
    }
    
    def getClasses: List[Class] = {
      val connection = databaseService.getConnection
      try {
        executeSelect(
          connection.prepareStatement("SELECT id, name FROM classes")
        ) {
          rs =>
            readResultSet(rs) {
              row =>
                Class(row.getInt(1), row.getString(2))
            }
        }
      } finally {
        connection.close()
      }
    }
    
    def getPeopleInClass(className: String): List[Person] = {
      val connection = databaseService.getConnection
      try {
        val statement = connection.prepareStatement(
          """
            |SELECT p.id, p.name, p.age 
            |FROM people p 
            | JOIN people_classes pc ON p.id = pc.person_id
            | JOIN classes c ON c.id = pc.class_id
            |WHERE c.name = ? 
          """.stripMargin
        )
        statement.setString(1, className)
        executeSelect(
          statement
        ) {
          rs =>
            readResultSet(rs) {
              row =>
                Person(row.getInt(1), row.getString(2), row.getInt(3))
            }
        }
      } finally {
        connection.close()
      }
      
    }
      
    private def executeSelect[T](preparedStatement: PreparedStatement)(f: (ResultSet) => List[T]): List[T] =
      try {
        f(preparedStatement.executeQuery())
      } finally {
        preparedStatement.close()
      }
    
    private def readResultSet[T](rs: ResultSet)(f: ResultSet => T): List[T] =
      Iterator.continually((rs.next(), rs)).takeWhile(_._1).map {
        case (_, row) =>
          f(rs)
      }.toList
    
  }
}
