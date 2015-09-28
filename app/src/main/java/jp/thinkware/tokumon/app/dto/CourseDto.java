package jp.thinkware.tokumon.app.dto;

import java.io.Serializable;

/**
 * DBレコードのDTOクラスです。(コース情報テーブル)
 * @author thinkware
 */
public class CourseDto implements Serializable {

	private static final long serialVersionUID = 1L;

///// const

	//**********************************************************************************************
	//* 定数
	//**********************************************************************************************
	/** テーブル名 */
	public static final String TABLE_NAME = "course";

	/** カラム名：コースID */
	public static final String COLUMN_COURSE_ID = "course_id";
	/** カラム名：コースコード */
	public static final String COLUMN_COURSE_CODE = "course_code";
	/** カラム名：コース名(US) */
	public static final String COLUMN_COURSE_NAME_US = "course_name_us";
	/** カラム名：コース名(日本語) */
	public static final String COLUMN_COURSE_NAME_JA = "course_name_ja";
	/** カラム名：概要 */
	public static final String COLUMN_SUMMARY = "summary";
	/** カラム名：説明 */
	public static final String COLUMN_DESCRIPTION = "description";
	/** カラム名：受験時間(分) */
	public static final String COLUMN_EXAM_TIME = "exam_time";
	/** カラム名：合格点 */
	public static final String COLUMN_PASSING_SCORE = "passing_score";
	/** カラム名：設問数 */
	public static final String COLUMN_QUESTION_COUNT = "question_count";
	/** カラム名：登録日時 */
	public static final String COLUMN_REGIST_DATETIME = "regist_datetime";

///// field

	/** 項目値：コースID */
	private Long _course_id = null;
	/** 項目値：コースコード */
	private String _course_code = null;
	/** 項目値：コース名(US) */
	private String _course_name_us = null;
	/** 項目値：コース名(日本語) */
	private String _course_name_ja = null;
	/** 項目値：概要 */
	private String _summary = null;
	/** 項目値：説明 */
	private String _description = null;
	/** 項目値：受験時間(分) */
	private Long _exam_time = null;
	/** 項目値：合格点 */
	private Long _passing_score = null;
	/** 項目値：設問数 */
	private Long _question_count = null;
	/** 項目値：登録日時 */
	private String _regist_datetime = null;

///// accessor

	//*----------------------------------------------------------------------------------------*
	//* 項目値：コースID
	//*----------------------------------------------------------------------------------------*
	/**
	 * コースIDを取得します。
	 * @return コースID
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
	//* 項目値：コースコード
	//*----------------------------------------------------------------------------------------*
	/**
	 * コースコードを取得します。
	 * @return コースコード
	 */
	public String getCourseCode() {
		return this._course_code;
	}

	/**
	 * コースコードを設定します。
	 * @param course_code コースコード
	 */
	public void setCourseCode(String course_code) {
		this._course_code = course_code;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：コース名(US)
	//*----------------------------------------------------------------------------------------*
	/**
	 * コース名(US)を取得します。
	 * @return コース名(US)
	 */
	public String getCourseNameUs() {
		return this._course_name_us;
	}

	/**
	 * コース名(US)を設定します。
	 * @param course_name_us コース名(US)
	 */
	public void setCourseNameUs(String course_name_us) {
		this._course_name_us = course_name_us;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：コース名(日本語)
	//*----------------------------------------------------------------------------------------*
	/**
	 * コース名(日本語)を取得します。
	 * @return コース名(日本語)
	 */
	public String getCourseNameJa() {
		return this._course_name_ja;
	}

	/**
	 * コース名(日本語)を設定します。
	 * @param course_name_ja コース名(日本語)
	 */
	public void setCourseNameJa(String course_name_ja) {
		this._course_name_ja = course_name_ja;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：概要
	//*----------------------------------------------------------------------------------------*
	/**
	 * 概要を取得します。
	 * @return 概要
	 */
	public String getSummary() {
		return this._summary;
	}

	/**
	 * 概要を設定します。
	 * @param summary 概要
	 */
	public void setSummary(String summary) {
		this._summary = summary;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：説明
	//*----------------------------------------------------------------------------------------*
	/**
	 * 説明を取得します。
	 * @return 説明
	 */
	public String getDescription() {
		return this._description;
	}

	/**
	 * 説明を設定します。
	 * @param description 説明
	 */
	public void setDescription(String description) {
		this._description = description;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：受験時間(分)
	//*----------------------------------------------------------------------------------------*
	/**
	 * 受験時間(分)を取得します。
	 * @return 受験時間(分)
	 */
	public Long getExamTime() {
		return this._exam_time;
	}

	/**
	 * 受験時間(分)を設定します。
	 * @param exam_time 受験時間(分)
	 */
	public void setExamTime(Long exam_time) {
		this._exam_time = exam_time;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：合格点
	//*----------------------------------------------------------------------------------------*
	/**
	 * 合格点を取得します。
	 * @return 合格点
	 */
	public Long getPassingScore() {
		return this._passing_score;
	}

	/**
	 * 合格点を設定します。
	 * @param passing_score 合格点
	 */
	public void setPassingScore(Long passing_score) {
		this._passing_score = passing_score;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：設問数
	//*----------------------------------------------------------------------------------------*
	/**
	 * 設問数を取得します.
	 * @return  設問数
	*/
	public Long getQuestionCount() {
		return this._question_count;
	}

	/**
	 * 設問数を設定します.
	 * @param question_count 設問数
	 */
	public void setQuestionCount(Long question_count) {
		this._question_count = question_count;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：登録日時
	//*----------------------------------------------------------------------------------------*
	/**
	 * 登録日時を取得します。
	 * @return _regist_datetime 登録日時
	 */
	public String getRegistDatetime() {
		return this._regist_datetime;
	}

	/**
	 * 登録日時を設定します。
	 * @param regist_datetime 登録日時
	 */
	public void setRegistDatetime(String regist_datetime) {
		this._regist_datetime = regist_datetime;
	}
}