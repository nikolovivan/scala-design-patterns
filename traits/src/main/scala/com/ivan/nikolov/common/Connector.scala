package com.ivan.nikolov.common

abstract class Connector {
  def connect()

  def close()
}

trait ConnectorWithHelper extends Connector {
  
  def findDriver(): Unit = {
    System.out.println("Find driver called.")
  }
}

class PgSqlConnector extends ConnectorWithHelper {
  override def connect(): Unit = {
    System.out.println("Connected...")
  }

  override def close(): Unit = {
    System.out.println("Closed...")
  }
}
