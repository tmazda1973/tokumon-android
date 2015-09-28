package jp.thinkware.tokumon.app.dto;

import java.io.Serializable;

/**
 * DBレコードのDTOクラスです。(ユーザ情報テーブル)
 * @author thinkware
 */
public class KaidenUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

///// const

	//**********************************************************************************************
	//* 定数
	//**********************************************************************************************
	/** テーブル名 */
	public static final String TABLE_NAME = "kaiden_user";

	/** カラム名：ユーザID */
	public static final String COLUMN_USER_ID = "user_id";
	/** カラム名：ユーザ名 */
	public static final String COLUMN_NAME = "name";

///// field

	/** 項目値：ユーザID */
	private Long _user_id = null;
	/** 項目値：ユーザ名 */
	private String _name = null;

///// accessor

	//*----------------------------------------------------------------------------------------*
	///* 項目値：ユーザID
	//*----------------------------------------------------------------------------------------*
	/**
	 * ユーザIDを取得します。
	 * @return _user_id ユーザID
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
	///* 項目値：ユーザ名
	//*----------------------------------------------------------------------------------------*
	/**
	 * ユーザ名を取得します。
	 * @return ユーザ名
	 */
	public String getName() {
		return this._name;
	}

	/**
	 * ユーザ名を設定します。
	 * @param name ユーザ名
	 */
	public void setName(String name) {
		this._name = name;
	}
}