package jp.thinkware.tokumon.app.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.R;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.model.QuestionModel;
import jp.thinkware.tokumon.app.view.QuestionView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;


/**
 * 問題画面のアクティビティクラスです。<br>
 * - MVCモデルのControl層の処理を行います。
 * @author thinkware
 */
public class QuestionActivity extends KaidenBaseActivity implements OnClickListener {
// field
	/** 問題画面ビュー */
	private QuestionView view;
	/** 問題情報モデル */
	private QuestionModel model;

	/** 成績ID */
	private long recordId;
	/** ユーザID */
	private long userId;

	/** 解答用紙情報 */
	private AnswerSheetDto answerSheetDto = null;
	/** 解答情報マップ(KEY:[設問番号]) */
	private Map<Long, AnswerDto> answerInfoMap = null;

	/** モーション制御オブジェクト */
	private GestureDetector mGestureDetector = null;
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;

// method

	/**
	 * 画面クリック時のイベントメソッドです。
	 * @param view ビューオブジェクト
	 */
	@Override
	public void onClick(View view) {
	}

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
		// 画面レイアウトを設定する
		this.setContentView(R.layout.question_main);
		// モーション制御処理を初期化する
		this.mGestureDetector = new GestureDetector(this, this.mOnGestureListener); // モーション制御オブジェクト
		//*------------------------------------------------------------------------------------*
		//* 初期処理を実行する
		//*------------------------------------------------------------------------------------*
		// モデル、ビュークラスを生成する
		this.view  = new QuestionView(this);  // ビュークラス
		this.model = new QuestionModel(this); // モデルクラス
		//*------------------------------------------------------------------------------------*
		//* インテントに保存されたデータを取得する(ユーザID、レコードID)
		//*------------------------------------------------------------------------------------*
		Intent intent = this.getIntent();
		this.userId   = intent.getLongExtra(AnswerSheetDto.COLUMN_USER_ID, 1); // ユーザID
		this.recordId = intent.getLongExtra(AnswerSheetDto.COLUMN_RECORD_ID, 1); // レコードID
		//*------------------------------------------------------------------------------------*
		//* 設問情報を取得する
		//*------------------------------------------------------------------------------------*
		/***** 現在の設問をDBから取得する *****/
		// 抽出条件を生成する
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(AnswerSheetDto.COLUMN_USER_ID, this.userId);     // ユーザID
		conditionMap.put(AnswerSheetDto.COLUMN_RECORD_ID, this.recordId); // レコードID
		// DBからレコードを抽出する
		this.answerSheetDto = this.model.selectWithJoin(conditionMap);
		// 解答情報マップを生成する
		this.createAnswerInfoMap();
		//*------------------------------------------------------------------------------------*
		//* 問題を画面に表示する
		//*------------------------------------------------------------------------------------*
		this.newQuestionView(this.answerSheetDto.getCurrentQuestion());
	}

	/**
	 * 現在の設問画面を表示します。
	 * @param questionNo 設問番号
	 */
	public void newQuestionView(Long questionNo) {
		// 現在の設問番号を設定する
		this.answerSheetDto.setCurrentQuestion(questionNo);
		// ヘッダーに反映する
		this.view.setQuestionStateData(questionNo, this.answerSheetDto.getQuestionCount());
		// 問題情報をマップから取得する
		AnswerDto currentAnswerDto = this.answerInfoMap.get(questionNo);
		// 問題情報を画面に反映する
		this.view.setQuestionData(currentAnswerDto.getJoin().getQuestionDto());
		// 選択肢情報を画面に反映する
		this.view.setAnswersData(this.createChoicesInfoArray(), currentAnswerDto);
	}

	/**
	 * 画面タッチ時のイベントメソッドです。
	 * @see android.app.Activity#onTouchEvent(MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// モーション制御に処理を委譲する
		return this.mGestureDetector.onTouchEvent(event);
	}

	private final SimpleOnGestureListener mOnGestureListener = new SimpleOnGestureListener() {
		@Override
		public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

			Long currentQuestionNo =
				QuestionActivity.this.answerSheetDto.getCurrentQuestion(); // 現在の設問番号
			Long totalCount = QuestionActivity.this.answerSheetDto.getQuestionCount(); // 全設問数

			try {
				if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
					// 縦の移動距離が大きすぎる場合は無視
					return false;
				}
				if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					// 開始位置から終了位置の移動距離が指定値より大きい X軸の移動速度が指定値より大きい
					currentQuestionNo++;
					//設問IDが0を下回らないように対応
					if (currentQuestionNo > totalCount) {
						//次の問題へ移動せずに、終了画面へ移動するMSG
						endQuestionAlert();
						return false;
					}
					//*------------------------------------------------------------------------*
					//* 解答情報を更新する
					//*------------------------------------------------------------------------*
					ArrayList<Integer> selectChoicesNoList =
						QuestionActivity.this.view.getCheckedNumbers(); // 選択肢番号リスト(選択値)
					// 解答情報を更新する
					QuestionActivity.this.updateAnswerInfo(selectChoicesNoList);
					//*------------------------------------------------------------------------*
					//* 問題を画面に表示する
					//*------------------------------------------------------------------------*
					QuestionActivity.this.newQuestionView(currentQuestionNo);
				} else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					// 終了位置から開始位置の移動距離が指定値より大きい X軸の移動速度が指定値より大きい
					currentQuestionNo--;
					//設問IDが0を下回らないように対応
					if (currentQuestionNo <= 0){
						currentQuestionNo++;
						return false;
					}
					//*------------------------------------------------------------------------*
					//* 解答情報を更新する
					//*------------------------------------------------------------------------*
					ArrayList<Integer> selectChoicesNoList =
						QuestionActivity.this.view.getCheckedNumbers(); // 選択肢番号リスト(選択値)
					// 解答情報を更新する
					QuestionActivity.this.updateAnswerInfo(selectChoicesNoList);
					//*------------------------------------------------------------------------*
					//* 問題を画面に表示する
					//*------------------------------------------------------------------------*
					QuestionActivity.this.newQuestionView(currentQuestionNo);
				}
			} catch (Exception e) {
				// nothing
			}
			return false;
		}
	};

	/**
	 * 解答ボタン押下時の処理を行います。
	 * @param v ビューオブジェクト
	 * @return なし
	 */
	public void btnAnswer_click(View v) {
		//******************************************************************************************
		//* [解答]ボタン押下時の処理を行う
		//******************************************************************************************
		//*------------------------------------------------------------------------------------*
		//* 解答状態を判定する
		//*------------------------------------------------------------------------------------*
		//チェックボックスのチェックありを取得
		List<Integer> selectChoicesNoList = this.view.getCheckedNumbers();
		//チェックされているか判定
		if (selectChoicesNoList.isEmpty()) {
			/* 警告ダイアログを表示する：[未解答] */
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setMessage("解答が選択されていません。"); // メッセージ
			alert.setPositiveButton(R.string.label_confirm_dialog_ok, null); // 肯定ボタン
			// ダイアログを表示
			alert.create().show();
			// 処理終了
			return;
		}
		//*------------------------------------------------------------------------------------*
		//* 解答情報を更新する
		//*------------------------------------------------------------------------------------*
		this.updateAnswerInfo(selectChoicesNoList);
		//*------------------------------------------------------------------------------------*
		//* 解答ポップアップ画面に遷移する
		//*------------------------------------------------------------------------------------*
		Intent intent =
			new Intent(this.getApplicationContext(), AnswerPopupActivity.class);
		intent.putExtra(AnswerDto.COLUMN_RECORD_ID, this.recordId); // レコードID
		intent.putExtra(AnswerDto.COLUMN_QUESTION_ID, this.currentQuestionId()); // 設問ID
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		this.startActivityForResult(intent, R.layout.answer_popup_main);

		// 処理終了
		return;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自動生成されたメソッド・スタブ
		super.onActivityResult(requestCode, resultCode, data);

		Long currentQuestionNo = this.answerSheetDto.getCurrentQuestion(); // 現在の設問番号
		Long totalCount = this.answerSheetDto.getQuestionCount(); // 全設問数
		switch(requestCode) {
		case R.layout.answer_popup_main:
			//解答ポップアップ画面から戻った場合
			currentQuestionNo++;
			//設問IDが0を下回らないように対応
			if (currentQuestionNo > totalCount) {
				currentQuestionNo--;
			}
			//*------------------------------------------------------------------------*
			//* 次の問題を画面に表示する
			//*------------------------------------------------------------------------*
			this.newQuestionView(currentQuestionNo);
			break;
		case R.layout.question_popup_main:
			//問題一覧ポップアップ画面から戻った場合

			// 設問IDを取得
			currentQuestionNo = data.getExtras().getLong("question_id");
			this.answerSheetDto.setCurrentQuestion(currentQuestionNo);
			//*------------------------------------------------------------------------*
			//* 指定の問題を画面に表示する
			//*------------------------------------------------------------------------*
			this.newQuestionView(currentQuestionNo);
			break;
		}

	}

	/**
	 * ソース・図ボタン押下イベント
	 * @param v
	 */
	public void btnSource_click(View v){

	}

	/**
	 * 問題一覧ボタン押下イベント
	 * @param v
	 */
	public void btnList_click(View v){
		// 問題一覧ポップアップ画面に遷移する
		Intent intent =
			new Intent(this.getApplicationContext(), QuestionPopupActivity.class);
		intent.putExtra(AnswerDto.COLUMN_RECORD_ID, this.recordId);  // レコードID
		intent.putExtra(AnswerDto.COLUMN_QUESTION_ID, this.currentQuestionId()); // 設問ID
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		this.startActivityForResult(intent, R.layout.question_popup_main);
	}

	/**
	 * 中断ボタン押下イベント
	 * @param v
	 */
	public void btnStop_click(View v){
		//******************************************************************************************
		//* 中断メッセージダイアログを表示する
		//* - [OK]ボタン押下時、終了画面に遷移する。
		//******************************************************************************************
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("中断");
		alert.setMessage("問題を中断します。よろしいですか？");
		//*------------------------------------------------------------------------------------*
		//* ダイアログボタンにイベントリスナーを設定する
		//*------------------------------------------------------------------------------------*
		// 肯定ボタンのイベントリスナーを設定する
		alert.setPositiveButton(
			R.string.label_confirm_dialog_yes,
			new DialogInterface.OnClickListener() {
				/**
				 * 肯定ボタン押下時のイベントハンドラです。
				 * @see DialogInterface.OnClickListener#onClick(DialogInterface, int)
				 */
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					//*------------------------------------------------------------------------*
					//* 解答情報を更新する
					//*------------------------------------------------------------------------*
					ArrayList<Integer> selectChoicesNoList =
						QuestionActivity.this.view.getCheckedNumbers(); // 選択肢番号リスト(選択値)
					// 解答情報を更新する
					QuestionActivity.this.updateAnswerInfo(selectChoicesNoList);
					//*------------------------------------------------------------------------*
					//* 終了画面に遷移する
					//*------------------------------------------------------------------------*
					Intent intent =
						new Intent(
							QuestionActivity.this.getApplicationContext(), AnswerEndActivity.class);
					intent.putExtra(AnswerSheetDto.COLUMN_RECORD_ID, recordId); // レコードID
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					QuestionActivity.this.startActivityForResult(intent, R.layout.answer_end_main);

					// 処理終了
					return;
				}
			});
		// 否定ボタンのイベントリスナーを設定する
		alert.setNegativeButton(R.string.label_confirm_dialog_no, null);
		// ダイアログを表示する
		alert.show();

		// 処理終了
		return;
	}

