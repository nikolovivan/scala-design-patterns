package com.ivan.nikolov.scheduler.io

import java.io.File

trait IOServiceComponent {

  val ioService: IOService
  
  class IOService {
    def getAllFilesWithExtension(basePath: String, extension: String): List[String] = {
      val dir = new File(basePath)
      if (dir.exists() && dir.isDirectory) {
        dir.listFiles().filter(f => f.isFile && f.getPath.toLowerCase.endsWith(s".${extension}")).map {
          case f => f.getAbsolutePath
        }.toList
      } else {
        List.empty
      }
    }
  }
}
