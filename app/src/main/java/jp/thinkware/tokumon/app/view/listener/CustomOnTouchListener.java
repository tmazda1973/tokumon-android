package jp.thinkware.tokumon.app.view.listener;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * タップ操作時の独自イベントリスナークラスです。
 * @author thinkware
 * @see android.view.View.OnTouchListener
 */
public class CustomOnTouchListener implements OnTouchListener {

// field

	/** 親アクティビティ */
	private Activity parent = null;
	/** タップ開始時の時刻(ミリ秒) */
	private long touchStartTime = 0;

// method

	/**
	 * コンストラクタ
	 * @param parent 親アクティビティ
	 */
	public CustomOnTouchListener(Activity parent) {
		//******************************************************************************************
		//* インスタンス生成時の初期処理を実行する
		//******************************************************************************************
		// 親クラスのコンストラクタを実行する
		super();
		// 親アクティビティを設定する
		this.parent = parent;
	}

	/**
	 * タップイベント発生時のイベントハンドラです。
	 * @see android.view.View.OnTouchListener#onTouch(View, MotionEvent)
	 */
	@Override
	public boolean onTouch(View v, MotionEvent motionEvent) {
		//******************************************************************************************
		//* タップイベント発生時の処理を行う
		//******************************************************************************************
		// タップしていた指が画面から離れた場合
		if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
			// タップ間隔を算出する
			long touchTimeSpan = SystemClock.uptimeMillis() - this.touchStartTime;
			// 押されていた時間が0.2秒未満の場合
			if (touchTimeSpan < 200) {
				// アクティビティを終了する
				this.parent.finish();
			}
		}
		// 画面をタップした場合
		else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			// タップ開始時刻を保持する
			this.touchStartTime = SystemClock.uptimeMillis();
		}

		// 処理終了
		return false;
	}
}
