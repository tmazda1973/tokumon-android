package jp.thinkware.tokumon.app.activities;

import android.os.Bundle;
import android.view.KeyEvent;

/**
 * ポップアップ画面の基底となるアクティビティクラスです。
 * @author thinkware
 */
public abstract class BasePopupActivity extends KaidenBaseActivity {

// event

	/**
	 * アクティビティ生成時のイベントメソッドです。<br>
	 * - アクティビティ開始時に1度だけ呼び出されます。
	 * @see KaidenBaseActivity#onCreate(Bundle)
	 * @param savedInstanceState バンドルオブジェクト
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 親クラスのメソッドを呼び出す
		super.onCreate(savedInstanceState);
	}

	/**
	 * キーイベントのイベントハンドラです。<br>
	 * - ポップアップ画面では[戻る]ボタンを押下された場合、自画面(アクティビティ)を終了します。
	 * @see android.app.Activity#dispatchKeyEvent(KeyEvent)
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_BACK:
					//*------------------------------------------------------------------------*
					//* ダイアログ表示など、特定の処理を行いたい場合はここに記述する
					//* - 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す。
					//*------------------------------------------------------------------------*
					// 自アクティビティを終了する
					this.finish();
					// 処理終了
					return true;
				default:
					break;
			}
		}
		// 処理終了
		return super.dispatchKeyEvent(event);
	}
}
