package jp.thinkware.tokumon.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.thinkware.tokumon.app.common.util.StringUtils;

/**
 * DBレコードのDTOクラスです。(解答用紙テーブル)
 * @author thinkware
 */
public class AnswerSheetDto implements Serializable {

	private static final long serialVersionUID = 1L;

///// const

	//**********************************************************************************************
	//* 定数
	//**********************************************************************************************
	/** テーブル名 */
	public static final String TABLE_NAME = "answer_sheet";

	/** カラム名：成績ID */
	public static final String COLUMN_RECORD_ID = "record_id";
	/** カラム名：ユーザID */
	public static final String COLUMN_USER_ID = "user_id";
	/** カラム名：コースコード */
	public static final String COLUMN_COURSE_ID = "course_id";
	/** カラム名：受験日時 */
	public static final String COLUMN_EXAM_DATETIME = "exam_datetime";
	/** カラム名：制限時間 */
	public static final String COLUMN_TIME_LIMIT = "time_limit";
	/** カラム名：現在の設問 */
	public static final String COLUMN_CURRENT_QUESTION = "current_question";
	/** カラム名：点数 */
	public static final String COLUMN_SCORE = "score";
	/** カラム名：設問数 */
	public static final String COLUMN_QUESTION_COUNT = "question_count";
	/** カラム名：解答数 */
	public static final String COLUMN_ANSWER_COUNT = "answer_count";
	/** カラム名：正解数 */
	public static final String COLUMN_CORRECT_COUNT = "correct_count";
	/** カラム名：状態 */
	public static final String COLUMN_STATUS = "status";

	/** 状態：未実施 */
	public static final long STATUS_STANDBY = 0;
	/** 状態：実施中 */
	public static final long STATUS_ACTIVE = 1;
	/** 状態：中断中 */
	public static final long STATUS_SUSPEND = 2;
	/** 状態：終了 */
	public static final long STATUS_END = 3;

///// field

	/** 項目値：成績ID integer */
	private Long _record_id = null;
	/** 項目値：ユーザID integer */
	private Long _user_id = null;
	/** 項目値：コースID integer */
	private Long _course_id = null;
	/** 項目値：受験日時 text */
	private String _exam_datetime = null;
	/** 項目値：制限時間 integer */
	private Long _time_limit = null;
	/** 項目値：現在の設問 integer */
	private Long _current_question = null;
	/** 項目値：点数 integer */
	private Long _score = null;
	/** 項目値：設問数 integer */
	private Long _question_count = null;
	/** 項目値：解答数 integer */
	private Long _answer_count = null;
	/** 項目値：正解数 integer */
	private Long _correct_count = null;
	/** 項目値：状態 integer */
	private Long _status = null;

	/** 結合テーブル処理内部クラスのインスタンス */
	private AnswerSheetDto.Join join = null;

///// accessor

	//*----------------------------------------------------------------------------------------*
	//* 項目値：成績ID
	//*----------------------------------------------------------------------------------------*
	/**
	 * 成績IDを取得します。
	 * @return 成績ID
	 */
	public Long getRecordId() {
		return this._record_id;
	}

