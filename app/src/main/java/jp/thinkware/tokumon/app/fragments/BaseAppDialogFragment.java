package jp.thinkware.tokumon.app.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

/**
 * ダイアログ画面の基底となるフラグメントクラスです。
 * @author thinkware
 */
public abstract class BaseAppDialogFragment extends DialogFragment {

///// function

	public static BaseAppDialogFragment getInstance(int title, int layout) {
		BaseAppDialogFragment fragment = new BaseAppDialogFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		// 処理終了
		return fragment;
	}

///// event

	/**
	 * アクティビティ生成時のイベントメソッドです。<br>
	 * - アクティビティ開始時に1度だけ呼び出されます。
	 * @see DialogFragment#onCreate(Bundle)
	 * @param savedInstanceState バンドルオブジェクト
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 親クラスのメソッドを呼び出す
		super.onCreate(savedInstanceState);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//*------------------------------------------------------------------------------------*
		//* ダイアログを生成する
		//*------------------------------------------------------------------------------------*
		Dialog dialog = new Dialog(getActivity());
//		// タイトル非表示
//		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		// フルスクリーン
		dialog.getWindow().setFlags(
			WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
		);
		dialog.setTitle(savedInstanceState.getInt("title")); // タイトル
		dialog.setContentView(savedInstanceState.getInt("layout")); // レイアウト
		// 処理終了
		return dialog;
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
					// ダイアログを非表示にする
					this.onDismiss(this.getDialog());
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
