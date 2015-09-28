package jp.thinkware.tokumon.app.activities;

import java.util.HashMap;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.model.AnswerQuestionPopupModel;
import jp.thinkware.tokumon.app.view.AnswerQuestionPopupView;
import android.content.Intent;
import android.os.Bundle;

/**
 * 解答問題ポップアップ画面のアクティビティクラスです。<br>
 * - MVCモデルのControl層の処理を行います。
 * @author thinkware
 */
public class AnswerQuestionPopupActivity extends BasePopupActivity {

///// field

	/** ビュークラス：[解答問題ポップアップ画面] */
	private AnswerQuestionPopupView view;
	/** モデルクラス：[解答問題ポップアップ画面] */
	private AnswerQuestionPopupModel model;

///// method

	/**
	 * 初期処理を実行します。
	 */
	public void initialize() {
		// モデル、ビュークラスを生成する
		this.model = new AnswerQuestionPopupModel(this); // モデルクラス
		this.view  = new AnswerQuestionPopupView(this);  // ビュークラス
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
		Long recordId   = intent.getLongExtra(AnswerSheetDto.COLUMN_RECORD_ID, 0); // 成績ID
		Long questionId = intent.getLongExtra(AnswerDto.COLUMN_QUESTION_ID, 0);    // 設問ID
		//*------------------------------------------------------------------------------------*
		//* DBから抽出したデータを画面に反映する
		//*------------------------------------------------------------------------------------*
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		/*** 解答用紙情報をDBから取得する ***/
		// 抽出条件を生成する
		conditionMap.put(AnswerSheetDto.COLUMN_RECORD_ID, String.valueOf(recordId)); // 成績ID
		conditionMap.put(AnswerDto.COLUMN_QUESTION_ID, String.valueOf(questionId));  // 設問ID
		// DBからレコードを抽出する
		AnswerSheetDto answerSheetDto = this.model.selectAnswerSheetWithJoin(conditionMap);
		/*** 解答用紙情報を画面に反映する ***/
		this.view.setAnswerSheetData(answerSheetDto);
		// 解答情報が存在する場合
		if (!answerSheetDto.getJoin().getAnswerDtoList().isEmpty()) {
			/*** 解答情報を画面に反映する ***/
			AnswerDto answerDto = answerSheetDto.getJoin().getAnswerDtoList().get(0);
			this.view.setAnswerData(answerDto);
		}
	}
}