package jp.thinkware.tokumon.app.activities;

import java.util.HashMap;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.CourseDto;
import jp.thinkware.tokumon.app.helper.thread.ExamTimeThreadHelper;
import jp.thinkware.tokumon.app.model.AnswerEndModel;
import jp.thinkware.tokumon.app.view.AnswerEndView;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * 解答終了画面のアクティビティクラスです。<br>
 * - MVCモデルのControl層の処理を行います。
 * @author thinkware
 */
public class AnswerEndActivity extends KaidenBaseActivity {

///// field

	/** ビュークラス：[解答終了画面] */
	private AnswerEndView view;
	/** モデルクラス：[解答終了画面] */
	private AnswerEndModel model;

///// method

	/**
	 * 初期処理を実行します。
	 */
	public void initialize() {
		// モデル、ビュークラスを生成する
		this.model = new AnswerEndModel(this); // モデルクラス
		this.view  = new AnswerEndView(this);  // ビュークラス
	}

///// method(event)

	/**
	 * アクティビティ生成時のイベントメソッドです。<br />
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
		// 試験時間管理スレッドを終了する
		ExamTimeThreadHelper threadHelper = ExamTimeThreadHelper.getInstance();
		threadHelper.stop();
		// 初期処理を実行する
		this.initialize();
		//*------------------------------------------------------------------------------------*
		//* インテントに保存されたデータを取得する
		//*------------------------------------------------------------------------------------*
		Intent intent = this.getIntent();
		Long recordId = intent.getLongExtra(AnswerSheetDto.COLUMN_RECORD_ID, 0); // 成績ID
		//*------------------------------------------------------------------------------------*
		//* コース情報を画面に反映する
		//*------------------------------------------------------------------------------------*
		/***** コース情報をDBから取得する *****/
		// 抽出条件を生成する
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(CourseDto.COLUMN_COURSE_ID, AnswerEndActivity.getCourseId()); // コースID
		// DBからレコードを抽出する
		CourseDto courseDto = this.model.selectCourseInfo(conditionMap);
		/***** コース情報を画面に反映する *****/
		this.view.setCourseInfo(courseDto);
		//*------------------------------------------------------------------------------------*
		//* 解答用紙レコードを更新する
		//*------------------------------------------------------------------------------------*
		// 更新情報を設定する
		AnswerSheetDto updateDto = new AnswerSheetDto(); // 解答用紙DTO
		updateDto.setRecordId(recordId); // レコードID
		updateDto.setStatus(AnswerSheetDto.STATUS_END); // 状態
		// 解答用紙レコードを更新する
		this.model.updateAnswerSheet(updateDto);
	}

	/**
	 * キーイベントのイベントハンドラです。<br />
	 * - [戻る]ボタンを無効化します。
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