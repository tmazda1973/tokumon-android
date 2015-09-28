package jp.thinkware.tokumon.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.SQLUtils;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dao.AnswerDao;
import jp.thinkware.tokumon.app.dao.AnswerSheetDao;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * DBレコードのDAO実装クラスです。(解答用紙テーブル)
 * @author thinkware
 */
public class AnswerSheetDaoImpl implements AnswerSheetDao {

///// field

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

	/** 結合テーブル：[解答DAOクラス] */
	private AnswerDao answerDao = null;

///// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	public AnswerSheetDaoImpl(Context context) {
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(context).getWritableDatabase();
		// 結合テーブルのDAOインスタンスを生成する
		this.answerDao = new AnswerDaoImpl(context); // 解答DAOクラス
	}

	/**
	 * DBにレコードを追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(AnswerSheetDto dto) {
		//******************************************************************************************
		//* DBにレコードを追加する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(AnswerSheetDto.COLUMN_USER_ID, dto.getUserId());
		values.put(AnswerSheetDto.COLUMN_EXAM_DATETIME, dto.getExamDatetime());
		values.put(AnswerSheetDto.COLUMN_COURSE_ID, dto.getCourseId());
		values.put(AnswerSheetDto.COLUMN_TIME_LIMIT, dto.getTimeLimit());
		values.put(AnswerSheetDto.COLUMN_CURRENT_QUESTION, dto.getCurrentQuestion());
		values.put(AnswerSheetDto.COLUMN_SCORE, dto.getScore());
		values.put(AnswerSheetDto.COLUMN_QUESTION_COUNT, dto.getQuestionCount());
		values.put(AnswerSheetDto.COLUMN_ANSWER_COUNT, dto.getAnswerCount());
		values.put(AnswerSheetDto.COLUMN_CORRECT_COUNT, dto.getCorrectCount());
		values.put(AnswerSheetDto.COLUMN_STATUS, dto.getStatus());
		// DBにレコードを追加する
		Long rowId = this.db.insertOrThrow(AnswerSheetDto.TABLE_NAME, null, values);

		// 処理終了
		return rowId;
	}

	/**
	 * 指定行のレコードを抽出します。
	 * @param rowId 行ID
	 * @return データオブジェクト
	 */
	public AnswerSheetDto selectRow(Long rowId) {
		//******************************************************************************************
		//* 指定行のレコードを抽出する
		//******************************************************************************************
		AnswerSheetDto dto = null; // データオブジェクト
		// 行IDが指定されている場合
		if (rowId != null) {
			// DBのレコードを抽出する
			String whereStr = "ROWID=" + rowId; // WHERE句文字列
			Cursor cursor = this.db.query(
				AnswerSheetDto.TABLE_NAME,
				null, whereStr, null, null, null, "ROWID desc");
			// 抽出対象のレコードが存在する場合
			if (cursor.moveToFirst()) {
				// 指定行のレコードを取得する(1件のみ存在するはず)
				dto = this.getRecord(cursor);
				cursor.close();
			}
		}
		// 処理終了
		return dto;
	}

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 */
	public void update(AnswerSheetDto dto) {
		//******************************************************************************************
		//* DBのレコードを更新する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		if (dto.getRecordId() != null) values.put(AnswerSheetDto.COLUMN_RECORD_ID, dto.getRecordId()); // 成績ID
		if (dto.getUserId() != null) values.put(AnswerSheetDto.COLUMN_USER_ID, dto.getUserId()); // ユーザID
		if (dto.getExamDatetime() != null) values.put(AnswerSheetDto.COLUMN_EXAM_DATETIME, dto.getExamDatetime()); // 受験日時
		if (dto.getCourseId() != null) values.put(AnswerSheetDto.COLUMN_COURSE_ID, dto.getCourseId()); // コースID
		if (dto.getTimeLimit() != null) values.put(AnswerSheetDto.COLUMN_TIME_LIMIT, dto.getTimeLimit()); // 制限時間
		if (dto.getCurrentQuestion() != null) values.put(AnswerSheetDto.COLUMN_CURRENT_QUESTION, dto.getCurrentQuestion()); // 現在の設問
		if (dto.getScore() != null) values.put(AnswerSheetDto.COLUMN_SCORE, dto.getScore()); // 点数
		if (dto.getQuestionCount() != null) values.put(AnswerSheetDto.COLUMN_QUESTION_COUNT, dto.getQuestionCount()); // 設問数
		if (dto.getAnswerCount() != null) values.put(AnswerSheetDto.COLUMN_ANSWER_COUNT, dto.getAnswerCount()); // 解答数
		if (dto.getCorrectCount() != null) values.put(AnswerSheetDto.COLUMN_CORRECT_COUNT, dto.getCorrectCount()); // 正解数
		if (dto.getStatus() != null) values.put(AnswerSheetDto.COLUMN_STATUS, dto.getStatus()); // 状態
		// 抽出条件を生成する
		StringBuilder conditionBuilder = new StringBuilder();
		conditionBuilder.append(AnswerSheetDto.COLUMN_RECORD_ID); // 成績ID
		conditionBuilder.append("=?"); // 成績ID
		//*------------------------------------------------------------------------------------*
		//* DBのレコードを更新する
		//*------------------------------------------------------------------------------------*
 		this.db.update(
 			AnswerSheetDto.TABLE_NAME, values, conditionBuilder.toString(),
 			new String[]{
 				  String.valueOf(dto.getRecordId()) // 成績ID
 			});
	}

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 */
	public void delete(AnswerSheetDto dto) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(AnswerSheetDto.COLUMN_RECORD_ID , dto.getRecordId()); // 成績ID
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
		this.db.delete(AnswerSheetDto.TABLE_NAME, whereStr, null);
	}

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<AnswerSheetDto> selectList(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<AnswerSheetDto> dtoList = new ArrayList<AnswerSheetDto>(); // 抽出データリスト
		// 抽出条件マップを生成する
		 Map<String, Object> narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					AnswerSheetDto.COLUMN_RECORD_ID // 成績ID
				}
			);
		String whereStr = StringUtils.toWhereString(narrowCondMap); // 抽出条件文字列
		StringBuilder orderbyBuilder = new StringBuilder(); // ソート順文字列
		orderbyBuilder.append(AnswerSheetDto.COLUMN_RECORD_ID);
		orderbyBuilder.append(" ASC");
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				AnswerSheetDto.TABLE_NAME, null, whereStr, null, null, null,
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
	 * DBから解答データを結合テーブルも含めて抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return 解答データ
	 */
	public AnswerSheetDto selectWithJoin(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBから解答データを抽出する(結合テーブル含む)
		//******************************************************************************************
		AnswerSheetDto answerSheetDto = null; // 解答用紙Dto
		//*------------------------------------------------------------------------------------*
		//* 解答用紙テーブル
		//*------------------------------------------------------------------------------------*
		// 解答テーブルのレコードを抽出する
		List<AnswerSheetDto> answerSheetDtoList = this.selectList(conditionMap);
		// レコードが存在しない場合は終了する
		if (answerSheetDtoList.size() <= 0) {
			// 処理終了
			return answerSheetDto;
		}
		// 先頭の1件を取得する(抽出条件が正しければ1件しか抽出されない)
		answerSheetDto = answerSheetDtoList.get(0);
		//*------------------------------------------------------------------------------------*
		//* 解答テーブル
		//*------------------------------------------------------------------------------------*
		// 解答テーブルのレコードを抽出する
		List<AnswerDto> answerDtoList = this.answerDao.selectList(conditionMap);
		// レコードが存在しない場合は終了する
		if (answerDtoList.size() <= 0) {
			// 処理終了
			return answerSheetDto;
		}
		/***** 結合テーブルを含めて抽出する *****/
		 Map<String, Object> narrowCondMap = new HashMap<String, Object>(); // 抽出条件マップ
		// 結合テーブルデータを設定する(解答データリスト)
		answerSheetDto.getJoin().setAnswerDtoList(answerDtoList);
		// レコードの件数分ループする
		for (AnswerDto answerDto : answerDtoList) {
			// 抽出条件マップを再設定する
			narrowCondMap.clear();
			narrowCondMap.put(AnswerDto.COLUMN_RECORD_ID, answerDto.getRecordId());     // 成績ID
			narrowCondMap.put(AnswerDto.COLUMN_QUESTION_ID, answerDto.getQuestionId()); // 設問ID
			// 解答テーブルを抽出する(結合テーブル含む)
			AnswerDto answerJoinDto = this.answerDao.selectWithJoin(narrowCondMap);
			// レコードが存在する場合
			if (answerJoinDto != null) {
				// 抽出した結合テーブルのレコードを設定する
				answerDto.getJoin().setQuestionDto(answerJoinDto.getJoin().getQuestionDto());       // 設問DTO
				answerDto.getJoin().setChoicesDtoList(answerJoinDto.getJoin().getChoicesDtoList()); // 選択肢DTOリスト
			}
		}
		// 処理終了
		return answerSheetDto;
	}

// protected method

	/**
	 * カーソル位置のレコードデータを取得します。
	 * @param cursor カーソルオブジェクト
	 * @return レコードデータ
	 */
	protected AnswerSheetDto getRecord(Cursor cursor) {
		//******************************************************************************************
		//* カーソル位置のレコードデータを取得する
		//******************************************************************************************
		AnswerSheetDto dto = new AnswerSheetDto();
		dto.setRecordId(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_RECORD_ID)));
		dto.setUserId(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_USER_ID)));
		dto.setExamDatetime(cursor.getString(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_EXAM_DATETIME)));
		dto.setCourseId(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_COURSE_ID)));
		dto.setTimeLimit(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_TIME_LIMIT)));
		dto.setCurrentQuestion(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_CURRENT_QUESTION)));
		dto.setScore(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_SCORE)));
		dto.setQuestionCount(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_QUESTION_COUNT)));
		dto.setAnswerCount(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_ANSWER_COUNT)));
		dto.setCorrectCount(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_CORRECT_COUNT)));
		dto.setStatus(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerSheetDto.COLUMN_STATUS)));

		// 処理終了
		return dto;
	}
}