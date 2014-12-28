package domain.facegraph

/**
 * Created by TANAKURA on 2014/12/27.
 */
object FaceGraphFeatureComparer {
  val threshold  = 0.1
  def compare(source: FaceGraphFeature, destination: FaceGraphFeature):Boolean = {
    val distance = Math.sqrt(Math.pow(source.feature - destination.feature, 2.0))
    distance < 0.1
  }
}
