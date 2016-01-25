package com.ivan.nikolov.polymorphism

abstract class Item {
  def pack: String
}

class Fruit extends Item {
  override def pack: String = "I'm a fruit and I'm packed in a bag."
}

class Drink extends Item {
  override def pack: String = "I'm a drink and I'm packed in a bottle."
}

object SubtypePolymorphismExample {
  def main(args: Array[String]): Unit = {
    val shoppingBasket: List[Item] = List(
      new Fruit,
      new Drink
    )
    shoppingBasket.foreach(i => System.out.println(i.pack))
  }
}
