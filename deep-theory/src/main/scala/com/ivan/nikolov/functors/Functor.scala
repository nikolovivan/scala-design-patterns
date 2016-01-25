package com.ivan.nikolov.functors

trait Functor[F[_]] {
  def map[T, Y](l: F[T])(f: T => Y): F[Y]
}
