package com.ivan.nikolov

import com.ivan.nikolov.pimp.model.Person

package object pimp {

  implicit class StringExtensions(val s: String) extends AnyVal {
    
    def isAllUpperCase: Boolean =
      (0 to s.size - 1).find {
        case index =>
          !s.charAt(index).isUpper
      }.isEmpty
    
  }
  
  implicit class PersonSeqExtensions(val seq: Iterable[Person]) extends AnyVal {
    
    def saveToDatabase(): Unit = {
      seq.foreach {
        case person =>
          System.out.println(s"Saved: ${person} to the database.")
      }
    }
    
  }
}
