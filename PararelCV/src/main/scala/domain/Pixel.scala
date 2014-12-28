package domain

/**
 * 画素を表すケースクラス
 *
 * @param alpha アルファ値
 * @param red R値
 * @param green G値
 * @param blue B値
 */
case class Pixel(alpha: Char, red: Char, green: Char, blue: Char)

/**
 * Pixelを生成するコンパニオンオブジェクト
 */
object Pixel {
  def apply(srgb: Int): Pixel = {
    new Pixel(
      (srgb >> 24).toChar,
      (srgb >> 24 & 0xff).toChar,
      (srgb >> 8 & 0xff).toChar,
      (srgb & 0xff).toChar
    )
  }
}
