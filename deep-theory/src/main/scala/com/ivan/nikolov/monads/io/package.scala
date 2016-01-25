package com.ivan.nikolov.monads

import java.io.{PrintWriter, File}

import scala.io.Source

package object io {
  def readFile(path: String) =
    IOAction(Source.fromFile(path).getLines())

  def writeFile(path: String, lines: Iterator[String]) =
    IOAction({
      val file = new File(path)
      printToFile(file) { p => lines.foreach(p.println) }
    })

  private def printToFile(file: File)(writeOp: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      writeOp(writer)
    } finally {
      writer.close()
    }
  }
}
