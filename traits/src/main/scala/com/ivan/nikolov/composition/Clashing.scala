package com.ivan.nikolov.composition

trait A {
  def hello(): String = "Hello, I am trait A!"
  def pass(a: Int): String = s"Trait A said: 'You passed $a.'"
  //def value(a: Int): Int = a
}

trait B {
  def hello(): String = "Hello, I am trait B!"
  def pass(a: String): String = s"Trait B said: 'You passed $a.'"
  //def value(a: Int): String = a.toString
}

object Clashing extends A with B {
  override def hello(): String = super[A].hello()
  def helloB(): String = super[B].hello()
  
  def main(args: Array[String]): Unit = {
    System.out.println(hello())
    System.out.println(helloB())
    System.out.println(pass(1))
    System.out.println(pass("hello"))
  }
}

// Same signature, different return types example
trait C {
  def value(a: Int): Int = a
}

trait D {
  def value(a: Int): String = a.toString
}

object Example {
  
  val c = new C {}
  val d = new D {}
  
  def main (args: Array[String]): Unit = {
    System.out.println(s"c.value: ${c.value(10)}")
    System.out.println(s"d.value: ${d.value(10)}")
  }
}
// Same signature, different return types example
