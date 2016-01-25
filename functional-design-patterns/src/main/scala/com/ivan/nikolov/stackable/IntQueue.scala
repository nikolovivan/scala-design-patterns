package com.ivan.nikolov.stackable

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

object Ex {
  def main(args: Array[String]): Unit = {
    val queue = new BasicIntQueue with Filtering with Incrementing
    queue.put(-1)
    queue.put(0)
    queue.put(1)
    System.out.println(queue.get())
    System.out.println(queue.get())
    System.out.println(queue.get())
  }
  
}
