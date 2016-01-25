package com.ivan.nikolov.basic

import com.ivan.nikolov.common.Notifier

class NotifierImpl(val notificationMessage: String) extends Notifier {
  override def clear(): Unit = System.out.println("cleared")
}
