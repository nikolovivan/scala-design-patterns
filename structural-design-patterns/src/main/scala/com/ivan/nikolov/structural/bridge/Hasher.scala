package com.ivan.nikolov.structural.bridge

import com.ivan.nikolov.structural.bridge.common.Hasher
import org.apache.commons.codec.binary.Hex

class Sha1Hasher extends Hasher {
  override def hash(data: String): String =
    new String(Hex.encodeHex(getDigest("SHA-1", data).digest()))
}

class Sha256Hasher extends Hasher {
  override def hash(data: String): String = 
    new String(Hex.encodeHex(getDigest("SHA-256", data).digest()))
}

class Md5Hasher extends Hasher {
  override def hash(data: String): String = 
    new String(Hex.encodeHex(getDigest("MD5", data).digest()))
}