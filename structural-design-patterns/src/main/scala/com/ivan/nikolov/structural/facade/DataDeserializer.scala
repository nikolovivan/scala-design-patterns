package com.ivan.nikolov.structural.facade

import org.json4s._
import org.json4s.jackson.JsonMethods

trait DataDeserializer {
  implicit val formats = DefaultFormats
  
  def parse[T](data: String)(implicit m: Manifest[T]): T =
    JsonMethods.parse(StringInput(data)).extract[T]
}
