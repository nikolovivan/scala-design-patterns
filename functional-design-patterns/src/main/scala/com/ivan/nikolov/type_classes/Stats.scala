package com.ivan.nikolov.type_classes

object Stats {
//  same as
//  def mean[T](xs: Vector[T])(implicit ev: Number[T]): T =
//    ev.divide(xs.reduce(ev.plus(_, _)), xs.size)
  def mean[T: Number](xs: Vector[T]): T = 
    implicitly[Number[T]].divide(
      xs.reduce(implicitly[Number[T]].plus(_, _)),
      xs.size
    )

  // assumes the vector is sorted
  def median[T: Number](xs: Vector[T]): T =
    xs(xs.size / 2)
  
  def variance[T: Number](xs: Vector[T]): T = {
    val simpleMean = mean(xs)
    val sqDiff = xs.map {
      case x => 
        val diff = implicitly[Number[T]].minus(x, simpleMean)
        implicitly[Number[T]].multiply(diff, diff)
    }
    mean(sqDiff)
  }
  
  def stddev[T: Number](xs: Vector[T]): T = 
    implicitly[Number[T]].sqrt(variance(xs))
}
