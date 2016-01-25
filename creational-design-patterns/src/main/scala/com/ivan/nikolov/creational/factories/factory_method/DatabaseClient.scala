package com.ivan.nikolov.creational.factories.factory_method

import com.ivan.nikolov.creational.factories.{SimplePgSqlConnection, SimpleMysqlConnection, SimpleConnection}

abstract class DatabaseClient {
  def executeQuery(query: String): Unit = {
    val connection = connect()
    connection.executeQuery(query)
  }
  
  protected def connect(): SimpleConnection
}

class MysqlClient extends DatabaseClient {
  override protected def connect(): SimpleConnection = new SimpleMysqlConnection
}

class PgSqlClient extends DatabaseClient {
  override protected def connect(): SimpleConnection = new SimplePgSqlConnection
}
