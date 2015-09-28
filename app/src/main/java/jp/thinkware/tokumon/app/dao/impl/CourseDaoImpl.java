package jp.thinkware.tokumon.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.SQLUtils;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dao.CourseDao;
import jp.thinkware.tokumon.app.dto.CourseDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * DBレコードのDAO実装クラスです。(コース情報テーブル)
 * @author thinkware
 */
public class CourseDaoImpl implements CourseDao {

///// field

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

///// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	public CourseDaoImpl(Context context) {
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(context).getWritableDatabase();
	}

	/**
	 * DBにレコードを追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(CourseDto dto) {
		//******************************************************************************************
		//* DBにレコードを追加する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(CourseDto.COLUMN_COURSE_ID, dto.getCourseId());             // コースID
		values.put(CourseDto.COLUMN_COURSE_CODE, dto.getCourseCode());         // コースコード
		values.put(CourseDto.COLUMN_COURSE_NAME_US, dto.getCourseNameUs());    // コース名(US)
		values.put(CourseDto.COLUMN_COURSE_NAME_JA, dto.getCourseNameJa());    // コース名(日本語)
		values.put(CourseDto.COLUMN_SUMMARY, dto.getSummary());                // 概要
		values.put(CourseDto.COLUMN_DESCRIPTION, dto.getDescription());        // 説明
		values.put(CourseDto.COLUMN_EXAM_TIME, dto.getExamTime());             // 受験時間(分)
		values.put(CourseDto.COLUMN_PASSING_SCORE, dto.getPassingScore());     // 合格点
		values.put(CourseDto.COLUMN_QUESTION_COUNT, dto.getQuestionCount());   // 設問数
		values.put(CourseDto.COLUMN_REGIST_DATETIME, dto.getRegistDatetime()); // 登録日時
		// DBにレコードを追加する
		Long rowId = this.db.insertOrThrow(CourseDto.TABLE_NAME, null, values);

		// 処理終了
		return rowId;
	}

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 */
	public void update(CourseDto dto) {
		//******************************************************************************************
		//* DBのレコードを更新する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(CourseDto.COLUMN_COURSE_ID, dto.getCourseId());             // コースID
		values.put(CourseDto.COLUMN_COURSE_CODE, dto.getCourseCode());         // コースコード
		values.put(CourseDto.COLUMN_COURSE_NAME_US, dto.getCourseNameUs());    // コース名(US)
		values.put(CourseDto.COLUMN_COURSE_NAME_JA, dto.getCourseNameJa());    // コース名(日本語)
		values.put(CourseDto.COLUMN_SUMMARY, dto.getSummary());                // 概要
		values.put(CourseDto.COLUMN_DESCRIPTION, dto.getDescription());        // 説明
		values.put(CourseDto.COLUMN_EXAM_TIME, dto.getExamTime());             // 受験時間(分)
		values.put(CourseDto.COLUMN_PASSING_SCORE, dto.getPassingScore());     // 合格点
		values.put(CourseDto.COLUMN_QUESTION_COUNT, dto.getQuestionCount());   // 設問数
		values.put(CourseDto.COLUMN_REGIST_DATETIME, dto.getRegistDatetime()); // 登録日時
		// 抽出条件を生成する
		StringBuilder conditionBuilder = new StringBuilder();
		conditionBuilder.append(CourseDto.COLUMN_COURSE_ID  + "=?"); // コースID
		//*------------------------------------------------------------------------------------*
		//* DBのレコードを更新する
		//*------------------------------------------------------------------------------------*
 		this.db.update(
 			CourseDto.TABLE_NAME,
 			values, conditionBuilder.toString(),
 			new String[]{
 				  String.valueOf(dto.getCourseId()) // コースID
 			});
	}

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 */
	public void delete(CourseDto dto) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(CourseDto.COLUMN_COURSE_ID, dto.getCourseId()); // コースID
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
		this.db.delete(CourseDto.TABLE_NAME, whereStr, null);
	}

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<CourseDto> selectList(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<CourseDto> dtoList = new ArrayList<CourseDto>(); // 抽出データリスト
		// 抽出条件マップを生成する：[コース情報テーブル]
		 Map<String, Object> narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					CourseDto.COLUMN_COURSE_ID // コースID
				}
			);
		String whereStr = StringUtils.toWhereString(narrowCondMap); // 抽出条件文字列
		StringBuilder orderbyBuilder = new StringBuilder(); // ソート順文字列
		orderbyBuilder.append(CourseDto.COLUMN_COURSE_ID); // コースID：[昇順]
		orderbyBuilder.append(" ASC");
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				CourseDto.TABLE_NAME, null, whereStr, null, null, null,
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
	protected CourseDto getRecord(Cursor cursor) {
		//******************************************************************************************
		//* カーソル位置のレコードデータを取得する
		//******************************************************************************************
		CourseDto dto = new CourseDto();
		dto.setCourseId(cursor.getLong(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_COURSE_ID)));               // コースID
		dto.setCourseCode(cursor.getString(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_COURSE_CODE)));         // コースコード
		dto.setCourseNameUs(cursor.getString(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_COURSE_NAME_US)));    // コース名(US)
		dto.setCourseNameJa(cursor.getString(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_COURSE_NAME_JA)));    // コース名(日本語)
		dto.setSummary(cursor.getString(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_SUMMARY)));                // 概要
		dto.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_DESCRIPTION)));        // 説明
		dto.setExamTime(cursor.getLong(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_EXAM_TIME)));               // 受験時間(分)
		dto.setPassingScore(cursor.getLong(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_PASSING_SCORE)));       // 合格点
		dto.setQuestionCount(cursor.getLong(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_QUESTION_COUNT)));     // 設問数
		dto.setRegistDatetime(cursor.getString(cursor.getColumnIndexOrThrow(CourseDto.COLUMN_REGIST_DATETIME))); // 登録日時

		// 処理終了
		return dto;
	}
}