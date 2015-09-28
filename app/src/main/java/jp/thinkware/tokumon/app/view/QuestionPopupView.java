package jp.thinkware.tokumon.app.view;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.activities.QuestionPopupActivity.QuestionList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 問題一覧ポップアップ画面のビュークラスです。<br>
 * - MVCモデルのView層の処理を行います。
 * @author thinkware
 */
public class QuestionPopupView {

// field

	/** 問題一覧ポップアップ画面のアクティビティ */
	private Activity activity = null;

	public TextView txtHeadTitle;
	public TextView txtHeadTime;
	public TextView txtHeadNum;
	public ListView listQuesition;


// method

	/**
	 * コンストラクタ
	 * @param obj 問題一覧ポップアップ画面のアクティビティ
	 */
	public QuestionPopupView(Object obj) {
		// アクティビティを設定する
		this.activity = (Activity)obj;
		// 画面部品を設定する
		this.setContentView();
	}
	/**
	 * 画面部品を設定します。
	 */
	public void setContentView() {
		//**********************************************************************
		//* 画面部品を設定する：[メイン画面]
		//**********************************************************************
		this.activity.setContentView(R.layout.question_popup_main);

		txtHeadTitle = (TextView)this.activity.findViewById(R.id.txtTitle);
		txtHeadTime = (TextView)this.activity.findViewById(R.id.txtTime);
		txtHeadNum = (TextView)this.activity.findViewById(R.id.txtNum);
		listQuesition = (ListView)this.activity.findViewById(R.id.listQuestionPopup);
	}

	/**
	 * 問題一覧ポップアップ情報を画面コンポーネントに反映します。
	 * @param adapter 質問内容
	 */
	public void setListData(ArrayAdapter<QuestionList> adapter) {
		//******************************************************************************
		//* 問題一覧情報を画面コンポーネントに反映する
		//******************************************************************************
		// 質問内容が指定されていない場合は終了する
		if (adapter == null) {
			// 処理終了
			return;
		}
		//*------------------------------------------------------------------------*
		//* 問題テキストビュー
		//*------------------------------------------------------------------------*
		// 質問内容をテキストビューに設定する
		listQuesition.setAdapter(adapter);

		listQuesition.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 返すデータ(Intent&Bundle)の作成
				Intent in = new Intent();
				Bundle bundle = new Bundle();
				//取得した設問IDをセットする
				int qid = position + 1;
				bundle.putLong("question_id", Long.valueOf(qid));
				in.putExtras(bundle);

				// setResult() で bundle を載せた 送るIntent dataをセットする
				// 第一引数は…Activity.RESULT_OK, Activity.RESULT_CANCELED など
				activity.setResult(1, in);
				//問題一覧ポップアップ画面を終了する
				activity.finish();
			}

		});
	}

	/**
	 * 問題数等の情報を画面コンポーネントに反映します。
	 */
	public void setQuestionStateData() {
		txtHeadTitle.setText(this.activity.getResources().getString(R.string.course_name));
		txtHeadNum.setText("");
		txtHeadTime.setText("");
	}
}
