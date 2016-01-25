package com.ivan.nikolov.monoids

object MonoidFolding {
  def main(args: Array[String]): Unit = {
    val strings = List("This is\n", "a list of\n", "strings!")
    val numbers = List(1, 2, 3, 4, 5, 6)
    
    System.out.println(s"Left folded:\n ${strings.foldLeft(stringConcatenation.zero)(stringConcatenation.op)}")
    System.out.println(s"Right folded:\n ${strings.foldRight(stringConcatenation.zero)(stringConcatenation.op)}")
    System.out.println(s"6! is: ${numbers.foldLeft(intMultiplication.zero)(intMultiplication.op)}")
  }
}

object MonoidFoldingGeneric {
  def main(args: Array[String]): Unit = {
    val strings = List("This is\n", "a list of\n", "strings!")
    val numbers = List(1, 2, 3, 4, 5, 6)

    System.out.println(s"Left folded:\n ${MonoidOperations.fold(strings, stringConcatenation)}")
    System.out.println(s"Right folded:\n ${MonoidOperations.fold(strings, stringConcatenation)}")
    System.out.println(s"6! is: ${MonoidOperations.fold(numbers, intMultiplication)}")
  }
}

object MonoidBalancedFold {
  def main(args: Array[String]): Unit = {
    val numbers = Array(1, 2, 3, 4)
    System.out.println(s"4! is: ${MonoidOperations.balancedFold(numbers, intMultiplication)(identity)}")
  }
}

object MonoidFoldingGenericPar {
  def main(args: Array[String]): Unit = {
    val strings = List("This is\n", "a list of\n", "strings!")
    val numbers = List(1, 2, 3, 4, 5, 6)

    System.out.println(s"Left folded:\n ${MonoidOperations.foldPar(strings, stringConcatenation)}")
    System.out.println(s"Right folded:\n ${MonoidOperations.foldPar(strings, stringConcatenation)}")
    System.out.println(s"6! is: ${MonoidOperations.foldPar(numbers, intMultiplication)}")
  }
}

object ComposedMonoid {
  def main(args: Array[String]): Unit = {
    val numbers = Array(1, 2, 3, 4, 5, 6)
    val sumAndProduct = compose(intAddition, intMultiplication)
    
    System.out.println(s"The sum and product is: ${MonoidOperations.balancedFold(numbers, sumAndProduct)(i => (i, i))}")
  }
}

object FeatureCounting {
  def main(args: Array[String]): Unit = {
    val features = Array("hello", "features", "for", "ml", "hello", "for", "features")
    val counterMonoid: Monoid[Map[String, Int]] = mapMerge(intAddition)
    
    System.out.println(s"The features are: ${MonoidOperations.balancedFold(features, counterMonoid)(i => Map(i -> 1))}")
  }
}

object FeatureCountingOneOff {
  def main(args: Array[String]): Unit = {
    val features = Array("hello", "features", "for", "ml", "hello", "for", "features")
    System.out.println(s"The features are: ${
      features.foldLeft(Map[String, Int]()) {
        case (res, feature) =>
          res.updated(feature, res.getOrElse(feature, 0) + 1)
      }
    }")
  }
}
