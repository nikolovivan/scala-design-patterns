package com.ivan.nikolov.monoids

trait Monoid[T] {
  def op(l: T, r: T): T
  def zero: T
}
