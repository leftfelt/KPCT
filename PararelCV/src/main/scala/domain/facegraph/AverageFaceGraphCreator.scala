package domain.facegraph

/**
 * Created by TANAKURA on 2014/12/27.
 */
object AverageFaceGraphCreator {
  def create(faceGraphs: Seq[FaceGraph]): Option[FaceGraph] = {
    faceGraphs.headOption.map(graph => getAverageFaceGraph(graph, faceGraphs.tail))
  }

  private def getAverageFaceGraph(faceGraph: FaceGraph, faceGraphs: Seq[FaceGraph]): FaceGraph = {
    faceGraphs.headOption match {
      case Some(graph) =>
        val averageFaceGraph = average(faceGraph, graph)
        getAverageFaceGraph(averageFaceGraph, faceGraphs.tail)
      case None => faceGraph
    }
  }

  private def average(A: FaceGraph, B: FaceGraph): FaceGraph = {
    val featurePointsZip = A.featurePoints zip B.featurePoints
    FaceGraph(
      featurePointsZip.map(t =>
        FeaturePoint(
          (t._1.feature + t._2.feature) / 2,
          (t._1.x + t._2.x) / 2,
          (t._1.y + t._2.y) / 2
        )
      ),
      None
    )
  }
}
