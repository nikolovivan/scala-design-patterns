package com.ivan.nikolov.components.base

import com.ivan.nikolov.components.model.Food

trait Cooker {
  def cook(what: String): Food
}
