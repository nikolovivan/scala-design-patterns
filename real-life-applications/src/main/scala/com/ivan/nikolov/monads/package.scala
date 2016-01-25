package com.ivan.nikolov

import java.io.{PrintWriter, File}

import scala.io.Source

package object monads {
  def readFile(path: String) = {
    System.out.println(s"Reading file ${path}")
    Source.fromFile(path).getLines()
  }

  def writeFile(path: String, lines: Iterator[String]) = {
      System.out.println(s"Writing file ${path}")
      val file = new File(path)
      printToFile(file) { p => lines.foreach(p.println) }
    }

  private def printToFile(file: File)(writeOp: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      writeOp(writer)
    } finally {
      writer.close()
    }
  }
}
