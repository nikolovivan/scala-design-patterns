package com.ivan.nikolov.pimp

import com.ivan.nikolov.pimp.model.Person

object PimpExample {

  def main(args: Array[String]): Unit = {
    System.out.println(s"Is 'test' all upper case: ${"test".isAllUpperCase}")
    System.out.println(s"Is 'Tes' all upper case: ${"Test".isAllUpperCase}")
    System.out.println(s"Is 'TESt' all upper case: ${"TESt".isAllUpperCase}")
    System.out.println(s"Is 'TEST' all upper case: ${"TEST".isAllUpperCase}")
  }
}

object PimpExample2 {
  def main(args: Array[String]): Unit = {
    val people = List(
      Person("Ivan", 26),
      Person("Maria", 26),
      Person("John", 25)
    )
    people.saveToDatabase()
  }
}
