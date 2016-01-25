package com.ivan.nikolov.structural.facade

import com.ivan.nikolov.structural.facade.model.Person

class DataReader extends DataDownloader with DataDecoder with DataDeserializer {

  def readPerson(url: String): Person = {
    val data = download(url)
    val json = decode(data)
    parse[Person](json)
  }
}

object FacadeExample {
  def main(args: Array[String]): Unit = {
    val reader = new DataReader
    System.out.println(s"We just read the following person: ${reader.readPerson("http://www.ivan-nikolov.com/")}")
  }
}
