package jp.thinkware.tokumon.app.activities;

import java.util.HashMap;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.model.AnswerPopupModel;
import jp.thinkware.tokumon.app.view.AnswerPopupView;
import android.content.Intent;
import android.os.Bundle;

/**
 * 解答ポップアップ画面のアクティビティクラスです。<br>
 * - MVCモデルのControl層の処理を行います。
 * @author thinkware
 */
public class AnswerPopupActivity extends BasePopupActivity {

///// field

	/** ビュークラス：[解答ポップアップ画面] */
	private AnswerPopupView view;
	/** モデルクラス：[解答ポップアップ画面] */
	private AnswerPopupModel model;

///// method

	/**
	 * 初期処理を実行します。
	 */
	public void initialize() {
		// モデル、ビュークラスを生成する
		this.model = new AnswerPopupModel(this); // モデルクラス
		this.view  = new AnswerPopupView(this);  // ビュークラス
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
		Long recordId   = intent.getLongExtra(AnswerDto.COLUMN_RECORD_ID, 0);   // 成績ID
		Long questionId = intent.getLongExtra(AnswerDto.COLUMN_QUESTION_ID, 0); // 設問ID
		//*------------------------------------------------------------------------------------*
		//* 解答情報を画面に反映する
		//*------------------------------------------------------------------------------------*
		/***** 解答情報をDBから取得する *****/
		// 抽出条件を生成する
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(AnswerDto.COLUMN_RECORD_ID, String.valueOf(recordId));     // 成績ID
		conditionMap.put(AnswerDto.COLUMN_QUESTION_ID, String.valueOf(questionId)); // 設問ID
		// DBからレコードを抽出する
		AnswerDto answerDto = this.model.selectWithJoin(conditionMap);
		/***** 解答情報を画面に反映する *****/
		this.view.setAnswerData(answerDto);
	}
}