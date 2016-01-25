package com.ivan.nikolov.components

class Robot extends RobotRegistry {

  def cook(what: String) = cooker.cook(what)
  def getTime() = time.getTime()
}


object RobotExample {
  def main(args: Array[String]): Unit = {
    val robot = new Robot
    System.out.println(robot.getTime())
    System.out.println(robot.cook("chips"))
    System.out.println(robot.cook("sandwich"))
  }
}