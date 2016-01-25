package com.ivan.nikolov.structural.bridge.common

import java.security.MessageDigest

trait Hasher {
  def hash(data: String): String

  protected def getDigest(algorithm: String, data: String) = {
    val crypt = MessageDigest.getInstance(algorithm)
    crypt.reset()
    crypt.update(data.getBytes("UTF-8"))
    crypt
  }
}
