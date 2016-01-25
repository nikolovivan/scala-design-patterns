package com.ivan.nikolov.memo

import scala.collection.mutable.Map

trait Memoizer {

  def memo[X, Y](f: X => Y): (X => Y) = {
    val cache = Map[X, Y]()
    (x: X) => cache.getOrElseUpdate(x, f(x))
  }
}
