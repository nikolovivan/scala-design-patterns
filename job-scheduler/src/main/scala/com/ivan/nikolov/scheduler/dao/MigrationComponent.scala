package com.ivan.nikolov.scheduler.dao

import java.sql.Connection

trait MigrationComponent {
  this: DatabaseServiceComponent =>
  
  val migrationService: MigrationService
  
  class MigrationService {
    type Person = (Int, String, Int)
    type Class = (Int, String)
    
    def cleanupDatabase(): Unit = {
      val connection = databaseService.getConnection
      try {
        dropPeopleToClassesTable(connection)
        dropClassesTable(connection)
        dropPeopleTable(connection)
      } finally {
        connection.close()
      }
    }
    
    def runMigrations(): Unit = {
      val connection = databaseService.getConnection
      try {
        // create the database
        createPeopleTable(connection)
        createClassesTable(connection)
        createPeopleToClassesTable(connection)
        // populate
        insertPeople(
          connection,
          List(
            (1, "Ivan", 26),
            (2, "Maria", 25),
            (3, "John", 27)
          )
        )
        insertClasses(
          connection,
          List(
            (1, "Scala Design Patterns"),
            (2, "Java Programming"),
            (3, "Mountain Biking")
          )
        )
        signPeopleToClasses(
          connection,
          List(
            (1, 1),
            (1, 2),
            (1, 3),
            (2, 1),
            (3, 1),
            (3, 3)
          )
        )
      } finally {
        connection.close()
      }
    }

    private def createPeopleTable(connection: Connection): Unit = {
      val statement = connection.prepareStatement(
        """
          |CREATE TABLE people(
          | id INT PRIMARY KEY,
          | name VARCHAR(255) NOT NULL,
          | age INT NOT NULL 
          |)
        """.stripMargin
      )
      try {
        statement.executeUpdate()
      } finally {
        statement.close()
      }
    }
    
    private def dropPeopleTable(connection: Connection): Unit = {
      val statement = connection.prepareStatement(
        "DROP TABLE people"
      )
      try {
        statement.executeUpdate()
      } finally {
        statement.close()
      }
    }

    private def createClassesTable(connection: Connection): Unit = {
      val statement = connection.prepareStatement(
        """
          |CREATE TABLE classes(
          | id INT PRIMARY KEY,
          | name VARCHAR(255) NOT NULL, 
          |)
        """.stripMargin
      )
      try {
        statement.executeUpdate()
      } finally {
        statement.close()
      }
    }
    
    private def dropClassesTable(connection: Connection): Unit = {
      val statement = connection.prepareStatement(
        "DROP TABLE classes"
      )
      try {
        statement.executeUpdate()
      } finally {
        statement.close()
      }
    }
    

    private def createPeopleToClassesTable(connection: Connection): Unit = {
      val statement = connection.prepareStatement(
        """
          |CREATE TABLE people_classes(
          | person_id INT NOT NULL,
          | class_id INT NOT NULL,
          | PRIMARY KEY(person_id, class_id),
          | FOREIGN KEY(person_id) REFERENCES people(id) ON DELETE CASCADE ON UPDATE CASCADE,
          | FOREIGN KEY(class_id) REFERENCES classes(id) ON DELETE CASCADE ON UPDATE CASCADE
          |)
        """.stripMargin
      )
      try {
        statement.executeUpdate()
      } finally {
        statement.close()
      }
    }

    private def dropPeopleToClassesTable(connection: Connection): Unit = {
      val statement = connection.prepareStatement(
        "DROP TABLE people_classes"
      )
      try {
        statement.executeUpdate()
      } finally {
        statement.close()
      }
    }

    private def insertPeople(connection: Connection, people: List[Person]): Unit = {
      val statement = connection.prepareStatement(
        "INSERT INTO people(id, name, age) VALUES (?, ?, ?)"
      )
      try {
        people.foreach {
          case person =>
            statement.setInt(1, person._1)
            statement.setString(2, person._2)
            statement.setInt(3, person._3)
            statement.addBatch()
        }
        statement.executeBatch()
      } finally {
        statement.close()
      }
    }

    private def insertClasses(connection: Connection, classes: List[Class]): Unit = {
      val statement = connection.prepareStatement(
        "INSERT INTO classes(id, name) VALUES (?, ?)"
      )
      try {
        classes.foreach{
          case cls =>
            statement.setInt(1, cls._1)
            statement.setString(2, cls._2)
            statement.addBatch()
        }
        statement.executeBatch()
      } finally {
        statement.close()
      }
    }

    private def signPeopleToClasses(connection: Connection, peopleToClasses: List[(Int, Int)]): Unit = {
      val statement = connection.prepareStatement(
        "INSERT INTO people_classes(person_id, class_id) VALUES (?, ?)"
      )
      try {
        peopleToClasses.foreach {
          case (personId, classId) =>
            statement.setInt(1, personId)
            statement.setInt(2, classId)
            statement.addBatch()
        }
        statement.executeBatch()
      } finally {
        statement.close()
      }
    }
  }
}
