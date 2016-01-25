package com.ivan.nikolov.scheduler

import com.ivan.nikolov.scheduler.actors.{ActorFactory, ActorFactoryComponent}
import com.ivan.nikolov.scheduler.config.app.AppConfigComponent
import com.ivan.nikolov.scheduler.dao._
import com.ivan.nikolov.scheduler.io.IOServiceComponent
import com.ivan.nikolov.scheduler.services.JobConfigReaderServiceComponent
import org.scalatest.mock.MockitoSugar

import org.mockito.Mockito._

trait TestEnvironment 
  extends AppConfigComponent
  with IOServiceComponent
  with JobConfigReaderServiceComponent
  with DatabaseServiceComponent
  with MigrationComponent
  with DaoServiceComponent
  with ActorFactoryComponent
  with MockitoSugar {

  // use the test configuration file.
  override val appConfigService: AppConfigService = spy(new AppConfigService)
  // override the path here to use the test resources.
  when(appConfigService.configPath).thenReturn(this.getClass.getResource("/").getPath)
  
  override val ioService: IOService = mock[IOService]
  override val jobConfigReaderService: JobConfigReaderService = mock[JobConfigReaderService]
  override val databaseService: DatabaseService = mock[DatabaseService]
  override val migrationService: MigrationService = mock[MigrationService]
  override val daoService: DaoService = mock[DaoService]
  override val actorFactory: ActorFactory = mock[ActorFactory]
}
