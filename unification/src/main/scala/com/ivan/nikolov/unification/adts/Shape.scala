package com.ivan.nikolov.unification.adts

case class Point(x: Double, y: Double)

sealed abstract trait Shape
case class Circle(centre: Point, radius: Double) extends Shape
case class Rectangle(topLeft: Point, height: Double, width: Double) extends Shape

object Shape {
  def area(shape: Shape): Double =
    shape match {
      case Circle(Point(x, y), radius) => Math.PI * Math.pow(radius, 2)
      case Rectangle(_, h, w) => h * w
    }
}

object ShapeDemo {
  def main(args: Array[String]): Unit = {
    val circle = Circle(Point(1, 2), 2.5)
    val rect = Rectangle(Point(6, 7), 5, 6)
    
    System.out.println(s"The circle area is: ${Shape.area(circle)}")
    System.out.println(s"The rectangle area is: ${Shape.area(rect)}")
  }
}