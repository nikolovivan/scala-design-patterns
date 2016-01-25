package com.ivan.nikolov.behavioral.chain_of_responsibility

import scala.io.Source

class ATM {
  val dispenser: Dispenser = {
    val d1 = new Dispenser5(None)
    val d2 = new Dispenser10(Some(d1))
    val d3 = new Dispenser20(Some(d2))
    new Dispenser50(Some(d3))
  }
  
  def requestMoney(money: Money): Unit = {
    if (money.amount % 5 != 0) {
      System.err.println("The smallest nominal is 5 and we cannot satisfy your request.")
    } else {
      dispenser.dispense(money)
    }
  }
}

class PartialFunctionATM extends PartialFunctionDispenser {
  
  val dispenser = dispense(50).andThen(dispense(20)).andThen(dispense(10)).andThen(dispense(5)) 
  
  def requestMoney(money: Money): Unit = {
    if (money.amount % 5 != 0) {
      System.err.println("The smallest nominal is 5 and we cannot satisfy your request.")
    } else {
      dispenser(money)
    }
  }
}

object ATMExample {
  def main(args: Array[String]): Unit = {
    val atm = new ATM
    printHelp()
    Source.stdin.getLines().foreach {
      case line =>
        processLine(line, atm)
    }
  }
  
  def printHelp(): Unit = {
    System.out.println("Usage: ")
    System.out.println("1. Write an amount to withdraw...")
    System.out.println("2. Write EXIT to quit the application.")
  }
  
  def processLine(line: String, atm: ATM): Unit = {
    line match {
      case "EXIT" =>
        System.out.println("Bye!")
        System.exit(0)
      case l =>
        try {
          atm.requestMoney(Money(l.toInt))
          System.out.println("Thanks!")
        } catch {
          case _: Throwable =>
            System.err.println(s"Invalid input: $l.")
            printHelp()
        }
      
    }
  }
}

object PartialFunctionATMExample {
  def main(args: Array[String]): Unit = {
    val atm = new PartialFunctionATM
    printHelp()
    Source.stdin.getLines().foreach {
      case line =>
        processLine(line, atm)
    }
  }

  def printHelp(): Unit = {
    System.out.println("Usage: ")
    System.out.println("1. Write an amount to withdraw...")
    System.out.println("2. Write EXIT to quit the application.")
  }

  def processLine(line: String, atm: PartialFunctionATM): Unit = {
    line match {
      case "EXIT" =>
        System.out.println("Bye!")
        System.exit(0)
      case l =>
        try {
          atm.requestMoney(Money(l.toInt))
          System.out.println("Thanks!")
        } catch {
          case _: Throwable =>
            System.err.println(s"Invalid input: $l.")
            printHelp()
        }

    }
  }
}

