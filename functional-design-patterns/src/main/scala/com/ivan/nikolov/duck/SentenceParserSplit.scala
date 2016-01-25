package com.ivan.nikolov.duck

class SentenceParserSplit {

  def parse(sentence: String): Array[String] =
    sentence.split("\\s")
}
