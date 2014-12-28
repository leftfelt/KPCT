package domain.wevelet

/**
 * ガボールウェーブレットを表すケースクラス
 */
case class GaborWevelet(gaborWeveletFeatures: Seq[GaborWeveletFeature], width: Int, height: Int)
