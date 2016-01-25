package com.ivan.nikolov.creational.factories.factory_method

object BadExample {
  def main(args: Array[String]): Unit = {
    val clientMySql: BadDatabaseClient = new BadMySqlClient
    val clientPgSql: BadDatabaseClient = new BadPgSqlClient
    clientMySql.executeQuery("SELECT * FROM users")
    clientPgSql.executeQuery("SELECT * FROM employees")
  }
}
