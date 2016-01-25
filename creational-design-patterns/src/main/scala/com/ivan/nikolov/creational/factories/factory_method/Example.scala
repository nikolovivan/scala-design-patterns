package com.ivan.nikolov.creational.factories.factory_method

object Example {
  def main(args: Array[String]): Unit = {
    val clientMySql: DatabaseClient = new MysqlClient
    val clientPgSql: DatabaseClient = new PgSqlClient
    clientMySql.executeQuery("SELECT * FROM users")
    clientPgSql.executeQuery("SELECT * FROM employees")
  }
}
