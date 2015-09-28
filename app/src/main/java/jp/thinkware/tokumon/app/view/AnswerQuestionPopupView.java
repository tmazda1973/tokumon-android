package jp.thinkware.tokumon.app.view;

import java.util.List;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.common.util.UIContentsUtils;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.view.listener.CustomOnTouchListener;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * 結果表示画面のビュークラスです。<br>
 * - MVCモデルのView層の処理を行います。
 * @author thinkware
 */
public class AnswerQuestionPopupView implements OnClickListener {

// field

	/** 結果表示画面のアクティビティ */
	private Activity activity = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerQuestionPopupView(Object obj) {
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
		this.activity.setContentView(R.layout.answer_question_popup_main); // レイアウト
		// メイン画面レイアウトビューにonClickリスナーを設定する
		View mainLayoutView = this.activity.findViewById(R.id.answer_qustion_popup_frame);
		mainLayoutView.setOnClickListener(this);
		//*------------------------------------------------------------------------------------*
		//* [選択肢一覧]リスト
		//*------------------------------------------------------------------------------------*
		ListView choiceListView =
			(ListView)this.activity.findViewById(R.id.list_answer_question_choices);
		choiceListView.setOnTouchListener(new CustomOnTouchListener(this.activity));
		// アニメーションコントローラを取得する：[カスケード表示]
		choiceListView.setLayoutAnimation(UIContentsUtils.getCascadeAnimation());
		//*------------------------------------------------------------------------------------*
		//* [問題内容]スクロール
		//*------------------------------------------------------------------------------------*
		// 問題内容スクロールビューにonTouchリスナーを登録する
		ScrollView contentScrollView =
			(ScrollView)this.activity.findViewById(R.id.scroll_answer_question);
		contentScrollView.setOnTouchListener(new CustomOnTouchListener(this.activity));
//		// アニメーションコントローラを取得する：[カスケード表示]
//		contentScrollView.setLayoutAnimation(UIContentsUtils.getCascadeAnimation());
	}

	/**
	 * クリックイベント発生時の処理を実行します。
	 * @param v ビューオブジェクト
	 * @see android.view.View.OnClickListener#onClick(View)
	 */
	@Override
	public void onClick(View v) {
		// アクティビティを終了する
		this.activity.finish();
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
		//*------------------------------------------------------------------------------------*
		//* [総問題数]テキストビュー
		//*------------------------------------------------------------------------------------*
		TextView totalCountTextView =
			(TextView)this.activity.findViewById(R.id.text_total_question_count);
		Long totalCount = answerSheetDto.getQuestionCount(); // 設問数
		// テキストビューに設定する：[総問題数]
		totalCountTextView.setText(String.valueOf(totalCount));
	}

	/**
	 * 解答情報を画面コンポーネントに反映します。
	 * @param answerDto 解答DTO
	 */
	public void setAnswerData(AnswerDto answerDto) {
		//******************************************************************************************
		//* 解答情報を画面コンポーネントに反映する
		//******************************************************************************************
		// 解答情報が指定されていない場合は終了する
		if (answerDto == null) {
			// 処理終了
			return;
		}
		//*------------------------------------------------------------------------------------*
		//* [問題番号]テキストビュー
		//*------------------------------------------------------------------------------------*
		TextView questionNoTextView =
			(TextView)this.activity.findViewById(R.id.text_answer_question_no);
		Long questionNo = answerDto.getQuestionNo(); // 問題番号
		// テキストビューに設定する：[問題番号]
		questionNoTextView.setText(String.valueOf(questionNo));
		//*------------------------------------------------------------------------------------*
		//* [問題内容]テキストビュー
		//*------------------------------------------------------------------------------------*
		TextView questionTextView =
			(TextView)this.activity.findViewById(R.id.text_answer_question);
		String questionContent = answerDto.getJoin().getQuestionDto().getQuestion(); // 問題内容
		// テキストビューに設定する：[問題内容]
		questionTextView.setText(StringUtils.replaceNewLine(questionContent));
		//*------------------------------------------------------------------------------------*
		//* [選択肢一覧]リストビュー
		//*------------------------------------------------------------------------------------*
		ListView listView = (ListView)this.activity.findViewById(R.id.list_answer_question_choices);
		AnswerChoicesAdapter adapter = // アダプタークラス：[選択肢一覧]
			new AnswerChoicesAdapter(
				this.activity.getApplicationContext(),
				answerDto.getSortedChoicesList());
		// 選択肢一覧に表示するデータを設定する
		adapter.setAnswerDto(answerDto); // 解答DTO
		// リストビューにアダプタークラスを設定する
		listView.setAdapter(adapter);
	}

//**************************************************************************************************
//* 内部クラス
//**************************************************************************************************

