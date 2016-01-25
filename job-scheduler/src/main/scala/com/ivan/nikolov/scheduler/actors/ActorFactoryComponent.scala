package com.ivan.nikolov.scheduler.actors

import com.ivan.nikolov.scheduler.config.app.AppConfigComponent
import com.ivan.nikolov.scheduler.dao.DaoServiceComponent

trait ActorFactory {
  def createMasterActor(): Master
  def createWorkerActor(): Worker
}

trait ActorFactoryComponent {
  this: AppConfigComponent
    with DaoServiceComponent =>
  
  val actorFactory: ActorFactory
  
  class ActorFactoryImpl extends ActorFactory {
    override def createMasterActor(): Master = new Master(appConfigService.workers, this)

    override def createWorkerActor(): Worker = new Worker(daoService)
  } 
}
