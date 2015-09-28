package jp.thinkware.tokumon.app.view;

import java.util.List;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.activities.AnswerQuestionPopupActivity;
import jp.thinkware.tokumon.app.activities.MainMenuActivity;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.common.util.UIContentsUtils;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.helper.thread.ExamTimeThreadHelper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 結果表示画面のビュークラスです。<br>
 * - MVCモデルのView層の処理を行います。
 * @author thinkware
 */
public class AnswerResultView {

// field

	/** 結果表示画面のアクティビティ */
	private Activity activity = null;
	/** 部品オブジェクト：[結果表示リストビュー] */
	private ListView resultListView = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerResultView(Object obj) {
		//******************************************************************************************
		//* クラス生成時の処理を行う
		//******************************************************************************************
		// アクティビティを設定する
		this.activity = (Activity)obj;
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
		// タイトルバーをカスタム宣言する
		this.activity.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		this.activity.setContentView(R.layout.answer_result_main); // レイアウト
		// カスタムタイトルバーを設定する
		this.activity.getWindow().setFeatureInt(
			Window.FEATURE_CUSTOM_TITLE, R.layout.answer_result_titlebar);
		this.activity.setTitle(R.string.title_answer_result); // 画面タイトル
		//*------------------------------------------------------------------------------------*
		//* [結果表示]リスト
		//*------------------------------------------------------------------------------------*
		// リスナーを設定する：[OnItemClickListener]
		this.resultListView = (ListView)this.activity.findViewById(R.id.list_answer_result);
		this.resultListView.setOnItemClickListener(
			new AnswerResultView.OnResultListItemClickListner());
		// アニメーションコントローラを取得する：[カスケード表示]
		this.resultListView.setLayoutAnimation(UIContentsUtils.getCascadeAnimation());
		//*------------------------------------------------------------------------------------*
		//* [メニューに戻る]アイコン
		//*------------------------------------------------------------------------------------*
		// リスナーを設定する：[OnClickListener]
		ImageView prevMenuImageView = (ImageView)this.activity.findViewById(R.id.ic_prev_menu);
		prevMenuImageView.setOnClickListener(
			new AnswerResultView.OnClickPrevMenuBtnListner());
	}

	/**
	 * 解答用紙情報を画面コンポーネントに反映します。
	 * @param answerSheetDto 解答用紙DTO
	 */
	public void setAnswerSheetData(AnswerSheetDto answerSheetDto) {
		//******************************************************************************************
		//* 解答用紙情報を画面コンポーネントに反映する
		//******************************************************************************************
		// 解答用紙情報が指定されていない場合は終了する
		if (answerSheetDto == null) {
			// 処理終了
			return;
		}
		//*-------------------------------------------------------------------------------------*
		//* [正解率]テキストビュー
		//*-------------------------------------------------------------------------------------*
		TextView correctPerTextView = (TextView)this.activity.findViewById(R.id.text_correct_per);
		Long correctPerValue = answerSheetDto.getCorrectPer(); // 正解率
		// テキストビューに設定する：[正解率]
		correctPerTextView.setText(String.valueOf(correctPerValue));
		//*-------------------------------------------------------------------------------------*
		//* [経過時間]テキストビュー
		//*-------------------------------------------------------------------------------------*
		TextView elapsedTimeTextView = (TextView)this.activity.findViewById(R.id.text_elapsed_time);
		Long elapsedTimeMinute = ExamTimeThreadHelper.getInstance().getElapsedTimeMinute(); // 経過時間(分)
		// テキストビューに設定する：[経過時間]
		elapsedTimeTextView.setText(String.valueOf(elapsedTimeMinute));
		//*-------------------------------------------------------------------------------------*
		//* [結果一覧]リストビュー
		//*-------------------------------------------------------------------------------------*
		AnswerResultAdapter adapter = // アダプタークラス：[結果一覧]
			new AnswerResultAdapter(
				this.activity.getApplicationContext(),
				answerSheetDto.getJoin().getAnswerDtoList());
		// リストビューにアダプタークラスを設定する
		this.resultListView.setAdapter(adapter);
	}

//**************************************************************************************************
//* 内部クラス
//**************************************************************************************************

	/**
	 * 「メニューに戻る」ボタンクリック時のイベントリスナークラスです。
	 * @author thinkware
	 * @see android.view.View.OnClickListener
	 */
	private class OnClickPrevMenuBtnListner implements OnClickListener {

// method

		/**
		 * クリックイベント発生時のイベントハンドラです。
		 * @see android.view.View.OnClickListener#onClick(View)
		 */
		@Override
		public void onClick(View v) {
			// メニュー画面に遷移する
			Intent intent =
				new Intent(AnswerResultView.this.activity.getApplicationContext(), MainMenuActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
			AnswerResultView.this.activity.startActivity(intent);
		}
	}

