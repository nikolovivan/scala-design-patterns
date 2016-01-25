package com.ivan.nikolov.behavioral.state

import com.ivan.nikolov.behavioral.state.model.MediaPlayer

trait State[T] {
  def press(context: T)
}

class Playing extends State[MediaPlayer] {
  override def press(context: MediaPlayer): Unit = {
    System.out.println("Pressing pause.")
    context.setState(new Paused)
  }
}

class Paused extends State[MediaPlayer] {
  override def press(context: MediaPlayer): Unit = {
    System.out.println("Pressing play.")
    context.setState(new Playing)
  }
}


object MediaPlayerExample {
  def main(args: Array[String]): Unit = {
    val player = MediaPlayer()
    
    player.pressPlayOrPauseButton()
    player.pressPlayOrPauseButton()
    player.pressPlayOrPauseButton()
    player.pressPlayOrPauseButton()
  }
}


