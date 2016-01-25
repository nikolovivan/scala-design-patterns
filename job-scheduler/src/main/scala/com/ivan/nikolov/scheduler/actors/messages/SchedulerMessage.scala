package com.ivan.nikolov.scheduler.actors.messages

import com.ivan.nikolov.scheduler.config.job.{JobConfig, JobType}

sealed trait SchedulerMessage
case class Work(name: String, command: String, jobType: JobType)
case class Done(name: String, command: String, jobType: JobType, success: Boolean)
case class Schedule(configs: List[JobConfig])