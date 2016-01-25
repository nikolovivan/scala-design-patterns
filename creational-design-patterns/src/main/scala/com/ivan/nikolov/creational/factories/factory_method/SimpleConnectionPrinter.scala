package com.ivan.nikolov.creational.factories.factory_method

import com.ivan.nikolov.creational.factories.SimpleConnection

trait SimpleConnectionPrinter {
  def printSimpleConnection(connection: SimpleConnection): Unit
}

class SimpleMySqlConnectionPrinter extends SimpleConnectionPrinter {
  override def printSimpleConnection(connection: SimpleConnection): Unit = {
    System.out.println(s"I require a MySQL connection. It is: '${connection.getName()}'")
  }
}

class SimplePgSqlConnectionPrinter extends SimpleConnectionPrinter {
  override def printSimpleConnection(connection: SimpleConnection): Unit = {
    System.out.println(s"I require a PgSQL connection. It is: '${connection.getName()}'")
  }
}
