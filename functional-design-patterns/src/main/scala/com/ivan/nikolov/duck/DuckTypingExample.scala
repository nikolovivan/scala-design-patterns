package com.ivan.nikolov.duck

object DuckTypingExample {

  def printSentenceParts(sentence: String, parser: {def parse(sentence: String): Array[String]}) =
    parser.parse(sentence).foreach(println)
  
  def main(args: Array[String]): Unit = {
    val tokenizerParser = new SentenceParserTokenize
    val splitParser = new SentenceParserSplit
    
    val sentence = "This is the sentence we will be splitting."
    
    System.out.println("Using the tokenize parser: ")
    printSentenceParts(sentence, tokenizerParser)
    
    System.out.println("Using the split parser: ")
    printSentenceParts(sentence, splitParser)
  }
}
