package com.ivan.nikolov.structural.adapter


trait Log {
  def info(message: String)
  def debug(message: String)
  def warning(message: String)
  def error(message: String)
}

class Logger {
  def log(message: String, severity: String): Unit = {
    System.out.println(s"${severity.toUpperCase}: $message")
  }
}

class AppLogger extends Logger with Log {
  override def info(message: String): Unit = 
    log(message, "info")

  override def warning(message: String): Unit =
    log(message, "warning")

  override def error(message: String): Unit =
    log(message, "error")

  override def debug(message: String): Unit =
    log(message, "debug")
}

// final
final class FinalLogger {
  def log(message: String, severity: String): Unit = {
    System.out.println(s"${severity.toUpperCase}: $message")
  }
}

class FinalAppLogger extends Log {
  private val logger = new FinalLogger
  
  override def info(message: String): Unit =
    logger.log(message, "info")

  override def warning(message: String): Unit =
    logger.log(message, "warning")

  override def error(message: String): Unit =
    logger.log(message, "error")

  override def debug(message: String): Unit =
    logger.log(message, "debug")
}
// final

object AdapterExample {
  def main(args: Array[String]): Unit = {
    val logger = new AppLogger
    logger.info("This is an info message.")
    logger.debug("Debug something here.")
    logger.error("Show an error message.")
    logger.warning("About to finish.")
    logger.info("Bye!")
  }
}

object AdapterImplicitExample {
  def main(args: Array[String]): Unit = {
    val logger: Log = new FinalLogger
    logger.info("This is an info message.")
    logger.debug("Debug something here.")
    logger.error("Show an error message.")
    logger.warning("About to finish.")
    logger.info("Bye!")
  }
}