	/**
	 * 選択肢一覧の独自実装アダプタークラスです。
	 * @author thinkware
	 * @see android.widget.BaseAdapter
	 */
	private class AnswerChoicesAdapter extends ArrayAdapter<ChoicesDto> {

///// field

		/** 解答DTO */
		private AnswerDto answerDto = new AnswerDto();

///// accessor

		/**
		 * 解答DTOを設定します。
		 * @param answerDto 解答DTO
		 */
		public void setAnswerDto(AnswerDto answerDto) {
			this.answerDto = answerDto;
		}

///// method

		/**
		 * コンストラクタ
		 * @param context コンテキストオブジェクト
		 * @param objects 一覧データ
		 */
		public AnswerChoicesAdapter(Context context, List<ChoicesDto> objects) {
			super(context, 0, objects);
		}

		/**
		 * 項目が選択できるかを判定します。
		 * @param position 項目位置
		 * @return true 選択できる, false 選択できない
		 * @see ArrayAdapter#isEnabled(int)
		 */
		@Override
		public boolean isEnabled(int position) {
			// 項目を選択不可にする
			return false;
		}

		/**
		 * 項目行のビューオブジェクトを取得します。
		 * @see android.widget.BaseAdapter#getView(int, View, ViewGroup)
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
				listRowView = inflater.inflate(R.layout.answer_choices_list_row, null);
			}
			// 項目行の画面コンポーネントに選択肢情報を反映する
			this.setChoiceInfo(position, listRowView);

			// 処理終了
			return listRowView;
		}

		/**
		 * 選択肢情報を画面コンポーネントに反映します。
		 * @param position 現在行のインデックス
		 * @param listRowView 現在行のビュー
		 * @return boolean true 設定あり, false 設定なし
		 */
		private boolean setChoiceInfo(int position, View listRowView) {
			//**************************************************************************************
			//* 選択肢情報を画面コンポーネントに反映する
			//**************************************************************************************
			// 現在行の選択肢情報を取得する
			ChoicesDto choicesDto = this.getItem(position);
			// 選択肢情報が存在しない場合
			if (choicesDto == null) return false;
			//*--------------------------------------------------------------------------------*
			//* [選択]イメージビュー
			//*--------------------------------------------------------------------------------*
			// 解答結果をイメージビューに設定する
			ImageView selectedImageView =
				(ImageView)listRowView.findViewById(R.id.image_list_row_choices_checked);
			// 解答として選択された選択肢である場合
			if (this.answerDto.isSelected(choicesDto.getChoicesId())) {
				selectedImageView.setImageResource(R.drawable.checkbox_checked);
			}
			// 解答として選択されていない選択肢である場合
			else {
				selectedImageView.setImageResource(R.drawable.checkbox_unchecked);
			}
			//*--------------------------------------------------------------------------------*
			//* [選択肢ID]テキストビュー
			//*--------------------------------------------------------------------------------*
			String choiceId = "(" + String.valueOf(position + 1) + ")";
			// 選択肢IDをテキストビューに設定する
			TextView questionNoTextView =
				(TextView)listRowView.findViewById(R.id.text_list_row_choices_no);
			questionNoTextView.setText(choiceId);
			//*--------------------------------------------------------------------------------*
			//* [選択肢内容]テキストビュー
			//*--------------------------------------------------------------------------------*
			// 選択肢内容をテキストビューに設定する
			TextView contentTextView =
				(TextView)listRowView.findViewById(R.id.text_list_row_choices_content);
			contentTextView.setText(StringUtils.replaceNewLine(choicesDto.getContent()));
			//*--------------------------------------------------------------------------------*
			//* [正解]イメージビュー
			//*--------------------------------------------------------------------------------*
			// 解答結果をイメージビューに設定する
			ImageView correctImageView =
				(ImageView)listRowView.findViewById(R.id.image_list_row_choices_correct);
			// 正解の選択肢である場合
			if (choicesDto.getCorrectFlag().equals(ChoicesDto.CORRECT_FLAG_TRUE)) {
				// 正解画像を表示する
				correctImageView.setImageResource(R.drawable.correct);
			}
			// 正解の選択肢ではない場合
			else {
				// 正解画像を表示しない
				correctImageView.setImageDrawable(null);
			}
			// 処理終了
			return true;
		}
	}
}