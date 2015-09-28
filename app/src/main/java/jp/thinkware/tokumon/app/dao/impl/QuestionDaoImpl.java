package jp.thinkware.tokumon.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.ListUtils;
import jp.thinkware.tokumon.app.common.util.SQLUtils;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dao.ChoicesDao;
import jp.thinkware.tokumon.app.dao.QuestionDao;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.dto.QuestionDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * DBレコードのDAO実装クラスです。(設問テーブル)
 * @author thinkware
 */
public class QuestionDaoImpl implements QuestionDao {

///// field

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

	/** 結合テーブル：[選択肢DAOクラス] */
	private ChoicesDao choicesDao = null;

///// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	public QuestionDaoImpl(Context context) {
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(context).getWritableDatabase();
		// 結合テーブルのDAOインスタンスを生成する
		this.choicesDao = new ChoicesDaoImpl(context); // 選択肢DAOクラス
	}

	/**
	 * DBにレコードを追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(QuestionDto dto) {
		//******************************************************************************************
		//* DBにレコードを追加する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(QuestionDto.COLUMN_QUESTION_ID, dto.getQuestionId());   // 設問ID
		values.put(QuestionDto.COLUMN_COURSE_ID, dto.getCourseId());       // コースID
		values.put(QuestionDto.COLUMN_CATEGORY_ID, dto.getCategoryId());   // カテゴリID
		values.put(QuestionDto.COLUMN_QUESTION, dto.getQuestion());        // 問題
		values.put(QuestionDto.COLUMN_PATTERN, dto.getPattern());          // 設問パターン
		values.put(QuestionDto.COLUMN_CHOICES, dto.getChoices());          // 選択肢数
		values.put(QuestionDto.COLUMN_ANSWERS, dto.getAnswers());          // 解答数
		values.put(QuestionDto.COLUMN_CHART_SOURCE, dto.getChartSource()); // ソース、図表データ
		values.put(QuestionDto.COLUMN_EXPLANATION, dto.getExplanation());  // 設問に対する解説
		// DBにレコードを追加する
		Long rowId = this.db.insertOrThrow(QuestionDto.TABLE_NAME, null, values);

		// 処理終了
		return rowId;
	}

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 */
	public void update(QuestionDto dto) {
		//******************************************************************************************
		//* DBのレコードを更新する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(QuestionDto.COLUMN_QUESTION_ID, dto.getQuestionId());   // 設問ID
		values.put(QuestionDto.COLUMN_COURSE_ID, dto.getCourseId());       // コースID
		values.put(QuestionDto.COLUMN_CATEGORY_ID, dto.getCategoryId());   // カテゴリID
		values.put(QuestionDto.COLUMN_QUESTION, dto.getQuestion());        // 問題
		values.put(QuestionDto.COLUMN_PATTERN, dto.getPattern());          // 設問パターン
		values.put(QuestionDto.COLUMN_CHOICES, dto.getChoices());          // 選択肢数
		values.put(QuestionDto.COLUMN_ANSWERS, dto.getAnswers());          // 解答数
		values.put(QuestionDto.COLUMN_CHART_SOURCE, dto.getChartSource()); // ソース、図表データ
		values.put(QuestionDto.COLUMN_EXPLANATION, dto.getExplanation());  // 設問に対する解説
		// 抽出条件を生成する
		StringBuilder conditionBuilder = new StringBuilder();
		conditionBuilder.append(QuestionDto.COLUMN_QUESTION_ID); // 設問ID
		conditionBuilder.append("=?");
		//*------------------------------------------------------------------------------------*
		//* DBのレコードを更新する
		//*------------------------------------------------------------------------------------*
 		this.db.update(
 			QuestionDto.TABLE_NAME, values, conditionBuilder.toString(),
 			new String[]{
 				  String.valueOf(dto.getQuestionId()) // 設問ID
 			}
		);
	}

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 */
	public void delete(QuestionDto dto) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(QuestionDto.COLUMN_QUESTION_ID , dto.getQuestionId()); // 設問ID
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
		this.db.delete(QuestionDto.TABLE_NAME, whereStr, null);
	}

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<QuestionDto> selectList(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<QuestionDto> dtoList = new ArrayList<QuestionDto>(); // 抽出データリスト
		// 抽出条件マップを生成する：[設問テーブル]
		Map<String, Object> narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					  QuestionDto.COLUMN_COURSE_ID   // コースID
					, QuestionDto.COLUMN_CATEGORY_ID // カテゴリID
					, QuestionDto.COLUMN_QUESTION_ID // 設問ID
				}
			);
		String whereStr = StringUtils.toWhereStringPlaceholder(narrowCondMap); // 抽出条件文字列
		String[] whereArgs = ListUtils.toStringArray(narrowCondMap.values()); // 抽出条件値配列
		StringBuilder orderbyBuilder = new StringBuilder(); // ソート順文字列
		orderbyBuilder.append(QuestionDto.COLUMN_QUESTION_ID);
		orderbyBuilder.append(" ASC");
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				QuestionDto.TABLE_NAME, null, whereStr, whereArgs, null, null,
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

	/**
	 * DBのレコードを抽出します。(抽出件数指定あり)
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<QuestionDto> selectList(Map<String, Object> conditionMap, long limitCount) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<QuestionDto> dtoList = new ArrayList<QuestionDto>(); // 抽出データリスト
		// 抽出条件マップを生成する：[設問テーブル]
		Map<String, Object> narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					  QuestionDto.COLUMN_COURSE_ID   // コースID
					, QuestionDto.COLUMN_CATEGORY_ID // カテゴリID
					, QuestionDto.COLUMN_QUESTION_ID // 設問ID
				}
			);
		String whereStr = StringUtils.toWhereStringPlaceholder(narrowCondMap); // 抽出条件文字列
		String[] whereArgs = ListUtils.toStringArray(narrowCondMap.values()); // 抽出条件値配列
		StringBuilder orderbyBuilder = new StringBuilder(); // ソート順文字列
		orderbyBuilder.append(QuestionDto.COLUMN_QUESTION_ID); // 設問ID
		orderbyBuilder.append(" ASC");
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				QuestionDto.TABLE_NAME, null, whereStr, whereArgs, null, null,
 				orderbyBuilder.toString(), String.valueOf(limitCount));
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


	/**
	 * 結合テーブルも含めてDBからレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データオブジェクト
	 */
	public QuestionDto selectWithJoin(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBから設問データを抽出する(結合テーブル含む)
		//******************************************************************************************
		QuestionDto questionDto = null; // 設問DTO
		// 設問テーブルのレコードを抽出する
		List<QuestionDto> selectDtoList = this.selectList(conditionMap);
		// レコードが存在しない場合は終了する
		if (selectDtoList.size() <= 0) {
			// 処理終了
			return questionDto;
		}
		// 先頭の1件を取得する(抽出条件が正しければ1件しか抽出されない)
		questionDto = selectDtoList.get(0);
		//*------------------------------------------------------------------------------------*
		//* 選択肢テーブル
		//*------------------------------------------------------------------------------------*
		// 選択肢テーブルのレコードを抽出する
		List<ChoicesDto> choicesDtoList = this.choicesDao.selectList(conditionMap);
		// 選択肢Dtoを設問Dtoに設定する
		questionDto.getJoin().setChoicesDtoList(choicesDtoList);

		// 処理終了
		return questionDto;
	}

