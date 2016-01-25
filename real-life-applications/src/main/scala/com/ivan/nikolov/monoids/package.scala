package com.ivan.nikolov

import scalaz.Monoid

package object monoids {
  
  // Int addition and int multiplication exist already,
  // so we will show them in an example.
  
  val stringConcatenation = new Monoid[String] {
    override def zero: String = ""

    override def append(f1: String, f2: => String): String =
      f1 + f2
  }
}
