package com.ivan.nikolov.behavioral.visitor

trait Visitor {
  def visit(title: Title)
  def visit(text: Text)
  def visit(hyperlink: Hyperlink)
}

class HtmlExporterVisitor extends Visitor {
  val line = System.getProperty("line.separator")
  val builder = new StringBuilder
  
  def getHtml(): String = builder.toString
  
  override def visit(title: Title): Unit = {
    builder.append(s"<h1>${title.text}</h1>").append(line)
  }

  override def visit(text: Text): Unit = {
    builder.append(s"<p>${text.text}</p>").append(line)
  }

  override def visit(hyperlink: Hyperlink): Unit = {
    builder.append(s"""<a href=\"${hyperlink.url}\">${hyperlink.text}</a>""").append(line)
  }
}

class PlainTextExporterVisitor extends Visitor {
  val line = System.getProperty("line.separator")
  val builder = new StringBuilder
  
  def getText(): String = builder.toString
  
  override def visit(title: Title): Unit = {
    builder.append(title.text).append(line)
  }

  override def visit(text: Text): Unit = {
    builder.append(text.text).append(line)
  }

  override def visit(hyperlink: Hyperlink): Unit = {
    builder.append(s"${hyperlink.text} (${hyperlink.url})").append(line)
  }
}

object VisitorExample {
  def main(args: Array[String]): Unit = {
    val document = new Document(
      List(
        new Title("The Visitor Pattern Example"),
        new Text("The visitor pattern helps us add extra functionality without changing the classes."),
        new Hyperlink("Go check it online!", "https://www.google.com/"),
        new Text("Thanks!")
      )
    )
    val htmlExporter = new HtmlExporterVisitor
    val plainTextExporter = new PlainTextExporterVisitor
    
    System.out.println(s"Export to html:")
    document.accept(htmlExporter)
    System.out.println(htmlExporter.getHtml())

    System.out.println(s"Export to plain:")
    document.accept(plainTextExporter)
    System.out.println(plainTextExporter.getText())
  }
}
