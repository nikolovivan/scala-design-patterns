package com.ivan.nikolov.monoids

import org.scalacheck.Arbitrary
import org.scalatest.prop.Checkers
import org.scalatest.{ShouldMatchers, FlatSpec}
import scalaz._
import scalacheck.ScalazProperties._

class MonoidsTest extends FlatSpec with ShouldMatchers with Checkers {

  implicit def arbString(implicit ev: Arbitrary[String]): Arbitrary[String] =
    Arbitrary { ev.arbitrary.map(identity) }
  
  "stringConcatenation monoid" should "satisfy the identity rule." in {
    check(
      monoid.laws[String](stringConcatenation, Equal.equalA[String], arbString)
    )
    // run with
    // monoid.laws[String](stringConcatenation, Equal.equalA[String], arbString).check
    // to get output
  }
}
