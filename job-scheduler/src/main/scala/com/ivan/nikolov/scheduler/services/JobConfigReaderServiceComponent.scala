package com.ivan.nikolov.scheduler.services

import java.io.File

import com.ivan.nikolov.scheduler.config.app.AppConfigComponent
import com.ivan.nikolov.scheduler.config.job.{JobTypeSerializer, JobFrequencySerializer, JobConfig}
import com.ivan.nikolov.scheduler.io.IOServiceComponent
import com.typesafe.scalalogging.LazyLogging
import org.json4s._
import org.json4s.jackson.JsonMethods._

trait JobConfigReaderServiceComponent {
  this: AppConfigComponent
    with IOServiceComponent =>
  
  val jobConfigReaderService: JobConfigReaderService
  
  class JobConfigReaderService() extends LazyLogging {
    private val customSerializers = List(
      JobFrequencySerializer,
      JobTypeSerializer
    )
    implicit val formats = DefaultFormats ++ customSerializers + JobConfig.jobConfigFieldSerializer
    
    def readJobConfigs(): List[JobConfig] =
      ioService.getAllFilesWithExtension(appConfigService.configPath, appConfigService.configExtension).flatMap {
        case path => try {
          val config = parse(FileInput(new File(path))).extract[JobConfig]
          Some(config)
        } catch {
          case ex: Throwable =>
            logger.error("Error reading config: {}", path, ex)
            None
        }
        
      }
  }
}
