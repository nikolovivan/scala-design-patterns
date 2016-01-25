package com.ivan.nikolov.creational.prototype

/**
 * Represents a bio cell
 */
case class Cell(dna: String, proteins: List[String])

object PrototypeExample {
  def main(args: Array[String]): Unit = {
    val initialCell = Cell("abcd", List("protein1", "protein2"))
    val copy1 = initialCell.copy()
    val copy2 = initialCell.copy()
    val copy3 = initialCell.copy(dna = "1234")
    System.out.println(s"The prototype is: ${initialCell}")
    System.out.println(s"Cell 1: ${copy1}")
    System.out.println(s"Cell 2: ${copy2}")
    System.out.println(s"Cell 3: ${copy3}")
    System.out.println(s"1 and 2 are equal: ${copy1 == copy2}")
  }
}