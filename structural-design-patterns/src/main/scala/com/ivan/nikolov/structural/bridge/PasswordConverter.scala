package com.ivan.nikolov.structural.bridge

import com.ivan.nikolov.structural.bridge.common.Hasher

abstract class PasswordConverter(hasher: Hasher) {
  def convert(password: String): String
}

class SimplePasswordConverter(hasher: Hasher) extends PasswordConverter(hasher) {
  override def convert(password: String): String = 
    hasher.hash(password)
}

class SaltedPasswordConverter(salt: String, hasher: Hasher) extends PasswordConverter(hasher) {
  override def convert(password: String): String = 
    hasher.hash(s"${salt}:${password}")
}


object BridgeExample {
  
  def main(args: Array[String]): Unit = {
    val p1 = new SimplePasswordConverter(new Sha256Hasher)
    val p2 = new SimplePasswordConverter(new Md5Hasher)
    val p3 = new SaltedPasswordConverter("8jsdf32T^$%", new Sha1Hasher)
    val p4 = new SaltedPasswordConverter("8jsdf32T^$%", new Sha256Hasher)
    
    System.out.println(s"'password' in SHA-256 is: ${p1.convert("password")}")
    System.out.println(s"'1234567890' in MD5 is: ${p2.convert("1234567890")}")
    System.out.println(s"'password' in salted SHA-1 is: ${p3.convert("password")}")
    System.out.println(s"'password' in salted SHA-256 is: ${p4.convert("password")}")
  }
  
}