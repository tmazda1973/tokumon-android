package jp.thinkware.tokumon.app.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.model.QuestionPopupModel;
import jp.thinkware.tokumon.app.view.QuestionPopupView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * 問題ポップアップ画面のアクティビティクラスです。<br />
 * - MVCモデルのControl層の処理を行います。
 * @author thinkware
 * @version 1.0
 */
public class QuestionPopupActivity extends KaidenBaseActivity implements OnClickListener {

// field

	/** 問題一覧ポップアップ画面ビュー */
	private QuestionPopupView view;
	/** 問題一覧ポップアップ情報モデル */
	private QuestionPopupModel model;

	private long record_id;		//レコードID
	private long question_id;		//設問ID
	private long question_cnt;		//設問数

// method

	/**
	 * アクティビティ生成時のイベントメソッドです。<br>
	 * - アクティビティ開始時に1度だけ呼び出されます。
	 * @see KaidenBaseActivity#onCreate(Bundle)
	 * @param savedInstanceState バンドルオブジェクト
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 親クラスのコンストラクタを実行する
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.question_popup_main);

		// 問題一覧ポップアップ画面を表示する
		this.view = new QuestionPopupView(this);
		// 問題一覧ポップアップ画面ビュー
		this.model = new QuestionPopupModel(this);

		//*------------------------------------------------------------------------*
		//* インテントに保存されたデータを取得する(設問ID、レコードID)
		//*------------------------------------------------------------------------*
		Intent intent = this.getIntent();
		question_id = intent.getLongExtra(AnswerDto.COLUMN_QUESTION_ID, 1); // 設問ID
		record_id = intent.getLongExtra(AnswerDto.COLUMN_RECORD_ID, 1); // レコードID

		this.view.setQuestionStateData();


		/***** DBから取得する *****/
		// 抽出条件を生成する
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		/***** 問題をDBから取得する *****/
		// 抽出条件を生成する
		conditionMap.put(AnswerDto.COLUMN_RECORD_ID, String.valueOf(record_id));// レコードID
		// DBからレコードを抽出する
		AnswerDto[] answerDto = this.model.selectAnswer(conditionMap);
		//リスト表示のために文字列を作成
		ArrayList<QuestionList> arraylist = new ArrayList<QuestionList>();
		for (AnswerDto ansData : answerDto) {
			QuestionList ql = new QuestionList();
			// 設問から改行文字を削除してテキストビューに設定する
			String questionStr = StringUtils.removeNewLine(ansData.getJoin().getQuestionDto().getQuestion());
			ql.setTitle(ansData.getQuestionNo() + " " + questionStr);
			String content_msg = "";
			if (!StringUtils.isEmpty(ansData.getAnswer())) {
				content_msg = "解答済み";
			} else {
				content_msg = "未解答";
			}
			ql.setContent(content_msg);
			arraylist.add(ql);
		}

		//*------------------------------------------------------------------------*
		//* 問題一覧を画面（リスト）に表示する
		//*------------------------------------------------------------------------*
		CustomAdapter adapter = new CustomAdapter(this, 0, arraylist);
		this.view.setListData(adapter);
	}

	/**
	 * 端末戻るボタン制御
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			// 返すデータ(Intent&Bundle)の作成
			Intent in = new Intent();
			Bundle bundle = new Bundle();
			//取得した設問IDをセットする
			bundle.putLong("question_id", question_id);
			in.putExtras(bundle);

			// setResult() で bundle を載せた 送るIntent dataをセットする
			// 第一引数は…Activity.RESULT_OK, Activity.RESULT_CANCELED など
			this.setResult(1, in);
			//問題一覧ポップアップ画面を終了する
			this.finish();
			return true;
		}
		return false;
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自動生成されたメソッド・スタブ
	}


	public class QuestionList {
		private String _title;
		private String _content;
		public void setTitle(String _title) {
			this._title = _title;
		}
		public String geTitle() {
			return this._title;
		}
		public void setContent(String _content) {
			this._content = _content;
		}
		public String getContent() {
			return this._content;
		}
	}


	public class CustomAdapter extends ArrayAdapter<QuestionList>{
		private LayoutInflater inflater;

		//コンストラクタ
		//特に深い意味は無い気がする・・
		public CustomAdapter(Context context, int resourceId, List<QuestionList> items) {
			super(context, resourceId, items);
			this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		//1行分の処理とにかく何をするにしてもこのgetViewというメソッドが1行操作するごとに呼ばれるので追加処理とかもここに押し込む
		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			//操作対象のViewを見る/完全に新規に作る場合はnullがわたってくる
			//それにしてもViewを引数にとっているのにgetViewとは・・・なんだか変な話だ
			QuestionList item = (QuestionList)getItem(position);
			if(convertView == null){
				//1行分layoutからViewの塊を生成
				convertView = inflater.inflate(R.layout.question_popup_textview, null);
			}
			//itemsからデータ
			//vから画面にくっついているViewを取り出して値をマッピングする
			TextView txtTitle = (TextView)convertView.findViewById(R.id.list_txt_title);
			txtTitle.setText(item.geTitle());
			TextView txtContent = (TextView)convertView.findViewById(R.id.list_txt_content);
			txtContent.setText(item.getContent());
			return convertView;
		}
	}
}
