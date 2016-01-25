package com.ivan.nikolov.duck

import java.util.StringTokenizer

class SentenceParserTokenize {
  
  def parse(sentence: String): Array[String] = {
    val tokenizer = new StringTokenizer(sentence)
    Iterator.continually({
      val hasMore = tokenizer.hasMoreTokens
      if (hasMore) {
        (hasMore, tokenizer.nextToken())
      } else {
        (hasMore, null)
      }
    }).takeWhile(_._1).map(_._2).toArray
  }
    
}
