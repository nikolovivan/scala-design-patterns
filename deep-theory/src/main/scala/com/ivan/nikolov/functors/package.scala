package com.ivan.nikolov

package object functors {

  val listFunctor = new Functor[List] {
    override def map[T, Y](l: List[T])(f: (T) => Y): List[Y] = l.map(f)
  }
}
