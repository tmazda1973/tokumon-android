package jp.thinkware.tokumon.app.common.util;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;

/**
 * 画面部品に関する共通ユーティリティクラスです。
 * @author thinkware
 */
public final class UIContentsUtils {

	/**
	 * コンストラクタ(インスタンス生成不可)
	 */
	private UIContentsUtils() {}

	/**
	 * カスケード表示を行うアニメーションコントローラを取得します。
	 * @return アニメーションコントローラ
	 */
	public static LayoutAnimationController getCascadeAnimation() {
		//******************************************************************************
		//* アニメーションコントローラを生成する：[カスケード表示]
		//******************************************************************************
		AnimationSet set = new AnimationSet(true); // アニメーションセット
		//*------------------------------------------------------------------------*
		//* アニメーション：[フェイドイン／アウト]
		//*------------------------------------------------------------------------*
		Animation animation = new AlphaAnimation(0.0f, 1.0f); // フェイドイン／アウト
		animation.setDuration(50);
		set.addAnimation(animation);
		//*------------------------------------------------------------------------*
		//* アニメーション：[移動]
		//*------------------------------------------------------------------------*
		animation = new TranslateAnimation(
			Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
			Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
		);
		animation.setDuration(100);
		set.addAnimation(animation);

		// アニメーションコントローラを生成する
		LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);

		// 処理終了
		return controller;
	}
}
