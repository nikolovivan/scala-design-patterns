package com.ivan.nikolov.aop

import com.ivan.nikolov.aop.model.Person

trait LoggingDataReader extends DataReader {
  
  abstract override def readData(): List[Person] = {
    val startMillis = System.currentTimeMillis()
    val result = super.readData()
    val time = System.currentTimeMillis() - startMillis
    System.err.println(s"readData took ${time} milliseconds.")
    result
  }
  
  abstract override def readDataInefficiently(): List[Person] = {
    val startMillis = System.currentTimeMillis()
    val result = super.readDataInefficiently()
    val time = System.currentTimeMillis() - startMillis
    System.err.println(s"readDataInefficiently took ${time} milliseconds.")
    result
  }
}