	/**
	 * 結果表示一覧の項目クリック時のイベントリスナークラスです。
	 * @author thinkware
	 * @see android.widget.AdapterView.OnItemClickListener
	 */
	private class OnResultListItemClickListner implements OnItemClickListener {

///// method

		/**
		 * ListViewの項目クリック時のイベントハンドラです。
		 * @see OnItemClickListener
		 */
		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
			// 現在行の解答情報を取得する
			AnswerDto answerDto = (AnswerDto)adapter.getAdapter().getItem(position);
			//*--------------------------------------------------------------------------------*
			//* 問題ポップアップ画面に遷移する
			//*--------------------------------------------------------------------------------*
			Intent intent =
				new Intent(AnswerResultView.this.activity.getApplicationContext(), AnswerQuestionPopupActivity.class);
			intent.putExtra(AnswerDto.COLUMN_RECORD_ID, answerDto.getRecordId());     // レコードID
			intent.putExtra(AnswerDto.COLUMN_QUESTION_ID, answerDto.getQuestionId()); // 設問ID
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			AnswerResultView.this.activity.startActivity(intent);
		}
	 }

	/**
	 * 結果表示一覧の独自実装アダプタークラスです。
	 * @author thinkware
	 * @see android.widget.ArrayAdapter
	 */
	private class AnswerResultAdapter extends ArrayAdapter<AnswerDto> {

///// method

		/**
		 * コンストラクタ
		 * @param context コンテキストオブジェクト
		 * @param objects 一覧データ
		 */
		public AnswerResultAdapter(Context context, List<AnswerDto> objects) {
			super(context, 0, objects);
		}

		/**
		 * 項目行のビューオブジェクトを取得します。
		 * @see ArrayAdapter#getView(int, View, ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//**************************************************************************************
			//* 項目行のビューオブジェクトを取得する
			//**************************************************************************************
			View listRowView = convertView; // 項目行のビューオブジェクト
			// 項目行のビューオブジェクトが存在しない場合
			if (listRowView == null) {
				// レイアウト定義からビューオブジェクトを生成する
				LayoutInflater inflater =
					(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				listRowView = inflater.inflate(R.layout.answer_result_list_row, null);
			}
			//*--------------------------------------------------------------------------------*
			//* 項目行の画面コンポーネントに解答情報を反映する
			//*--------------------------------------------------------------------------------*
			// 現在行の解答情報を取得する
			AnswerDto answerDto = this.getItem(position);
			// 解答情報が存在しない場合
			if (answerDto == null) {
				// 処理終了
				return listRowView;
			}
			//*----------------------------------------------------------------------------*
			//* [設問番号]テキストビュー
			//*----------------------------------------------------------------------------*
			String questionNo =  "問" + answerDto.getQuestionNo();
			// 設問番号をテキストビューに設定する
			TextView questionNoTextView =
				(TextView)listRowView.findViewById(R.id.text_list_row_question_no);
			questionNoTextView.setText(questionNo);
			//*----------------------------------------------------------------------------*
			//* [問題]テキストビュー
			//*----------------------------------------------------------------------------*
			// 問題をテキストビューに設定する
			TextView questionTextView =
				(TextView)listRowView.findViewById(R.id.text_list_row_question);
			String questionStr =
				StringUtils.replaceNewLine(answerDto.getJoin().getQuestionDto().getQuestion());
			questionTextView.setText(questionStr);
			//*----------------------------------------------------------------------------*
			//* [解答値]テキストビュー
			//*----------------------------------------------------------------------------*
			StringBuilder answerBuilder = new StringBuilder(); // 解答値
			String answer = answerDto.getAnswer();
			// 解答値が未入力である場合は【-】を設定する
			if (StringUtils.isEmpty(answer)) {
				answer = "-";
			}
			answerBuilder.append("[").append(answer).append("]");
			// 解答値をテキストビューに設定する
			TextView answerTextView =
				(TextView)listRowView.findViewById(R.id.text_list_row_answer);
			answerTextView.setText(answerBuilder.toString());
			//*----------------------------------------------------------------------------*
			//* [解答結果]イメージビュー
			//*----------------------------------------------------------------------------*
			// 解答結果をイメージビューに設定する
			ImageView answerResultImageView =
				(ImageView)listRowView.findViewById(R.id.image_list_row_result);
			// 解答結果が正解である場合
			if (answerDto.isCorrect()) {
				// イメージビューに画像を設定する：[正解]
				answerResultImageView.setImageResource(R.drawable.correct);
			}
			// 解答結果が正解ではない場合
			else {
				// イメージビューに画像を設定する：[不正解]
				answerResultImageView.setImageResource(R.drawable.incorrect);
			}

			// 処理終了
			return listRowView;
		}
	}
}