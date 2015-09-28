package jp.thinkware.tokumon.app.activities;

import jp.thinkware.tokumon.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;

/**
 * スプラッシュ画面のアクティビティ.
 * アプリ起動時に1度だけ表示される
 * 画面をタップするか、5秒経過するとMainMenuActivity(メインメニュー)に遷移する。
 *
 * @author noda
 */
public class SplashActivity extends KaidenBaseActivity
implements OnTouchListener {

    /**
     * アクティビティ生成時のメソッド.
     * - アクティビティ開始時に1度だけ呼び出されます。
     *
     * @see SplashActivity
     * @param savedInstanceState バンドルオブジェクト
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        // スーパークラスのコンストラクタを実行
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // DBの初期化を実行
        this.initDB();

        // 画面をタッチしたらメニュー画面に遷移
        View splashView = findViewById(R.id.activity_splash);
        splashView.setOnTouchListener(this);

        // 5秒でメニュー画面に遷移
        Handler handler = new Handler();
        handler.postDelayed(new SplashHandler(), 5000);
    }

	/**
	 * タッチイベント発生時のメソッド.
	 *
	 * @param v ビューオブジェクト
	 * @param event モーションイベント
	 * @return boolean
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Log.v("event", "onTouch");
		Intent intent = new Intent(SplashActivity.this, MainMenuActivity.class);
		startActivity(intent);
		return false;
	}

	/**
	 * ○○○インナークラス.
	 * コメントをどう書くべきか迷う・・・
	 */
	class SplashHandler implements Runnable {

		/**
		 * ○○○メソッド.
		 */
		@Override
		public void run() {
			Intent intent = new Intent(SplashActivity.this, MainMenuActivity.class);
			startActivity(intent);
		}

	}
}
