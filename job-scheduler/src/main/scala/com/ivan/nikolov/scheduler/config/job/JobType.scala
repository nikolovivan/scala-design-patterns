package com.ivan.nikolov.scheduler.config.job

import org.json4s.CustomSerializer
import org.json4s.JsonAST.{JNull, JString}

sealed trait JobType
case object Console extends JobType
case object Sql extends JobType

object JobTypeSerializer extends CustomSerializer[JobType](format => (
  {
    case JString(jobType) => jobType match {
      case "Console" => Console
      case "Sql" => Sql
    }
    case JNull => null
  },
  {
    case jobType: JobType => JString(jobType.getClass.getSimpleName.replace("$", ""))
  }
))