package com.ivan.nikolov.behavioral.command

case class Robot() {
  def cleanUp(): Unit = System.out.println("Cleaning up.")

  def pourJuice(): Unit = System.out.println("Pouring juice.")

  def makeSandwich(): Unit = System.out.println("Making a sandwich.")
}
