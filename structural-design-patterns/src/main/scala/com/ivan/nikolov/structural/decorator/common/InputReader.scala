package com.ivan.nikolov.structural.decorator.common

import java.io.BufferedReader

import scala.collection.JavaConverters._

trait InputReader {
  def readLines(): Stream[String]
}

class AdvancedInputReader(reader: BufferedReader) extends InputReader {
  override def readLines(): Stream[String] = reader.lines().iterator().asScala.toStream
}
