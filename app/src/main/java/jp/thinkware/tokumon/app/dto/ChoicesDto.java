package jp.thinkware.tokumon.app.dto;

import java.io.Serializable;

/**
 * DBレコードのDTOクラスです。(選択肢テーブル)
 * @author thinkware
 */
public class ChoicesDto implements Serializable {

	private static final long serialVersionUID = 1L;

///// const

	//**********************************************************************************************
	//* 定数
	//**********************************************************************************************
	/** テーブル名 */
	public static final String TABLE_NAME = "choices";

	/** カラム名：設問ID */
	public static final String COLUMN_QUESTION_ID = "question_id";
	/** カラム名：選択肢ID */
	public static final String COLUMN_CHOICES_ID = "choices_id";
	/** カラム名：内容 */
	public static final String COLUMN_CONTENT = "content";
	/** カラム名：正解フラグ */
	public static final String COLUMN_CORRECT_FLAG = "correct_flag";

	/** 正解フラグ：[正解である] */
	public static final Long CORRECT_FLAG_TRUE  = (long)1;
	/** 正解フラグ：[正解ではない] */
	public static final Long CORRECT_FLAG_FALSE = (long)0;

///// field

	/** 項目値：設問ID */
	private Long _question_id = null;
	/** 項目値：選択肢ID */
	private Long _choices_id = null;
	/** 項目値：内容 */
	private String _content = null;
	/** 項目値：正解フラグ */
	private Long _correct_flag = null;

///// accessor

	/********** 項目値：設問ID **********/
	/**
	 * 設問IDを取得します。
	 * @return 設問ID
	 */
	public Long getQuestionId() {
		return this._question_id;
	}

	/**
	 * 設問IDを設定します。
	 * @param question_id 設問ID
	 */
	public void setQuestionId(Long question_id) {
		this._question_id = question_id;
	}

	/********** 項目値：選択肢ID **********/
	/**
	 * 選択肢IDを取得します。
	 * @return 選択肢ID
	 */
	public Long getChoicesId() {
		return this._choices_id;
	}

	/**
	 * 選択肢IDを設定します。
	 * @param choices_id 選択肢ID
	 */
	public void setChoicesId(Long choices_id) {
		this._choices_id = choices_id;
	}

	/********** 項目値：内容 **********/
	/**
	 * 内容を取得します。
	 * @return 内容
	 */
	public String getContent() {
		return this._content;
	}

	/**
	 * 内容を設定します。
	 * @param content 内容
	 */
	public void setContent(String content) {
		this._content = content;
	}

	/********** 項目値：正解フラグ **********/
	/**
	 * 正解フラグを取得します。
	 * @return 正解フラグ
	 */
	public Long getCorrectFlag() {
		return this._correct_flag;
	}

	/**
	 * 正解フラグを設定します。
	 * @param correct_flag 正解フラグ
	 */
	public void setCorrectFlag(Long correct_flag) {
		this._correct_flag = correct_flag;
	}
}

