package com.ivan.nikolov.monads.io

sealed trait State {
  def next: State
}

abstract class FileIO {
  // this makes sure nobody can create a state
  private class FileIOState(id: Int) extends State {
    override def next: State = new FileIOState(id + 1)
  }

  def run(args: Array[String]): Unit = {
    val action = runIO(args(0), args(1))
    action(new FileIOState(0))
  }

  def runIO(readPath: String, writePath: String): IOAction[_]
}

sealed abstract class IOAction[T] extends ((State) => (State, T)) {

  // START: we don't have to extend. We could also do this...
  def unit[Y](value: Y): IOAction[Y] = IOAction.unit(value)

  def flatMap[Y](f: (T) => IOAction[Y]): IOAction[Y] = {
    val self = this
    new IOAction[Y] {
      override def apply(state: State): (State, Y) = {
        val (state2, res) = self(state)
        val action2 = f(res)
        action2(state2)
      }
    }
  }

  def map[Y](f: T => Y): IOAction[Y] =
    flatMap(i => unit(f(i)))
  // END: we don't have to extend. We could also do this...
}

object IOAction {

  def apply[T](result: => T): IOAction[T] =
    new SimpleAction[T](result)
  
  def unit[T](value: T): IOAction[T] =
    new EmptyAction[T](value)

  private class SimpleAction[T](result: => T) extends IOAction[T] {
    override def apply(state: State): (State, T) =
      (state.next, result)
  }
  
  private class EmptyAction[T](value: T) extends IOAction[T] {
    override def apply(state: State): (State, T) = 
      (state, value)
  }
}

object FileIOExample extends FileIO {
  
  def main(args: Array[String]): Unit = {
    run(args)
  }
  
  override def runIO(readPath: String, writePath: String): IOAction[_] =
    for {
      lines <- readFile(readPath)
      _ <- writeFile(writePath, lines.map(_.toUpperCase))
    } yield ()
}
