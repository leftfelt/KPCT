package domain.facegraph

/**
 * Created by TANAKURA on 2014/12/27.
 */
object FaceGraphFeatureCreator {
  def create(faceGraph: FaceGraph): FaceGraphFeature = {
    FaceGraphFeature(faceGraph.featurePoints.map(_.feature).sum / faceGraph.featurePoints.size, None)
  }
}
