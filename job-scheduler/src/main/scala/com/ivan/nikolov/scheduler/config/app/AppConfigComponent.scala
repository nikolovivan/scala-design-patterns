package com.ivan.nikolov.scheduler.config.app

import com.typesafe.config.ConfigFactory

trait AppConfigComponent {

  val appConfigService: AppConfigService
  
  class AppConfigService() {
    //-Dconfig.resource=production.conf for overriding
    private val conf = ConfigFactory.load()
    private val appConf = conf.getConfig("job-scheduler")
    private val db = appConf.getConfig("db")
    
    val configPath = appConf.getString("config-path")
    val configExtension = appConf.getString("config-extension")
    val workers = appConf.getInt("workers")
    
    val dbConnectionString = db.getString("connection-string")
    val dbUsername = db.getString("username")
    val dbPassword = db.getString("password")
  }
}
