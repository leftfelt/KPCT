package domain.facegraph

import java.awt.Point
import java.awt.image.BufferedImage

import domain.wevelet.{GaborWeveletCreator, GaborWevelet}

/**
 * Created by TANAKURA on 2014/12/27.
 */
object FaceGraphOptimizer {
  def optimize(averageFaceGraph: FaceGraph, image: BufferedImage): FaceGraph = {
    //TODO: パラメータを別の場所に保存
    val wevelet = GaborWeveletCreator.create(10, 10, 1.0, 0.0, 8.0, 0.0, 1)
    FaceGraph(averageFaceGraph.featurePoints.map(featurePoint =>
      search(featurePoint, wevelet, image)
    ),
    None)
  }

  private def search(featurePoint: FeaturePoint, wevelet: GaborWevelet, image: BufferedImage): FeaturePoint = {
    val range = 10
    val points = for {
      x <- featurePoint.x - range to featurePoint.x + range
      y <- featurePoint.y - range to featurePoint.y + range
    } yield {
      val point = convolution(new Point(x, y), wevelet, image)
      (point, Math.sqrt(Math.pow(featurePoint.feature - point.feature, 2.0)))
    }
    points.sortBy(t => t._2).head._1
  }

  private def convolution(point: Point, wevelet: GaborWevelet, image: BufferedImage): FeaturePoint = {
    val subimage = image.getRGB(point.x, point.y, wevelet.width, wevelet.height, null, 0, 0)
    val zip = wevelet.gaborWeveletFeatures.map(_.value) zip subimage
    FeaturePoint(zip.map(t => t._1 * t._2).sum, point.x, point.y)
  }
}
