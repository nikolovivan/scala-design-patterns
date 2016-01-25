package com.ivan.nikolov.partial_functions

/**
 * Note that these are not partially defined functions!
 */
object PartiallyAppliedFunctions {

  val greaterOrEqual = (a: Int, b: Int) => a >= b
  val lessOrEqual = (a: Int, b: Int) => a <= b
  
  def greaterOrEqualCurried(b: Int)(a: Int) = a >= b
  def lessOrEqualCurried(b: Int)(a: Int) = a <= b
  
  val greaterOrEqualCurriedVal: (Int) => (Int) => Boolean = b => a => a >= b
  val lessOrEqualCurriedVal: (Int) => (Int) => Boolean = b => a => a <= b
}

object PartiallyAppliedExample {
  import PartiallyAppliedFunctions._
  val MAX = 20
  val MIN = 5
  
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 5, 6, 11, 18, 19, 20, 21, 25, 30)
    // partially applied
    val ge = greaterOrEqual(_: Int, MIN)
    val le = lessOrEqual(_: Int, MAX)
    
    // curried
    val geCurried = greaterOrEqualCurried(MIN) _
    val leCurried = lessOrEqualCurried(MAX) _

//    won't work because of the argument order
//    val geCurried = greaterOrEqual.curried(MIN)
//    val leCurried = lessOrEqual.curried(MAX)
    
//    will work normally
//    val geCurried = greaterOrEqualCurriedVal(MIN)
//    val leCurried = lessOrEqualCurriedVal(MAX)
    
    System.out.println(s"Filtered list: ${numbers.filter(i => ge(i) && le(i))}")
    System.out.println(s"Filtered list: ${numbers.filter(i => geCurried(i) && leCurried(i))}")
  }
  
}