	/**
	 * 成績IDを設定します。
	 * @param record_id 成績ID
	 */
	public void setRecordId(Long record_id) {
		this._record_id = record_id;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：ユーザID
	//*----------------------------------------------------------------------------------------*
	/**
	 * ユーザIDを取得します。
	 * @return ユーザID
	 */
	public Long getUserId() {
		return this._user_id;
	}

	/**
	 * ユーザIDを設定します。
	 * @param user_id ユーザID
	 */
	public void setUserId(Long user_id) {
		this._user_id = user_id;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：受験日時
	//*----------------------------------------------------------------------------------------*
	/**
	 * 受験日時を取得します。
	 * @return 受験日時
	 */
	public String getExamDatetime() {
		return this._exam_datetime;
	}

	/**
	 * 受験日時を設定します。
	 * @param exam_datetime 受験日時
	 */
	public void setExamDatetime(String exam_datetime) {
		this._exam_datetime = exam_datetime;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：コースID
	//*----------------------------------------------------------------------------------------*
	/**
	 * コースIDを取得します。
	 * @return コースコード
	 */
	public Long getCourseId() {
		return this._course_id;
	}

	/**
	 * コースIDを設定します。
	 * @param course_id コースID
	 */
	public void setCourseId(Long course_id) {
		this._course_id = course_id;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：制限時間
	//*----------------------------------------------------------------------------------------*
	/**
	 * 制限時間を取得します。
	 * @return 制限時間
	 */
	public Long getTimeLimit() {
		return this._time_limit;
	}

	/**
	 * 制限時間を設定します。
	 * @param time_limit 制限時間
	 */
	public void setTimeLimit(Long time_limit) {
		this._time_limit = time_limit;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：現在の設問
	//*----------------------------------------------------------------------------------------*
	/**
	 * 現在の設問を取得します。
	 * @return 現在の設問
	 */
	public Long getCurrentQuestion() {
		return this._current_question;
	}

	/**
	 * 現在の設問を設定します。
	 * @param current_question 現在の設問
	 */
	public void setCurrentQuestion(Long current_question) {
		this._current_question = current_question;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：点数
	//*----------------------------------------------------------------------------------------*
	/**
	 * 点数を取得します。
	 * @return 点数
	 */
	public Long getScore() {
		return this._score;
	}

	/**
	 * 点数を設定します。
	 * @param score 点数
	 */
	public void setScore(Long score) {
		this._score = score;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：設問数
	//*----------------------------------------------------------------------------------------*
	/**
	 * 設問数を取得します。
	 * @return 設問数
	 */
	public Long getQuestionCount() {
		return this._question_count;
	}

	/**
	 * 設問数を設定します。
	 * @param question_count 設問数
	 */
	public void setQuestionCount(Long question_count) {
		this._question_count = question_count;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：解答数
	//*----------------------------------------------------------------------------------------*
	/**
	 * 解答数を取得します。
	 * @return 解答数
	 */
	public Long getAnswerCount() {
		return this._answer_count;
	}

	/**
	 * 解答数を設定します。
	 * @param answer_count 解答数
	 */
	public void setAnswerCount(Long answer_count) {
		this._answer_count = answer_count;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：正解数
	//*----------------------------------------------------------------------------------------*
	/**
	 * 正解数を取得します。
	 * @return 正解数
	 */
	public Long getCorrectCount() {
		return this._correct_count;
	}

	/**
	 * 正解数を設定します。
	 * @param correct_count 正解数
	 */
	public void setCorrectCount(Long correct_count) {
		this._correct_count = correct_count;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：状態
	//*----------------------------------------------------------------------------------------*
	/**
	 * 状態を取得します。
	 * @return 状態
	 */
	public Long getStatus() {
		return _status;
	}

	/**
	 * 状態を設定します。
	 * @param status 状態
	 */
	public void setStatus(Long status) {
		this._status = status;
	}

///// method

	/**
	 * 結合テーブル処理内部クラスのインスタンスを取得します。
	 * @return 結合テーブル処理内部クラスのインスタンス
	 */
	 public AnswerSheetDto.Join getJoin() {
		// インスタンスが生成されていない場合は生成する
		if (this.join == null) {
			this.join = new AnswerSheetDto().new Join();
		}
		// 処理終了
	 	return this.join;
	 }

	/**
	 * 正解率を取得します。<br />
	 * - 【正解数】を【設問数】で除算して、正解率を算出します。
	 * @return 正解率
	 */
	public Long getCorrectPer() {
		//******************************************************************************************
		//* 正解率を算出する(正解数÷設問数)
		//******************************************************************************************
		Long correctPer = (long)0; // 正解率
		// 設問数が0以下である場合
		if (this.getQuestionCount() <= 0) {
			// 処理終了
			return correctPer;
		}
		/***** 正解率を算出する *****/
		BigDecimal bdCorrectPer = BigDecimal.valueOf(this.getCorrectCount()); // 正解率
		// 正解数を設問数で除算する(小数点第5位で四捨五入)
		bdCorrectPer =
			bdCorrectPer
				.divide(BigDecimal.valueOf(this.getQuestionCount()), 4, BigDecimal.ROUND_HALF_UP)
				.multiply(BigDecimal.valueOf(100));
		// 小数点第一位で四捨五入する
		correctPer = bdCorrectPer.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();

		// 処理終了
		return correctPer;
	}

	/**
	 * 正解数を算出します。
	 */
	public void calcCorrectCount() {
		//******************************************************************************************
		//* 正解数を算出する
		//******************************************************************************************
		long correctCount = 0; // 正解数
		// 結合テーブルが存在しない場合は終了する
		if (this.join == null) return;
		// 解答情報の件数分ループする
		for (AnswerDto answerDto : this.join.getAnswerDtoList()) {
			// 解答結果が正解である場合
			if (answerDto.isCorrect()) {
				// 正解数を加算する
				correctCount++;
			}
		}
		// 正解数を設定する
		this.setCorrectCount(correctCount);
	}

	/**
	 * 解答数を算出します。
	 */
	public void calcAnswerCount() {
		//******************************************************************************************
		//* 正解数を算出する
		//******************************************************************************************
		long answerCount = 0; // 解答数
		// 結合テーブルが存在しない場合は終了する
		if (this.join == null) return;
		// 解答情報の件数分ループする
		for (AnswerDto answerDto : this.join.getAnswerDtoList()) {
			// 解答値が設定されている場合
			if (StringUtils.isEmpty(answerDto.getAnswer())) {
				// 解答数を加算する
				answerCount++;
			}
		}
		// 解答数を設定する
		this.setAnswerCount(answerCount);
	}

//**************************************************************************************************
//* 内部クラス
//**************************************************************************************************
	/**
	 * 結合テーブルに関する処理を定義する内部クラスです。
	 * @author thinkware
	 */
	 public class Join {

///// field

		/** 結合テーブル：解答DTOリスト */
		private List<AnswerDto> answerDtoList = new ArrayList<AnswerDto>();

///// accessor

		/**
		 * 解答DTOリストを取得します。
		 * @return answerDtoList
		 */
		public List<AnswerDto> getAnswerDtoList() {
			return this.answerDtoList;
		}

		/**
		 * 解答DTOリストを設定します。
		 * @param answerDtoList
		 */
		public void setAnswerDtoList(List<AnswerDto> answerDtoList) {
			this.answerDtoList = answerDtoList;
		}
	}
}