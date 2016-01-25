package com.ivan.nikolov.creational.singleton

object StringUtils {

  def countNumberOfSpaces(text: String): Int =
    text.split("\\s+").length - 1
}


object UtilsExample {
  def main(args: Array[String]): Unit = {
    val sentence = "Hello there! I am a utils example."
    System.out.println(
      s"The number of spaces in '$sentence' is: ${StringUtils.countNumberOfSpaces(sentence)}"
    )
  }
}