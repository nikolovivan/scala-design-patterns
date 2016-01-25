package com.ivan.nikolov.monads

import com.ivan.nikolov.monads.model.Person

import scalaz._
import effect._
import Scalaz._
import IO._

object IOMonadExample {

  def main(args: Array[String]): Unit = {
    args match {
      case Array(inputFile, isWriteToFile) =>
        val people = {
          for {
            line <- readFile(inputFile)
            person <- Person.fromArray(line.split("\t"))
          } yield person
        }.pure[IO]

        System.out.println("Still haven't done any IO!")
        System.out.println("About to do some...")
        if (isWriteToFile.toBoolean) {
          val writePeople = for {
            _ <- putStrLn("Read people successfully. Where to write them down?")
            outputFile <- readLn
            p <- people
            _ <- writeFile(outputFile, p.map(_.toString)).pure[IO]
          } yield ()
          System.out.println("Writing to file using toString.")
          writePeople.unsafePerformIO 
        } else {
          System.out.println(s"Just got the following people: ${people.unsafePerformIO.toList}")
        }
      case _ =>
        System.err.println("Please provide input file and true/false whether to write to file.")
        System.exit(-1)
    }
  }
}
