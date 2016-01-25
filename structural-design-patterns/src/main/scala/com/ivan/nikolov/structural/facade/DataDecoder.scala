package com.ivan.nikolov.structural.facade

import java.util.Base64

trait DataDecoder {
  
  def decode(data: Array[Byte]): String =
    new String(Base64.getDecoder.decode(data), "UTF-8")
}
