package jp.thinkware.tokumon.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dao.KaidenUserDao;
import jp.thinkware.tokumon.app.dto.KaidenUserDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * DBレコードのDAO実装クラスです。(ユーザ情報テーブル)
 * @author thinkware
 */
public class KaidenUserDaoImpl implements KaidenUserDao {

///// field

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

////// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	public KaidenUserDaoImpl(Context context) {
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(context).getWritableDatabase();
	}

	/**
	 * DBにレコードを追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(KaidenUserDto dto) {
		//******************************************************************************************
		//* DBにレコードを追加する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(KaidenUserDto.COLUMN_USER_ID, dto.getUserId()); // ユーザID
		values.put(KaidenUserDto.COLUMN_NAME, dto.getName());      // ユーザ名
		// DBにレコードを追加する
		Long rowId = this.db.insertOrThrow(KaidenUserDto.TABLE_NAME, null, values);

		// 処理終了
		return rowId;
	}

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 */
	public void update(KaidenUserDto dto) {
		//******************************************************************************************
		//* DBのレコードを更新する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(KaidenUserDto.COLUMN_USER_ID, dto.getUserId());
		values.put(KaidenUserDto.COLUMN_NAME, dto.getName());
		// 抽出条件を生成する
		StringBuilder conditionBuilder = new StringBuilder();
		conditionBuilder.append(KaidenUserDto.COLUMN_USER_ID); // ユーザID
		conditionBuilder.append("=?");
		//*------------------------------------------------------------------------------------*
		//* DBのレコードを更新する
		//*------------------------------------------------------------------------------------*
 		this.db.update(
 			KaidenUserDto.TABLE_NAME,
 			values, conditionBuilder.toString(),
 			new String[]{
 				  String.valueOf(dto.getUserId()) // ユーザID
 			});
	}

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 */
	public void delete(KaidenUserDto dto) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(KaidenUserDto.COLUMN_USER_ID , dto.getUserId()); // ユーザID
		// DBのレコードを削除する
		this.delete(conditionMap);
	}

	/**
	 * DBのレコードを削除します。
	 * @param conditionMap 抽出条件マップ
	 */
	public void delete(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		String whereStr = StringUtils.toWhereString(conditionMap); // 抽出条件文字列
		this.db.delete(KaidenUserDto.TABLE_NAME, whereStr, null);
	}

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<KaidenUserDto> selectList(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<KaidenUserDto> dtoList = new ArrayList<KaidenUserDto>(); // 抽出データリスト
		String whereStr = StringUtils.toWhereString(conditionMap); // 抽出条件文字列
		StringBuilder orderbyBuilder = new StringBuilder(); // ソート順文字列
		orderbyBuilder.append(KaidenUserDto.COLUMN_USER_ID); // ユーザID
		orderbyBuilder.append(" ASC");
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				KaidenUserDto.TABLE_NAME, null, whereStr, null, null, null,
 				orderbyBuilder.toString());
		// 抽出対象のレコードが存在する場合
		if (cursor.moveToFirst()) {
			// 抽出対象レコードを全てリストに追加する
			while (!cursor.isAfterLast()) {
				dtoList.add(this.getRecord(cursor));
				cursor.moveToNext();
			}
		}
		// カーソルを破棄する
		cursor.close();

		// 処理終了
		return dtoList;
	}

///// protected method

	/**
	 * カーソル位置のレコードデータを取得します。
	 * @param cursor カーソルオブジェクト
	 * @return レコードデータ
	 */
	protected KaidenUserDto getRecord(Cursor cursor) {
		//******************************************************************************************
		//* カーソル位置のレコードデータを取得する
		//******************************************************************************************
		KaidenUserDto dto = new KaidenUserDto();
		dto.setUserId(cursor.getLong(cursor.getColumnIndexOrThrow(KaidenUserDto.COLUMN_USER_ID))); // ユーザID
		dto.setName(cursor.getString(cursor.getColumnIndexOrThrow(KaidenUserDto.COLUMN_NAME)));    // ユーザ名

		// 処理終了
		return dto;
	}
}