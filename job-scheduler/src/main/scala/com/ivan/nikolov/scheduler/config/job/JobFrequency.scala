package com.ivan.nikolov.scheduler.config.job

import org.json4s.CustomSerializer
import org.json4s.JsonAST.{JNull, JString}

sealed trait JobFrequency
case object Daily extends JobFrequency
case object Hourly extends JobFrequency

case object JobFrequencySerializer extends CustomSerializer[JobFrequency](format => (
  {
    case JString(frequency) => frequency match {
      case "Daily" => Daily
      case "Hourly" => Hourly
    }
    case JNull => null
  },
  {
    case frequency: JobFrequency => JString(frequency.getClass.getSimpleName.replace("$", ""))
  }
))
