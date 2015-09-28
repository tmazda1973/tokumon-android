package jp.thinkware.tokumon.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dao.QuestionCategoryDao;
import jp.thinkware.tokumon.app.dto.QuestionCategoryDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * DBレコードのDAO実装クラスです。(設問カテゴリテーブル)
 * @author thinkware
 */
public class QuestionCategoryDaoImpl implements QuestionCategoryDao {

///// field

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

///// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	public QuestionCategoryDaoImpl(Context context) {
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(context).getWritableDatabase();
	}

	/**
	 * DBにレコードを追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(QuestionCategoryDto dto) {
		//******************************************************************************************
		//* DBにレコードを追加する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(QuestionCategoryDto.COLUMN_CATEGORY_ID, dto.getCategoryId());     // カテゴリID
		values.put(QuestionCategoryDto.COLUMN_COURSE_ID, dto.getCourseId());         // コースID
		values.put(QuestionCategoryDto.COLUMN_CATEGORY_NAME, dto.getCategoryName()); // カテゴリ名
		// DBにレコードを追加する
		Long rowId = this.db.insertOrThrow(QuestionCategoryDto.TABLE_NAME, null, values);

		// 処理終了
		return rowId;
	}

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 */
	public void update(QuestionCategoryDto dto) {
		//******************************************************************************************
		//* DBのレコードを更新する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(QuestionCategoryDto.COLUMN_CATEGORY_ID, dto.getCategoryId());     // カテゴリID
		values.put(QuestionCategoryDto.COLUMN_COURSE_ID, dto.getCourseId());         // コースID
		values.put(QuestionCategoryDto.COLUMN_CATEGORY_NAME, dto.getCategoryName()); // カテゴリ名
		// 抽出条件を生成する
		StringBuilder conditionBuilder = new StringBuilder();
		conditionBuilder.append(QuestionCategoryDto.COLUMN_CATEGORY_ID);
		conditionBuilder.append("=?");
		//*------------------------------------------------------------------------------------*
		//* DBのレコードを更新する
		//*------------------------------------------------------------------------------------*
 		this.db.update(
 			QuestionCategoryDto.TABLE_NAME, values, conditionBuilder.toString(),
 			new String[]{
 				  String.valueOf(dto.getCategoryId()) // カテゴリID
 			}
		);
	}

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 */
	public void delete(QuestionCategoryDto dto) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(QuestionCategoryDto.COLUMN_CATEGORY_ID , dto.getCategoryId()); // カテゴリID
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
		this.db.delete(QuestionCategoryDto.TABLE_NAME, whereStr, null);
	}

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<QuestionCategoryDto> selectList(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<QuestionCategoryDto> dtoList = new ArrayList<QuestionCategoryDto>(); // 抽出データリスト
		String whereStr = StringUtils.toWhereString(conditionMap); // 抽出条件文字列
		StringBuilder orderbyBuilder = new StringBuilder(); // ソート順文字列
		orderbyBuilder.append(QuestionCategoryDto.COLUMN_CATEGORY_ID);
		orderbyBuilder.append(" ASC");
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				QuestionCategoryDto.TABLE_NAME, null, whereStr, null, null, null,
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
	protected QuestionCategoryDto getRecord(Cursor cursor) {
		//******************************************************************************************
		//* カーソル位置のレコードデータを取得する
		//******************************************************************************************
		QuestionCategoryDto dto = new QuestionCategoryDto();
		dto.setCategoryId(cursor.getLong(cursor.getColumnIndexOrThrow(QuestionCategoryDto.COLUMN_CATEGORY_ID))); // カテゴリID
		dto.setCourseId(cursor.getLong(cursor.getColumnIndexOrThrow(QuestionCategoryDto.COLUMN_COURSE_ID)));     // コースID
		dto.setCategoryName(cursor.getString(cursor.getColumnIndexOrThrow(QuestionCategoryDto.COLUMN_CATEGORY_NAME))); // カテゴリ名

		// 処理終了
		return dto;
	}
}