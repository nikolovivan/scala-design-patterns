package com.ivan.nikolov.creational.factories.abstract_factory

import com.ivan.nikolov.creational.factories.{SimplePgSqlConnection, SimpleMysqlConnection, SimpleConnection}

trait DatabaseConnectorFactory {
  def connect(): SimpleConnection
}

class MySqlFactory extends DatabaseConnectorFactory {
  override def connect(): SimpleConnection = new SimpleMysqlConnection
}

class PgSqlFactory extends DatabaseConnectorFactory {
  override def connect(): SimpleConnection = new SimplePgSqlConnection
}
