package jp.thinkware.tokumon.app.activities;

import java.util.HashMap;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.model.AnswerResultModel;
import jp.thinkware.tokumon.app.view.AnswerResultView;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * 結果表示画面のアクティビティクラスです。<br>
 * - MVCモデルのControl層の処理を行います。
 * @author thinkware
 */
public class AnswerResultActivity extends KaidenBaseActivity {

///// field

	/** ビュークラス：[結果表示画面] */
	private AnswerResultView view;
	/** モデルクラス：[結果表示画面] */
	private AnswerResultModel model;

///// method

	/**
	 * 初期処理を実行します。
	 */
	public void initialize() {
		// モデル、ビュークラスを生成する
		this.model = new AnswerResultModel(this); // モデルクラス
		this.view  = new AnswerResultView(this);  // ビュークラス
	}

///// method(event)

	/**
	 * アクティビティ生成時のイベントメソッドです。<br>
	 * - アクティビティ開始時に1度だけ呼び出されます。
	 * @see KaidenBaseActivity#onCreate(Bundle)
	 * @param savedInstanceState バンドルオブジェクト
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//******************************************************************************************
		//* アクティビティ生成時の処理を実行する
		//******************************************************************************************
		// 親クラスのコンストラクタを実行する
		super.onCreate(savedInstanceState);
		// 初期処理を実行する
		this.initialize();
		//*------------------------------------------------------------------------------------*
		//* インテントに保存されたデータを取得する
		//*------------------------------------------------------------------------------------*
		Intent intent = this.getIntent();
		Long recordId = intent.getLongExtra(AnswerDto.COLUMN_RECORD_ID, 0); // 成績ID
		//*------------------------------------------------------------------------------------*
		//* 解答用紙情報を画面に反映する
		//*------------------------------------------------------------------------------------*
		/*** 解答用紙情報をDBから取得する ***/
		// 抽出条件を生成する
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(AnswerSheetDto.COLUMN_RECORD_ID, String.valueOf(recordId)); // 成績ID
		// DBからレコードを抽出する
		AnswerSheetDto answerSheetDto = this.model.selectWithJoin(conditionMap);
		/*** 解答用紙情報を画面に反映する ***/
		this.view.setAnswerSheetData(answerSheetDto);
	}

	/**
	 * キーイベントのイベントハンドラです。<br>
	 * - ポップアップ画面では[戻る]ボタンを無効化します。
	 * @see android.app.Activity#dispatchKeyEvent(KeyEvent)
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			switch (event.getKeyCode()) {
			case KeyEvent.KEYCODE_BACK:
				// ダイアログ表示など特定の処理を行いたい場合はここに記述
				// 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
				return true;
			}
		}
		// 処理終了
		return super.dispatchKeyEvent(event);
	}
}