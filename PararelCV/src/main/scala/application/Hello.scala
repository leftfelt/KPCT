package application

import infrastructure.{ImageLoader, ImageWriter}

object Hello {

  def main(args: Array[String]): Unit = {
    ImageLoader.load("src/main/resources/4182053.png") match {
      case Right(image) =>
        val subimage = image.getSubimage(600,600,100,100)
        ImageWriter.write("out.png", subimage)
      case Left(e) => System.out.println(e.getMessage)
    }
  }
}