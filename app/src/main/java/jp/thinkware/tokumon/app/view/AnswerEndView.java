package jp.thinkware.tokumon.app.view;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.activities.AnswerResultActivity;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.CourseDto;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 結果表示画面のビュークラスです。<br>
 * - MVCモデルのView層の処理を行います。
 * @author thinkware
 */
public class AnswerEndView {

///// field

	/** 結果表示画面のアクティビティ */
	private Activity activity = null;

	/** 成績ID */
	private Long recordId = (long)0;

///// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerEndView(Object obj) {
		//******************************************************************************************
		//* クラス生成時の処理を行う
		//******************************************************************************************
		// アクティビティを設定する
		this.activity = (Activity)obj;
		//*------------------------------------------------------------------------------------*
		//* インテントに保存されたデータを取得する
		//*------------------------------------------------------------------------------------*
		Intent intent = this.activity.getIntent();
		this.recordId = intent.getLongExtra(AnswerSheetDto.COLUMN_RECORD_ID, 0); // 成績ID

		// 画面部品を設定する
		this.setContentView();
	}

	/**
	 * 画面部品を設定します。
	 */
	public void setContentView() {
		//******************************************************************************************
		//* 画面部品を設定する
		//******************************************************************************************
		this.activity.setContentView(R.layout.answer_end_main); // レイアウト
		this.activity.setTitle(R.string.title_answer_end); // 画面タイトル
		//*------------------------------------------------------------------------------------*
		//* [結果を表示する]ボタン
		//*------------------------------------------------------------------------------------*
		// [結果を表示する]ボタンにリスナーを設定する：[OnClickListener]
		Button toAnswerResultBtn = (Button)this.activity.findViewById(R.id.btn_to_answer_result);
		toAnswerResultBtn.setOnClickListener(
			new AnswerEndView.OnClickToAnswerResultBtnListener());
	}

	/**
	 * コース情報を画面コンポーネントに反映します。
	 * @param courseDto コース情報DTO
	 */
	public void setCourseInfo(CourseDto courseDto) {
		//******************************************************************************************
		//* コース情報を画面コンポーネントに反映する
		//******************************************************************************************
		// コース情報が指定されていない場合は終了する
		if (courseDto == null) return;
		//*------------------------------------------------------------------------------------*
		//* [終了メッセージ]テキストビュー
		//*------------------------------------------------------------------------------------*
		TextView endMessageTextView = (TextView)this.activity.findViewById(R.id.text_answer_end_message);
		// フォーマットに従って終了メッセージを整形する
		String endMessageFormat = endMessageTextView.getText().toString(); // メッセージフォーマット
		String endMessage = String.format(endMessageFormat, courseDto.getCourseNameJa());
		// テキストビューに設定する：[終了メッセージ]
		endMessageTextView.setText(endMessage);
	}

//**************************************************************************************************
//* 内部クラス
//**************************************************************************************************

	/**
	 * 「結果を表示する」ボタンクリック時のイベントリスナークラスです。
	 * @author thinkware
	 * @see android.view.View.OnClickListener
	 */
	private class OnClickToAnswerResultBtnListener implements OnClickListener {

///// method

		/**
		 * クリックイベント発生時のイベントハンドラです。
		 * @see android.view.View.OnClickListener#onClick(View)
		 */
		@Override
		public void onClick(View v) {
			//**************************************************************************************
			//* クリックイベント発生時の処理を行う
			//**************************************************************************************
			// 解答結果画面に遷移する
			Intent intent = new Intent(activity, AnswerResultActivity.class);
			intent.putExtra(AnswerSheetDto.COLUMN_RECORD_ID, AnswerEndView.this.recordId); // レコードID
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			activity.startActivity(intent);
		}
	}
}