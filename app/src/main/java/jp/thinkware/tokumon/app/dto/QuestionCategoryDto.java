package jp.thinkware.tokumon.app.dto;

import java.io.Serializable;

/**
 * DBレコードのDTOクラスです。(設問カテゴリテーブル)
 * @author thinkware
 */
public class QuestionCategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;

///// const

	//**********************************************************************************************
	//* 定数
	//**********************************************************************************************
	/** テーブル名 */
	public static final String TABLE_NAME = "question_category";

	/** カラム名：カテゴリID */
	public static final String COLUMN_CATEGORY_ID = "category_id";
	/** カラム名：コースコード */
	public static final String COLUMN_COURSE_ID = "course_id";
	/** カラム名：カテゴリ名 */
	public static final String COLUMN_CATEGORY_NAME = "category_name";

///// field

	/** 項目値：カテゴリID */
	private Long _category_id = null;
	/** 項目値：コースID */
	private Long _course_id = null;
	/** 項目値：カテゴリ名 */
	private String _category_name = null;

///// accessor

	//*----------------------------------------------------------------------------------------*
	//* 項目値：カテゴリID
	//*----------------------------------------------------------------------------------------*
	/**
	 * カテゴリIDを取得します。
	 * @return カテゴリID
	 */
	public Long getCategoryId() {
		return this._category_id;
	}

	/**
	 * カテゴリIDを設定します。
	 * @param category_id カテゴリID
	 */
	public void setCategoryId(Long category_id) {
		this._category_id = category_id;
	}

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
	//* 項目値：カテゴリ名
	//*----------------------------------------------------------------------------------------*
	/**
	 * カテゴリ名を取得します。
	 * @return カテゴリ名
	 */
	public String getCategoryName() {
		return this._category_name;
	}

	/**
	 * カテゴリ名を設定します。
	 * @param category_name カテゴリ名
	 */
	public void setCategoryName(String category_name) {
		this._category_name = category_name;
	}
}