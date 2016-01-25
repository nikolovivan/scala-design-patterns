package com.ivan.nikolov.stackable


abstract class StringWriter {
  def write(data: String): String
}

class BasicStringWriter extends StringWriter {
  override def write(data: String): String =
    s"Writing the following data: ${data}"
}

trait CapitalizingStringWriter extends StringWriter {
  abstract override def write(data: String): String = {
    super.write(data.split("\\s+").map(_.capitalize).mkString(" "))
  }
}

trait UppercasingStringWriter extends StringWriter {
  abstract override def write(data: String): String = {
    super.write(data.toUpperCase)
  }
}

trait LowercasingStringWriter extends StringWriter {
  abstract override def write(data: String): String = {
    super.write(data.toLowerCase)
  }
}

object Example {
  def main(args: Array[String]): Unit = {
    val writer1 = new BasicStringWriter with UppercasingStringWriter with CapitalizingStringWriter
    val writer2 = new BasicStringWriter with CapitalizingStringWriter with LowercasingStringWriter
    val writer3 = new BasicStringWriter with CapitalizingStringWriter with UppercasingStringWriter with LowercasingStringWriter
    val writer4 = new BasicStringWriter with CapitalizingStringWriter with LowercasingStringWriter with UppercasingStringWriter
    
    System.out.println(s"Writer 1: '${writer1.write("we like learning scala!")}'")
    System.out.println(s"Writer 2: '${writer2.write("we like learning scala!")}'")
    System.out.println(s"Writer 3: '${writer3.write("we like learning scala!")}'")
    System.out.println(s"Writer 4: '${writer4.write("we like learning scala!")}'")
  }
}


