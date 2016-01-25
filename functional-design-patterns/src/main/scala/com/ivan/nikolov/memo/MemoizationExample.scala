package com.ivan.nikolov.memo

object MemoizationExample {

  def main(args: Array[String]): Unit = {
    val hasher = new Hasher
    
    System.out.println(s"MD5 for 'hello' is '${hasher.memoMd5("hello")}'.")
    System.out.println(s"MD5 for 'bye' is '${hasher.memoMd5("bye")}'.")
    System.out.println(s"MD5 for 'hello' is '${hasher.memoMd5("hello")}'.")
    System.out.println(s"MD5 for 'bye1' is '${hasher.memoMd5("bye1")}'.")
    System.out.println(s"MD5 for 'bye' is '${hasher.memoMd5("bye")}'.")
  }
}
