package jp.thinkware.tokumon.app.view;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.R.id;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.common.util.UIContentsUtils;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.QuestionDto;
import jp.thinkware.tokumon.app.view.listener.CustomOnTouchListener;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * 解答ポップアップ画面のビュークラスです。<br>
 * - MVCモデルのView層の処理を行います。
 * @author thinkware
 */
public class AnswerPopupView implements OnClickListener {

///// field

	/** 解答ポップアップ画面のアクティビティ */
	private Activity activity = null;

///// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerPopupView(Object obj) {
		//******************************************************************************************
		//* インスタンス生成時の処理を行う
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
		this.activity.setContentView(R.layout.answer_popup_main); // レイアウト
		this.activity.setTitle(R.string.title_answer_popup);      // 画面タイトル
		//*------------------------------------------------------------------------------------*
		//* メイン画面レイアウト
		//*------------------------------------------------------------------------------------*
		// onClickリスナーを設定する
		View mainLayoutView = this.activity.findViewById(R.id.answer_popup_frame);
		mainLayoutView.setOnClickListener(this);
		//*------------------------------------------------------------------------------------*
		//* 解説内容スクロール
		//*------------------------------------------------------------------------------------*
		// onTouchリスナーを登録する
		ScrollView contentScrollView =
			(ScrollView)this.activity.findViewById(R.id.scroll_content);
		contentScrollView.setOnTouchListener(new CustomOnTouchListener(this.activity));
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
	 * 解答情報を画面コンポーネントに反映します。
	 * @param answerDto 解答DTO
	 * @return boolean true 反映あり, false 反映なし
	 */
	public boolean setAnswerData(AnswerDto answerDto) {
		//******************************************************************************************
		//* 解答情報を画面コンポーネントに反映する
		//******************************************************************************************
		// 解答情報が指定されていない場合は終了する
		if (answerDto == null) return false;
		//*------------------------------------------------------------------------------------*
		//* [解答]テキストビュー
		//*------------------------------------------------------------------------------------*
		TextView answerTextView = (TextView)this.activity.findViewById(id.text_answer);
		String contentStr = answerDto.createAnswerContent(); // 解答内容
		contentStr = StringUtils.replaceNewLine(contentStr);
		// 解答内容をテキストビューに設定する
		answerTextView.setText(contentStr);
		//*------------------------------------------------------------------------------------*
		//* [解答結果表示]レイアウト(正解／不正解)
		//*------------------------------------------------------------------------------------*
		this.activity.addContentView(
			this.createAnswerResultLayout(answerDto),
			new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		//*------------------------------------------------------------------------------------*
		//* [解説]テキストビュー
		//*------------------------------------------------------------------------------------*
		TextView contentTextView = (TextView)this.activity.findViewById(id.text_content);
		QuestionDto questionDto = answerDto.getJoin().getQuestionDto(); // 設問DTO
		// 設問データが存在する場合
		if (questionDto != null) {
			StringBuilder contentBuilder = new StringBuilder(); // 解説内容文字列
			String explanationStr = questionDto.getExplanation(); // 問題解説
			explanationStr = StringUtils.replaceNewLine(explanationStr);
			String correctContentStr =
				StringUtils.replaceNewLine(answerDto.createCorrectContent()); // 正解の選択肢内容文字列
			/*** 解説内容文字列を生成する ***/
			contentBuilder.append("［正解］\n");
			contentBuilder.append(correctContentStr); // 正解選択肢の内容
			contentBuilder.append("\n\n");
			contentBuilder.append(explanationStr);    // 問題解説
			// 解説内容をテキストビューに設定する
			contentTextView.setText(contentBuilder.toString());
		}
		// 処理終了
		return true;
	}

// private method

	/**
	 * 解答結果表示レイアウトを生成します。<br>
	 * - 解答結果画像を表示するレイアウトを生成します。(メイン画面レイアウトに重ねて表示するため)
	 * @param answerDto 解答データ
	 * @return 解答結果表示レイアウト
	 */
	private LinearLayout createAnswerResultLayout(AnswerDto answerDto) {
		//******************************************************************************************
		//* 解答結果表示レイアウトを生成する
		//******************************************************************************************
		//*------------------------------------------------------------------------------------*
		//* 解答結果画像ビューを生成する
		//*------------------------------------------------------------------------------------*
		ImageView answerResultImageView = new ImageView(this.activity); // 画像ビュー
		answerResultImageView.setAlpha(150); // 透明度(アルファ値)
		answerResultImageView.setScaleType(ScaleType.CENTER); // 画像表示方法
		// 解答結果が正解である場合
		if (answerDto.isCorrect()) {
			// 解答結果画像を設定する：[正解]
			answerResultImageView.setImageResource(R.drawable.correct); // 画像リソース
		}
		// 解答結果が正解ではない場合
		else {
			// 解答結果画像を設定する：[不正解]
			answerResultImageView.setImageResource(R.drawable.incorrect); // 画像リソース
		}
		//*------------------------------------------------------------------------------------*
		//* 画像ビューにレイアウト設定を設定する
		//*------------------------------------------------------------------------------------*
		LinearLayout.LayoutParams layoutParams =
			new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(0, 10, 10, 0); // 余白設定
		answerResultImageView.setLayoutParams(layoutParams);
		//*------------------------------------------------------------------------------------*
		//* 解答レイアウトに画像ビューを配置する
		//*------------------------------------------------------------------------------------*
		LinearLayout answerResultLayout = new LinearLayout(this.activity);
		answerResultLayout.setGravity(Gravity.TOP | Gravity.RIGHT); // 表示位置設定(上寄せ | 右寄せ)
		answerResultLayout.addView(answerResultImageView);
		// レイアウトアニメーションを設定する
		answerResultLayout.setLayoutAnimation(UIContentsUtils.getCascadeAnimation());

		// 処理終了
		return answerResultLayout;
	}
}