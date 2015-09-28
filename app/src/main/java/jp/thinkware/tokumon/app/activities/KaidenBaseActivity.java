package jp.thinkware.tokumon.app.activities;

import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

/**
 * アプリケーションの基底となるアクティビティクラスです。
 * @author thinkware
 */
public class KaidenBaseActivity extends Activity {

// field

	//**********************************************************************************************
	//* 共通変数
	//**********************************************************************************************
	/** ユーザID */
	private static Long userId = (long)1;
	/** コースID */
	private static Long courseId = (long)1;

// accessor

	/**
	 * ユーザIDを取得します。
	 * @return userId ユーザID
	 */
	protected static Long getUserId() {
		return KaidenBaseActivity.userId;
	}

	/**
	 * コースIDを取得します。
	 * @return courseId コースID
	 */
	protected static Long getCourseId() {
		return KaidenBaseActivity.courseId;
	}

// event

	/**
	 * アクティビティ生成時のイベントメソッドです。<br>
	 * - アクティビティ開始時に1度だけ呼び出されます。
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * @param savedInstanceState バンドルオブジェクト
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * オプションメニュー生成時のイベントメソッドです。<br>
	 * - オプションメニューが最初に呼び出される時に1度だけ呼び出されます。
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 * @param menu メニューオブジェクト
	 * @return true / false
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

// method

	/**
	 * DBの初期処理を実行します。<br>
	 * - 端末にDBが作成されていない場合、DBを作成します。
	 */
	protected void initDB() {
		//******************************************************************************************
		//* DBの初期処理を実行する
		//******************************************************************************************
		// データベースヘルパーのインスタンスを作成する（まだデータベースはできない）
		DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
		// データベースオブジェクトを取得する（データベースにアクセスすると作成される）
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		// データベースを閉じる
		db.close();
	}
}
