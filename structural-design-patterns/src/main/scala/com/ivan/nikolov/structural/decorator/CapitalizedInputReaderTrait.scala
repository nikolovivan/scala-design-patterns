package com.ivan.nikolov.structural.decorator

import java.io.{BufferedInputStream, InputStreamReader, BufferedReader, ByteArrayOutputStream}
import java.nio.charset.Charset
import java.util.Base64
import java.util.zip.GZIPOutputStream

import com.ivan.nikolov.structural.decorator.common.{AdvancedInputReader, InputReader}
import com.typesafe.scalalogging.LazyLogging

trait CapitalizedInputReaderTrait extends InputReader {
  abstract override def readLines(): Stream[String] = super.readLines().map(_.toUpperCase)
}

trait CompressingInputReaderTrait extends InputReader with LazyLogging {
  abstract override def readLines(): Stream[String] = super.readLines().map {
    case line =>
      val text = line.getBytes(Charset.forName("UTF-8"))
      logger.info("Length before compression: {}", text.length.toString)
      val output = new ByteArrayOutputStream()
      val compressor = new GZIPOutputStream(output)
      try {
        compressor.write(text, 0, text.length)
        val outputByteArray = output.toByteArray
        logger.info("Length after compression: {}", outputByteArray.length.toString)
        new String(outputByteArray, Charset.forName("UTF-8"))
      } finally {
        compressor.close()
        output.close()
      }
  }
}

trait Base64EncoderInputReaderTrait extends InputReader {
  abstract override def readLines(): Stream[String] = super.readLines().map {
    case line => Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("UTF-8")))
  }
}

object StackableTraitsExample {
  def main(args: Array[String]): Unit = {
    val stream = new BufferedReader(
      new InputStreamReader(
        new BufferedInputStream(this.getClass.getResourceAsStream("data.txt"))
      )
    )
    try {
      val reader = new AdvancedInputReader(stream) with CapitalizedInputReaderTrait
      reader.readLines().foreach(println)
    } finally {
      stream.close()
    }
  }
}

object StackableTraitsBigExample {
  def main(args: Array[String]): Unit = {
    val stream = new BufferedReader(
      new InputStreamReader(
        new BufferedInputStream(this.getClass.getResourceAsStream("data.txt"))
      )
    )
    try {
      val reader = new AdvancedInputReader(stream) with CapitalizedInputReaderTrait with Base64EncoderInputReaderTrait with CompressingInputReaderTrait
      reader.readLines().foreach(println)
    } finally {
      stream.close()
    }
  }
}


