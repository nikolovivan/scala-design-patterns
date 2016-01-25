package com.ivan.nikolov.composition

import com.ivan.nikolov.common.{ConnectorWithHelper, Notifier, Alarm}
import com.ivan.nikolov.composition.self_types.AlarmNotifier

class Watch(brand: String, initialTime: Long) {
  def getTime(): Long = System.currentTimeMillis() - initialTime
}

object WatchUser {
  def main(args: Array[String]): Unit = {
    val expensiveWatch = new Watch("expensive brand", 1000L) with Alarm with Notifier {
      override def trigger(): String = "The alarm was triggered."

      override def clear(): Unit = {
        System.out.println("Alarm cleared.")
      }

      override val notificationMessage: String = "Alarm is running!"
    }
    val cheapWatch = new Watch("cheap brand", 1000L) with Alarm {
      override def trigger(): String = "The alarm was triggered."
    }
    // show some watch usage.
    System.out.println(expensiveWatch.trigger())
    expensiveWatch.printNotification()
    System.out.println(s"The time is ${expensiveWatch.getTime()}.")
    expensiveWatch.clear()
    
    System.out.println(cheapWatch.trigger())
    System.out.println("Cheap watches cannot manually stop the alarm...")
  }
}

// Uncomment if you want to see the error.
//object ReallyExpensiveWatchUser {
//  def main(args: Array[String]): Unit = {
//    val reallyExpensiveWatch = new Watch("really expensive brand", 1000L) with ConnectorWithHelper {
//      override def connect(): Unit = {
//        System.out.println("Connected with another connector.")
//      }
//
//      override def close(): Unit = {
//        System.out.println("Closed with another connector.")
//      }
//    }
//    
//    System.out.println("Using the really expensive watch.")
//    reallyExpensiveWatch.findDriver()
//    reallyExpensiveWatch.connect()
//    reallyExpensiveWatch.close()
//  }
//}

object SelfTypeWatchUser {
  def main(args: Array[String]): Unit = {
    // uncomment to see the self-type error. 
//    val watch = new Watch("alarm with notification", 1000L) with AlarmNotifier {
//    }

    val watch = new Watch("alarm with notification", 1000L) with AlarmNotifier with Notifier {
      override def trigger(): String = "Alarm triggered."

      override def clear(): Unit = {
        System.out.println("Alarm cleared.")
      }

      override val notificationMessage: String = "The notification."
    }
    
    System.out.println(watch.trigger())
    watch.printNotification()
    System.out.println(s"The time is ${watch.getTime()}.")
    watch.clear()
  }
}