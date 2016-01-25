package com.ivan.nikolov.behavioral.memento

import scala.collection.mutable

trait Memento[T] {
  protected val state: T
  def getState(): T = state
}

trait Caretaker[T] {
  val states: mutable.Stack[Memento[T]] = mutable.Stack[Memento[T]]()
}

trait Originator[T] {
  def createMemento: Memento[T]
  def restore(memento: Memento[T])
}
