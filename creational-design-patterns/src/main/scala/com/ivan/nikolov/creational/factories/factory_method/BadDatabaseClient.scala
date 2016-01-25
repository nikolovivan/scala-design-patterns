package com.ivan.nikolov.creational.factories.factory_method

import com.ivan.nikolov.creational.factories.{SimpleMysqlConnection, SimplePgSqlConnection, SimpleConnection}

abstract class BadDatabaseClient {
  def executeQuery(query: String): Unit = {
    val connection = connect()
    val connectionPrinter = getConnectionPrinter()
    connectionPrinter.printSimpleConnection(connection)
    connection.executeQuery(query)
  }

  protected def connect(): SimpleConnection
  protected def getConnectionPrinter(): SimpleConnectionPrinter
}

class BadMySqlClient extends BadDatabaseClient {
  override protected def connect(): SimpleConnection = new SimpleMysqlConnection

  override protected def getConnectionPrinter(): SimpleConnectionPrinter = new SimpleMySqlConnectionPrinter
}

class BadPgSqlClient extends BadDatabaseClient {
  override protected def connect(): SimpleConnection = new SimplePgSqlConnection

  override protected def getConnectionPrinter(): SimpleConnectionPrinter = new SimpleMySqlConnectionPrinter
}
