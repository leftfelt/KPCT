package infrastructure

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import scala.util.{Failure, Success, Try}

/**
 * Created by TANAKURA on 2014/12/21.
 */
object ImageWriter {

  def write(filename: String, image: BufferedImage): Either[Throwable, Boolean] = {
    Try(ImageIO.write(image, "png", new File(filename))) match {
      case Success(result) => Right(result)
      case Failure(e: Throwable) => Left(e)
    }
  }
}
