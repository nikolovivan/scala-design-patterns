package com.ivan.nikolov.components

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.ivan.nikolov.components.base.Time

trait TimeComponent {
  val time: Time

  class TimeImpl extends Time {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    override def getTime(): String = s"The time is: ${LocalDateTime.now().format(formatter)}"
  }
}
