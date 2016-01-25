package com.ivan.nikolov.behavioral.interpreter

import java.util.StringTokenizer

import scala.collection.JavaConverters._
import scala.collection.mutable

class RPNParser {

  def parse(expression: String): Expression = {
    val tokenizer = new StringTokenizer(expression)
    tokenizer.asScala.foldLeft(mutable.Stack[Expression]()) {
      case (result, token) =>
        val item = Expression(token.toString, result.pop(), result.pop())
        item.foreach(result.push)
        result
    }.pop()
  }
}

class RPNInterpreter {
  def interpret(expression: Expression): Int = expression.interpret()
}

object RPNExample {
  def main(args: Array[String]): Unit = {
    val expr1 = "1 2 + 3 * 9 10 + -" // (1 + 2) * 3 - (9 + 10) = -10
    val expr2 = "1 2 3 4 5 * * - +" // 1 + 2 - 3 * 4 * 5 = -57
    val expr3 = "12 -" // invalid
    val parser = new RPNParser
    val interpreter = new RPNInterpreter
    
    System.out.println(s"The result of '${expr1}' is: ${interpreter.interpret(parser.parse(expr1))}")
    System.out.println(s"The result of '${expr2}' is: ${interpreter.interpret(parser.parse(expr2))}")
    try {
      System.out.println(s"The result is: ${interpreter.interpret(parser.parse(expr3))}")
    } catch {
      case _: Throwable => System.out.println(s"'$expr3' is invalid.")
    }
  }
}
