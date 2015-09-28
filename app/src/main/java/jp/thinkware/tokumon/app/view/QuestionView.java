package jp.thinkware.tokumon.app.view;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.dto.QuestionDto;
import jp.thinkware.tokumon.app.helper.thread.ExamTimeThreadHelper;

/**
 * 問題画面のビュークラスです。<br>
 * - MVCモデルのView層の処理を行います。
 * @author thinkware
 */
public class QuestionView {

// field

	/** 問題画面のアクティビティ */
	private Activity activity = null;

	public TextView txtHeadTitle;
	public TextView txtHeadTime;
	public TextView txtHeadNum;
	public TextView txtQuestion;

	/** [選択肢1]チェックボックス */
	public CheckBox ch01;
	/** [選択肢2]チェックボックス */
	public CheckBox ch02;
	/** [選択肢3]チェックボックス */
	public CheckBox ch03;
	/** [選択肢4]チェックボックス */
	public CheckBox ch04;

// method

	/**
	 * コンストラクタ
	 * @param obj 問題画面のアクティビティ
	 */
	public QuestionView(Object obj) {
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
		//* 画面部品を設定する：[メイン画面]
		//******************************************************************************************
		this.activity.setContentView(R.layout.question_main);

		this.txtHeadTitle = (TextView)this.activity.findViewById(R.id.txtTitle);   // コース名テキスト
		this.txtHeadTime = (TextView)this.activity.findViewById(R.id.txtTime);     // 経過時間テキスト
		this.txtHeadNum = (TextView)this.activity.findViewById(R.id.txtNum);       // 設問数テキスト
		this.txtQuestion = (TextView)this.activity.findViewById(R.id.txtQuestion); // 設問テキスト

		//  選択肢チェックボックス
		this.ch01 = (CheckBox)this.activity.findViewById(R.id.checkBox1);
		this.ch02 = (CheckBox)this.activity.findViewById(R.id.checkBox2);
		this.ch03 = (CheckBox)this.activity.findViewById(R.id.checkBox3);
		this.ch04 = (CheckBox)this.activity.findViewById(R.id.checkBox4);
	}

	/**
	 * 問題情報を画面コンポーネントに反映します。
	 * @param questionDto 問題Dto
	 */
	public void setQuestionData(QuestionDto questionDto) {
		//******************************************************************************************
		//* 解答情報を画面コンポーネントに反映する
		//******************************************************************************************
		// 解答情報が指定されていない場合は終了する
		if (questionDto == null) {
			// 処理終了
			return;
		}
		// 問題テキストビュー
		this.txtQuestion.setText(StringUtils.replaceNewLine(questionDto.getQuestion()));
	}

	/**
	 * 問題数等の情報を画面コンポーネントに反映します。
	 * @param now 現在の設問番号
	 * @param total 全設問数
	 */
	public void setQuestionStateData(long now, long total) {
		//******************************************************************************************
		//* 問題情報を画面コンポーネントに反映する
		//******************************************************************************************
		// コース名
		txtHeadTitle.setText(this.activity.getResources().getString(R.string.course_name));
		// 設問番号 / 総問題数
		txtHeadNum.setText("問題 " + String.valueOf(now) + "問 / " + String.valueOf(total) + "問");
		/*** 経過時間 ***/
		// 経過時間を表示用のフォーマットに変換する
		Long elapsedTime = ExamTimeThreadHelper.getInstance().getElapsedTimeMill(); // 経過時間
		Date elapsedTimeDate = new Date(elapsedTime);
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss", Locale.ENGLISH);
		String formatErapsedTimeStr = sdf.format(elapsedTimeDate); // 受験日時
		// 経過時間を画面に反映する
		txtHeadTime.setText("時間 " + formatErapsedTimeStr);
	}

	/**
	 * 選択肢情報を画面コンポーネントに反映します。
	 * @param choicesDtoArray 選択肢Dto配列
	 * @param answerDto 解答情報Dto
	 */
	public void setAnswersData(ChoicesDto[] choicesDtoArray, AnswerDto answerDto) {
		//******************************************************************************************
		//* 選択肢情報を画面コンポーネントに反映する
		//******************************************************************************************
		List<CheckBox> checkBoxList = new ArrayList<CheckBox>(); // 選択肢チェックボックスリスト
		// 選択肢チェックボックスをリストに追加する
		checkBoxList.add(this.ch01); // 選択肢1
		checkBoxList.add(this.ch02); // 選択肢2
		checkBoxList.add(this.ch03); // 選択肢3
		checkBoxList.add(this.ch04); // 選択肢4
		//*------------------------------------------------------------------------------------*
		//* 選択肢情報を設定する
		//*------------------------------------------------------------------------------------*
		// 選択肢チェックボックスの件数分ループする
		for (int i = 0; i < checkBoxList.size(); i++) {
			// インデックスが選択肢Dtoの件数以上に達した場合
			if (i >= choicesDtoArray.length) {
				// ループ終了
				break;
			}
			CheckBox checkBox = checkBoxList.get(i); // 選択肢チェックボックス
			// 選択肢の内容を設定する
			checkBox.setText(StringUtils.replaceNewLine(choicesDtoArray[i].getContent()));
			/*** 選択肢の選択状態を設定する ***/
			// 選択肢が解答として選択されている場合
			if (answerDto.isSelected(choicesDtoArray[i].getChoicesId())) {
				// チェック状態を設定する：[チェックあり]
				checkBox.setChecked(true);
			}
			// 選択肢が解答として選択されていない場合
			else {
				// チェック状態を設定する：[チェックなし]
				checkBox.setChecked(false);
			}
		}
	}

	/**
	 * どのチェックボックスがチェックされているかを取得
	 * @return チェックボックス番号
	 */
	public ArrayList<Integer> getCheckedNumbers() {
		ArrayList<Integer> checkedNumbers = new ArrayList<Integer>();
		if (ch01.isChecked()) {
			checkedNumbers.add(1);
		}
		if (ch02.isChecked()) {
			checkedNumbers.add(2);
		}
		if (ch03.isChecked()) {
			checkedNumbers.add(3);
		}
		if (ch04.isChecked()) {
			checkedNumbers.add(4);
		}
		return checkedNumbers;
	}
}