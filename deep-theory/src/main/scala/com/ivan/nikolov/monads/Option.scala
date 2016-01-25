package com.ivan.nikolov.monads

sealed trait Option[A] extends Monad[A]

case class Some[A](a: A) extends Option[A] {
  override def unit[Y](value: Y): Monad[Y] = Some(value)
  override def flatMap[Y](f: (A) => Monad[Y]): Monad[Y] = f(a)
}

case class None[A]() extends Option[A] {
  override def unit[Y](value: Y): Monad[Y] = None()
  override def flatMap[Y](f: (A) => Monad[Y]): Monad[Y] = None()
}

case class Doer() {
  def getAlgorithm(isFail: Boolean) =
    if (isFail) {
      null
    } else {
      Algorithm()
    }
}

case class Algorithm() {
  def getImplementation(isFail: Boolean, left: Int, right: Int): Implementation =
    if (isFail) {
      null
    } else {
      Implementation(left, right)
    }
}

case class Implementation(left: Int, right: Int) {
  def compute: Int = left + right
}

object NoMonadExample {
  def main(args: Array[String]): Unit = {
    System.out.println(s"The result is: ${compute(Doer(), 10, 16)}")
  }
  
  def compute(doer: Doer, left: Int, right: Int): Int = 
    if (doer != null) {
      val algorithm = doer.getAlgorithm(false)
      if (algorithm != null) {
        val implementation = algorithm.getImplementation(false, left, right)
        if (implementation !=  null) {
          implementation.compute
        } else {
          -1
        }
      } else {
        -1
      }
    } else {
      -1
    }
}

case class Doer_v2() {
  def getAlgorithm(isFail: Boolean): Option[Algorithm_v2] =
    if (isFail) {
      None()
    } else {
      Some(Algorithm_v2())
    }
}

case class Algorithm_v2() {
  def getImplementation(isFail: Boolean, left: Int, right: Int): Option[Implementation] =
    if (isFail) {
      None()
    } else {
      Some(Implementation(left, right))
    }
}

object MonadExample {
  def main(args: Array[String]): Unit = {
    System.out.println(s"The result is: ${compute(Some(Doer_v2()), 10, 16)}")
  }
  
  def compute(doer: Option[Doer_v2], left: Int, right: Int) =
    for {
      d <- doer
      a <- d.getAlgorithm(false)
      i <- a.getImplementation(false, left, right)
    } yield i.compute
// OR THIS WAY:
//    doer.flatMap {
//      d => d.getAlgorithm(false).flatMap {
//        a => a.getImplementation(false, left, right).map {
//          i => i.compute
//        }
//      }
//    }
}