///// protected method

	/**
	 * カーソル位置のレコードデータを取得します。
	 * @param cursor カーソルオブジェクト
	 * @return レコードデータ
	 */
	protected QuestionDto getRecord(Cursor cursor) {
		//******************************************************************************************
		//* カーソル位置のレコードデータを取得する
		//******************************************************************************************
		QuestionDto dto = new QuestionDto();
		dto.setQuestionId(cursor.getLong(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_QUESTION_ID)));    // 設問ID
		dto.setCourseId(cursor.getLong(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_COURSE_ID)));        // コースID
		dto.setCategoryId(cursor.getLong(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_CATEGORY_ID)));    // カテゴリID
		dto.setQuestion(cursor.getString(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_QUESTION)));       // 問題
		dto.setPattern(cursor.getString(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_PATTERN)));         // 設問パターン
		dto.setChoices(cursor.getLong(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_CHOICES)));           // 選択肢数
		dto.setAnswers(cursor.getLong(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_ANSWERS)));           // 解答数
		dto.setChartSource(cursor.getBlob(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_CHART_SOURCE)));  // ソース、図表データ
		dto.setExplanation(cursor.getString(cursor.getColumnIndexOrThrow(QuestionDto.COLUMN_EXPLANATION))); // 設問に対する解説

		// 処理終了
		return dto;
	}
}