package com.ivan.nikolov.composition.self_types

import com.ivan.nikolov.common.Notifier

trait AlarmNotifier {
  this: Notifier =>
  
  def trigger(): String
}
