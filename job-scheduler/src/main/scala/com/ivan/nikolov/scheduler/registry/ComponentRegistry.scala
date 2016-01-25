package com.ivan.nikolov.scheduler.registry

import com.ivan.nikolov.scheduler.actors.{ActorFactory, ActorFactoryComponent}
import com.ivan.nikolov.scheduler.config.app.AppConfigComponent
import com.ivan.nikolov.scheduler.dao._
import com.ivan.nikolov.scheduler.io.IOServiceComponent
import com.ivan.nikolov.scheduler.services.JobConfigReaderServiceComponent

object ComponentRegistry extends AppConfigComponent 
  with IOServiceComponent 
  with JobConfigReaderServiceComponent
  with DatabaseServiceComponent
  with MigrationComponent
  with DaoServiceComponent
  with ActorFactoryComponent {

  override val appConfigService: ComponentRegistry.AppConfigService = new AppConfigService
  override val ioService: ComponentRegistry.IOService = new IOService
  override val jobConfigReaderService: ComponentRegistry.JobConfigReaderService = new JobConfigReaderService
  override val databaseService: DatabaseService = new H2DatabaseService
  override val migrationService: ComponentRegistry.MigrationService = new MigrationService
  override val daoService: DaoService = new DaoServiceImpl
  override val actorFactory: ActorFactory = new ActorFactoryImpl
}
