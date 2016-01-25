package com.ivan.nikolov.behavioral.iterator

import scala.collection.mutable.ListBuffer

case class Student(name: String, age: Int)

class StudentIterator(students: Array[Student]) extends Iterator[Student] {
  var currentPos = 0
  
  override def hasNext: Boolean = currentPos < students.size

  override def next(): Student = {
    val result = students(currentPos)
    currentPos = currentPos + 1
    result
  }
}

class ClassRoom extends Iterable[Student] {
  
  val students: ListBuffer[Student] = ListBuffer[Student]()
  
  def add(student: Student): Unit = {
    student +=: students
  }

  override def iterator: Iterator[Student] = new StudentIterator(students.toArray)
}

object ClassRoomExample {
  def main(args: Array[String]): Unit = {
    val classRoom = new ClassRoom
    classRoom.add(Student("Ivan", 26))
    classRoom.add(Student("Maria", 26))
    classRoom.add(Student("John", 25))
    classRoom.foreach(println)
  }
}