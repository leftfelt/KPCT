package infrastructure

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import scala.util.{Failure, Success, Try}

/**
 * 画像を読み込むクラス
 */
object ImageLoader {

  /**
   * ファイル名を指定して読み込む
   *
   * @param filename ファイル名
   * @return
   */
  def load(filename: String): Either[Throwable, BufferedImage] = {
    Try(ImageIO.read(new File(filename))) match {
      case Success(image) => Right(image)
      case Failure(e: Throwable) => Left(e)
    }
  }
}
