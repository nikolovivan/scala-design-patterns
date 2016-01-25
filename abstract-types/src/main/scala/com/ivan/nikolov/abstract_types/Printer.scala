package com.ivan.nikolov.abstract_types

abstract class PrintData
abstract class PrintMaterial
abstract class PrintMedia

case class Paper() extends PrintMedia
case class Air() extends PrintMedia

case class Text() extends PrintData
case class Model() extends PrintData

case class Toner() extends PrintMaterial
case class Plastic() extends PrintMaterial

trait Printer {
  type Data <: PrintData
  type Material <: PrintMaterial
  type Media <: PrintMedia
  
  def print(data: Data, material: Material, media: Media) =
    s"Printing $data with $material material on $media media."
}

trait GenericPrinter[Data <: PrintData, Material <: PrintMaterial, Media <: PrintMedia] {
  def print(data: Data, material: Material, media: Media) =
    s"Printing $data with $material material on $media media."
}

class LaserPrinter extends Printer {
  type Media = Paper
  type Data = Text
  type Material = Toner
}

class ThreeDPrinter extends Printer {
  type Media = Air
  type Data = Model
  type Material = Plastic
}

class GenericLaserPrinter[Data <: Text, Material <: Toner, Media <: Paper] extends GenericPrinter[Data, Material, Media]
class GenericThreeDPrinter[Data <: Model, Material <: Plastic, Media <: Air] extends GenericPrinter[Data, Material, Media]

class GenericPrinterImpl[Data <: PrintData, Material <: PrintMaterial, Media <: PrintMedia] extends GenericPrinter[Data, Material, Media]

object PrinterExample {
  def main(args: Array[String]): Unit = {
    val laser = new LaserPrinter
    val threeD = new ThreeDPrinter
    
    val genericLaser = new GenericLaserPrinter[Text, Toner, Paper]
    val genericThreeD = new GenericThreeDPrinter[Model, Plastic, Air]
    
    val wrongPrinter = new GenericPrinterImpl[Model, Toner, Air]
    
    System.out.println(laser.print(Text(), Toner(), Paper()))
    System.out.println(threeD.print(Model(), Plastic(), Air()))
    
    System.out.println(genericLaser.print(Text(), Toner(), Paper()))
    System.out.println(genericThreeD.print(Model(), Plastic(), Air()))
    
    System.out.println(wrongPrinter.print(Model(), Toner(), Air()))
  }
}