package jp.thinkware.tokumon.app.activities;

import android.os.Bundle;

/**
 * DBのテーブル作成・更新用のアクティビティクラスです。
 * @author thinkware
 */
public class DBCreateActivity extends KaidenBaseActivity {

// event

	/**
	 * アクティビティ生成時のイベントメソッドです。<br>
	 * - アクティビティ開始時に1度だけ呼び出されます。
	 * @see KaidenBaseActivity#onCreate(Bundle)
	 * @param savedInstanceState バンドルオブジェクト
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 親クラスのコンストラクタを実行する
		super.onCreate(savedInstanceState);
		// DBの初期処理を実行する
		this.initDB();
	}
}