// private method

	/**
	 * 現在の設問IDを取得します。
	 * @return 現在の設問ID
	 */
	private Long currentQuestionId() {
		//******************************************************************************************
		//* 現在の設問IDを取得する
		//******************************************************************************************
		// 現在の設問情報を取得する
		AnswerDto currentAnswerDto = this.answerInfoMap.get(this.answerSheetDto.getCurrentQuestion());
		// 処理終了
		return currentAnswerDto.getQuestionId();
	}

	/**
	 * 設問番号から解答情報を取得するマップを生成します。
	 */
	private void createAnswerInfoMap() {
		//******************************************************************************************
		//* 解答情報マップを生成する（KEY：[設問番号]）
		//******************************************************************************************
		this.answerInfoMap = new HashMap<Long, AnswerDto>(); // 解答情報マップ
		// 解答情報の件数分ループする
		for (AnswerDto dto : this.answerSheetDto.getJoin().getAnswerDtoList()) {
			// 設問番号をキーにして解答情報をマップに登録する
			this.answerInfoMap.put(dto.getQuestionNo(), dto);
		}
	}

	/**
	 * 現在設問の選択肢情報配列を生成します。
	 * @return 選択肢情報配列
	 */
	private ChoicesDto[] createChoicesInfoArray() {
		//******************************************************************************************
		//* 現在設問の選択肢情報配列を生成する
		//******************************************************************************************
		List<ChoicesDto> choicesDtoList = new ArrayList<ChoicesDto>(); // 選択肢情報リスト
		// 現在の設問情報を取得する
		AnswerDto currentAnswerDto =
			this.answerInfoMap.get(this.answerSheetDto.getCurrentQuestion());
		// ソート済の選択肢リストを取得する
		choicesDtoList = currentAnswerDto.getSortedChoicesList();

		// 処理終了
		return (ChoicesDto[])choicesDtoList.toArray(new ChoicesDto[0]);
	}

	/**
	 * 解答値を生成します。<br>
	 * - 解答が複数選択された場合、区切り文字で連結した文字列を生成します。
	 * @param choicesNoList 選択肢番号リスト
	 * @return 解答値
	 */
	private String createAnswer(List<Integer> choicesNoList) {
		//******************************************************************************************
		//* 解答値を生成する
		//******************************************************************************************
		StringBuilder answerBuilder = new StringBuilder(); // 解答値文字列
		// 選択肢番号リストが指定されていない場合は終了する
		if (choicesNoList == null) return answerBuilder.toString();
		// 解答値の件数分ループする
		for (Integer choicesNo : choicesNoList) {
			// 解答値文字列に値が設定されている場合
			if (answerBuilder.length() > 0) {
				// 区切り文字を連結する
				answerBuilder.append(",");
			}
			// 選択肢番号を文字列に連結する
			answerBuilder.append(choicesNo);
		}
		// 処理終了
		return answerBuilder.toString();
	}

	/**
	 * 解答情報を更新します。
	 * @param selectChoicesNoList 選択肢番号リスト
	 */
	private void updateAnswerInfo(List<Integer> selectChoicesNoList) {
		//******************************************************************************************
		//* 解答情報を更新する
		//******************************************************************************************
		//*------------------------------------------------------------------------------------*
		//* 解答情報
		//*------------------------------------------------------------------------------------*
		AnswerDto currentAnswerDto =
			this.answerInfoMap.get(this.answerSheetDto.getCurrentQuestion()); // 現在の解答情報
		// 解答情報を設定する
		currentAnswerDto.setAnswer(this.createAnswer(selectChoicesNoList)); // 解答値
		// 解答情報をテーブルに登録する
		this.model.registAnswer(currentAnswerDto);
		//*------------------------------------------------------------------------------------*
		//* 解答用紙
		//*------------------------------------------------------------------------------------*
		// 正解数、解答数を算出する
		this.answerSheetDto.calcCorrectCount(); // 正解数
		this.answerSheetDto.calcAnswerCount();  // 解答数
		// 解答用紙情報をテーブルに登録する
		this.model.updateAnswerSheet(this.answerSheetDto);
	}
	/**
	 * アラート
	 * 最後の問題で、次画面へフリックされたときのメッセージ表示
	 */
	public void endQuestionAlert(){
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("終了");
		alert.setMessage("終了してもよろしいですか？");
		alert.setPositiveButton(R.string.label_confirm_dialog_yes,
			new DialogInterface.OnClickListener() {
				/**
				 * 肯定ボタン押下時のイベントハンドラです。
				 * @see DialogInterface.OnClickListener#onClick(DialogInterface, int)
				 */
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					//*------------------------------------------------------------------------*
					//* 解答情報を更新する
					//*------------------------------------------------------------------------*
					ArrayList<Integer> selectChoicesNoList =
						QuestionActivity.this.view.getCheckedNumbers(); // 選択肢番号リスト(選択値)
					// 解答情報を更新する
					QuestionActivity.this.updateAnswerInfo(selectChoicesNoList);
					//*------------------------------------------------------------------------*
					//* 終了画面に遷移する
					//*------------------------------------------------------------------------*
					Intent intent =
						new Intent(
							QuestionActivity.this.getApplicationContext(), AnswerEndActivity.class);
					intent.putExtra(AnswerSheetDto.COLUMN_RECORD_ID, recordId); // レコードID
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					QuestionActivity.this.startActivityForResult(intent, R.layout.answer_end_main);
				}
			});
		// 否定ボタンのイベントリスナーを設定する
		alert.setNegativeButton(R.string.label_confirm_dialog_no,
			new DialogInterface.OnClickListener() {
				/**
				 * 否定ボタン押下時のイベントハンドラです。
				 * @see DialogInterface.OnClickListener#onClick(DialogInterface, int)
				 */
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
				}
			});
		// ダイアログを表示
		alert.create().show();
	}
}
