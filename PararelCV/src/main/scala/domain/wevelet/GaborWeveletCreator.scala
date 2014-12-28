package domain.wevelet

/**
 * ガボールウェーブレットを生成するクラス
 */
object GaborWeveletCreator {

  /**
   * ガボールウェーブレットを生成する
   * @param width
   * @param height
   * @param sigma
   * @param theta
   * @param lambda
   * @param psi
   * @param gamma
   * @return
   */
  def create(width: Int, height: Int, sigma: Double, theta: Double, lambda: Double, psi: Double, gamma: Double): GaborWevelet = {
    val gaborWeveletFeatures = 0 to height map { y =>
      0 to width map { x =>
        createByPoint(x, y, sigma, theta, lambda, psi, gamma)
      }
    }
    GaborWevelet(gaborWeveletFeatures.flatten.toSeq, width, height)
  }



  /**
   * 指定した座標のガボールウェーブレット値を生成する
   * @param x
   * @param y
   * @param sigma
   * @param theta
   * @param lambda
   * @param psi
   * @param gamma
   * @return
   */
  private def createByPoint(x: Int, y: Int, sigma: Double, theta: Double, lambda: Double, psi: Double, gamma: Double): GaborWeveletFeature = {
    GaborWeveletFeature(
      Math.exp(
        (x*x + gamma*gamma * y*y) / (2*sigma)
      ) * Math.cos(
        2* Math.PI * (x/lambda) + psi
      )
    )
  }
}
