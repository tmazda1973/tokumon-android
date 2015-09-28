package jp.thinkware.tokumon.app.activities;

import java.util.HashMap;
import java.util.Map;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.CourseDto;
import jp.thinkware.tokumon.app.dto.KaidenUserDto;
import jp.thinkware.tokumon.app.helper.thread.ExamTimeThreadHelper;
import jp.thinkware.tokumon.app.model.ExamStartModel;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author noda
 *
 */
public class ExamStartActivity extends KaidenBaseActivity implements OnTouchListener {

// field

	/** モデルクラス：[試験開始画面] */
	private ExamStartModel model = null;

// method

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam_start);
		//*------------------------------------------------------------------------*
		//* 初期処理を実行する
		//*------------------------------------------------------------------------*
		// モデル、ビュークラスを生成する
		this.model = new ExamStartModel(this);

		//*------------------------------------------------------------------------*
		//* コース情報を画面に反映する
		//*------------------------------------------------------------------------*
		/***** コース情報をDBから取得する *****/
		// 抽出条件を生成する
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(CourseDto.COLUMN_COURSE_ID, ExamStartActivity.getCourseId()); // コースID
		// DBからレコードを抽出する
		CourseDto courseDto = this.model.selectCourseInfo(conditionMap);
		// コース情報が存在する場合
		if (courseDto != null) {
			//*--------------------------------------------------------------------*
			//* コース名
			//*--------------------------------------------------------------------*
			TextView courseNameView = (TextView)this.findViewById(R.id.text_course_name);
			// テキストビューに設定する：[コース名]
			courseNameView.setText(courseDto.getCourseNameJa());
			//*--------------------------------------------------------------------*
			//* 設問数
			//*--------------------------------------------------------------------*
			TextView questionCountView = (TextView)this.findViewById(R.id.text_question_count);
			// テキストビューに設定する：[設問数]
			questionCountView.setText(String.valueOf(courseDto.getQuestionCount()));
			//*--------------------------------------------------------------------*
			//* 制限時間
			//*--------------------------------------------------------------------*
			TextView timeLimitView = (TextView)this.findViewById(R.id.text_time_limit);
			// 受験時間が設定されていない場合
			if (courseDto.getExamTime() <= 0) {
				// テキストビューに設定する：[制限時間なし]
				timeLimitView.setText(this.getResources().getText(R.string.val_time_limit));
			}
			// 受験時間が設定されている場合
			else {
				// テキストビューに設定する：[受験時間]
				timeLimitView.setText(String.valueOf(courseDto.getExamTime()));
			}
		}

		// 問題画面へ遷移するダミーボタン
		/*
		Button btnQuestion = (Button) this.findViewById(R.id.go_question);
		btnQuestion.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//
				Intent intent = new Intent(ExamStartActivity.this, TestActivity.class);
				startActivity(intent);
			}
		});
		*/

		View examView = findViewById(R.id.activity_exam);
		examView.setOnTouchListener(this);

		// コースメニューに戻るダミーボタン（後で削除）
		Button btnPrefCourseMenu = (Button) this.findViewById(R.id.prev_course_menu);
		btnPrefCourseMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
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
		//******************************************************************************
		//* 画面タッチ時の処理を実行する
		//******************************************************************************
		// タップしていた指が画面から離れた場合
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			//*------------------------------------------------------------------------*
			//* 試験情報を登録する
			//*------------------------------------------------------------------------*
			// 抽出条件を生成する
			Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
			conditionMap.put(AnswerSheetDto.COLUMN_COURSE_ID, getCourseId()); // コースID
			conditionMap.put(AnswerSheetDto.COLUMN_USER_ID, getUserId()); // ユーザID
			// 試験情報をDBに登録する
			Long recordId = this.model.insertExamInfo(conditionMap);
			//*------------------------------------------------------------------------*
			//* 解答用紙レコードを更新する
			//*------------------------------------------------------------------------*
			// 更新情報を設定する
			AnswerSheetDto updateDto = new AnswerSheetDto(); // 解答用紙DTO
			updateDto.setRecordId(recordId); // レコードID
			updateDto.setStatus(AnswerSheetDto.STATUS_ACTIVE); // 状態：[実施中]
			// 解答用紙レコードを更新する
			this.model.updateAnswerSheet(updateDto);
			//*------------------------------------------------------------------------*
			//* 試験時間管理スレッドを開始する
			//*------------------------------------------------------------------------*
			ExamTimeThreadHelper threadHelper = ExamTimeThreadHelper.getInstance();
			threadHelper.start();
			//*------------------------------------------------------------------------*
			//* 問題画面に遷移する
			//*------------------------------------------------------------------------*
			Intent intent = new Intent(ExamStartActivity.this, QuestionActivity.class);
			intent.putExtra(KaidenUserDto.COLUMN_USER_ID, getUserId()); // ユーザID
			intent.putExtra(AnswerSheetDto.COLUMN_RECORD_ID, recordId); // 成績ID
			this.startActivity(intent);
		}

		// 処理終了
		return false;
	}
}
