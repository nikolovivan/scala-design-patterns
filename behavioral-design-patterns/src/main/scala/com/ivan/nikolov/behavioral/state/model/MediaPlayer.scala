package com.ivan.nikolov.behavioral.state.model

import com.ivan.nikolov.behavioral.state.{Paused, State}

case class MediaPlayer() {
  private var state: State[MediaPlayer] = new Paused
  
  def pressPlayOrPauseButton(): Unit = {
    state.press(this)
  }
  
  def setState(state: State[MediaPlayer]): Unit = {
    this.state = state
  }
}
