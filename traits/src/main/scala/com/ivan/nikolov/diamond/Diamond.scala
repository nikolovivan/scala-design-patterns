package com.ivan.nikolov.diamond

trait A {
  def hello(): String = "Hello from A"
}

trait B extends A {
  override def hello(): String = "Hello from B"
}

trait C extends A {
  override def hello(): String = "Hello from C"
}

trait D extends B with C {
  
}

object Diamond extends D {
  def main(args: Array[String]): Unit = {
    System.out.println(hello())
  }
}
