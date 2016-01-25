package com.ivan.nikolov.behavioral.observer

import scala.collection.mutable.ListBuffer

trait Observer[T] {
  def handleUpdate(subject: T)
}

trait Observable[T] {
  this: T =>
  
  private val observers = ListBuffer[Observer[T]]()
  
  def addObserver(observer: Observer[T]): Unit = {
    observers.+=:(observer)
  }
  
  def notifyObservers(): Unit = {
    observers.foreach(_.handleUpdate(this))
  }
}
