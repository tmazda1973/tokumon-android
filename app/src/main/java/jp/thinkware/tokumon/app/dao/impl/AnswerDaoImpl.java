package jp.thinkware.tokumon.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.SQLUtils;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dao.AnswerDao;
import jp.thinkware.tokumon.app.dao.ChoicesDao;
import jp.thinkware.tokumon.app.dao.QuestionDao;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.dto.QuestionDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * DBレコードのDAO実装クラスです。(解答テーブル)
 * @author thinkware
 */
public class AnswerDaoImpl implements AnswerDao {

///// field

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

	/** 結合テーブル：[設問DAOクラス] */
	private QuestionDao questionDao = null;
	/** 結合テーブル：[選択肢DAOクラス] */
	private ChoicesDao choicesDao = null;

///// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	public AnswerDaoImpl(Context context) {
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(context).getWritableDatabase();
		// 結合テーブルのDAOインスタンスを生成する
		this.questionDao = new QuestionDaoImpl(context); // 設問DAOクラス
		this.choicesDao  = new ChoicesDaoImpl(context);  // 選択肢DAOクラス
	}

	/**
	 * DBにレコードを追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(AnswerDto dto) {
		//******************************************************************************************
		//* DBにレコードを追加する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(AnswerDto.COLUMN_RECORD_ID, dto.getRecordId());
		values.put(AnswerDto.COLUMN_QUESTION_ID, dto.getQuestionId());
		values.put(AnswerDto.COLUMN_QUESTION_NO, dto.getQuestionNo());
		values.put(AnswerDto.COLUMN_CHOICES_1, dto.getChoices1());
		values.put(AnswerDto.COLUMN_CHOICES_2, dto.getChoices2());
		values.put(AnswerDto.COLUMN_CHOICES_3, dto.getChoices3());
		values.put(AnswerDto.COLUMN_CHOICES_4, dto.getChoices4());
		values.put(AnswerDto.COLUMN_CHOICES_5, dto.getChoices5());
		values.put(AnswerDto.COLUMN_CHOICES_6, dto.getChoices6());
		values.put(AnswerDto.COLUMN_CHOICES_7, dto.getChoices7());
		values.put(AnswerDto.COLUMN_CHOICES_8, dto.getChoices8());
		values.put(AnswerDto.COLUMN_ANSWER, dto.getAnswer());
		// DBにレコードを追加する
		Long rowId = this.db.insertOrThrow(AnswerDto.TABLE_NAME, null, values);

		// 処理終了
		return rowId;
	}

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void update(AnswerDto dto) {
		//******************************************************************************************
		//* DBのレコードを更新する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(AnswerDto.COLUMN_RECORD_ID, dto.getRecordId());
		values.put(AnswerDto.COLUMN_QUESTION_ID, dto.getQuestionId());
		values.put(AnswerDto.COLUMN_QUESTION_NO, dto.getQuestionNo());
		values.put(AnswerDto.COLUMN_CHOICES_1, dto.getChoices1());
		values.put(AnswerDto.COLUMN_CHOICES_2, dto.getChoices2());
		values.put(AnswerDto.COLUMN_CHOICES_3, dto.getChoices3());
		values.put(AnswerDto.COLUMN_CHOICES_4, dto.getChoices4());
		values.put(AnswerDto.COLUMN_CHOICES_5, dto.getChoices5());
		values.put(AnswerDto.COLUMN_CHOICES_6, dto.getChoices6());
		values.put(AnswerDto.COLUMN_CHOICES_7, dto.getChoices7());
		values.put(AnswerDto.COLUMN_CHOICES_8, dto.getChoices8());
		values.put(AnswerDto.COLUMN_ANSWER, dto.getAnswer());
		// 抽出条件を生成する
		StringBuilder conditionBuilder = new StringBuilder();
		conditionBuilder.append(AnswerDto.COLUMN_RECORD_ID + "=?");
		conditionBuilder.append(" AND ");
		conditionBuilder.append(AnswerDto.COLUMN_QUESTION_ID + "=?");
		//*------------------------------------------------------------------------------------*
		//* DBのレコードを更新する
		//*------------------------------------------------------------------------------------*
 		this.db.update(
 			AnswerDto.TABLE_NAME, values, conditionBuilder.toString(),
 			new String[]{
 				  String.valueOf(dto.getRecordId())
 				, String.valueOf(dto.getQuestionId())
 			});

		// 処理終了
		return;
	}

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void delete(AnswerDto dto) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(AnswerDto.COLUMN_RECORD_ID , dto.getRecordId());
		conditionMap.put(AnswerDto.COLUMN_QUESTION_ID , dto.getQuestionId());
		// DBのレコードを削除する
		this.delete(conditionMap);
		// 処理終了
		return;
	}

	/**
	 * DBのレコードを削除します。
	 * @param conditionMap 抽出条件マップ
	 * @return なし
	 */
	public void delete(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		String whereStr = StringUtils.toWhereString(conditionMap); // 抽出条件文字列
		this.db.delete(AnswerDto.TABLE_NAME, whereStr, null);
		// 処理終了
		return;
	}

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<AnswerDto> selectList(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<AnswerDto> dtoList = new ArrayList<AnswerDto>(); // 抽出データリスト
		//*------------------------------------------------------------------------------------*
		//* 解答テーブル
		//*------------------------------------------------------------------------------------*
		// 抽出条件マップを生成する：[解答テーブル]
		Map<String, Object> narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					  AnswerDto.COLUMN_RECORD_ID   // 成績ID
					, AnswerDto.COLUMN_QUESTION_ID // 設問ID
				}
			);
		String whereStr = StringUtils.toWhereString(narrowCondMap); // 抽出条件文字列
		StringBuilder orderByBuilder = new StringBuilder(); // ソート順文字列
		orderByBuilder.append(AnswerDto.COLUMN_RECORD_ID + " ASC"); // 成績ID
		orderByBuilder.append(",");
		orderByBuilder.append(AnswerDto.COLUMN_QUESTION_NO + " ASC"); // 設問番号
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				AnswerDto.TABLE_NAME, null, whereStr, null, null, null,
 				orderByBuilder.toString());
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
	public AnswerDto selectWithJoin(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBから解答データを抽出する(結合テーブル含む)
		//******************************************************************************************
		AnswerDto answerDto = null; // 解答Dto
		// 解答テーブルのレコードを抽出する
		List<AnswerDto> answerDtoList = this.selectList(conditionMap);
		// レコードが存在しない場合は終了する
		if (answerDtoList.size() <= 0) {
			// 処理終了
			return answerDto;
		}
		// 先頭の1件を取得する(抽出条件が正しければ1件しか抽出されない)
		answerDto = answerDtoList.get(0);
		//*------------------------------------------------------------------------------------*
		//* 設問テーブル
		//*------------------------------------------------------------------------------------*
		// 設問テーブルのレコードを抽出する
		List<QuestionDto> questionDtoList = this.questionDao.selectList(conditionMap);
		if (questionDtoList.size() > 0) {
			// 設問Dtoを解答Dtoに設定する
			answerDto.getJoin().setQuestionDto(questionDtoList.get(0));
		}
		//*------------------------------------------------------------------------------------*
		//* 選択肢テーブル
		//*------------------------------------------------------------------------------------*
		// 選択肢テーブルのレコードを抽出する
		List<ChoicesDto> choicesDtoList = this.choicesDao.selectList(conditionMap);
		// 選択肢Dtoを解答Dtoに設定する
		answerDto.getJoin().setChoicesDtoList(choicesDtoList);

		// 処理終了
		return answerDto;
	}

///// protected method

	/**
	 * カーソル位置のレコードデータを取得します。
	 * @param cursor カーソルオブジェクト
	 * @return レコードデータ
	 */
	protected AnswerDto getRecord(Cursor cursor) {
		//**************************************************************************************
		//* カーソル位置のレコードデータを取得する
		//**************************************************************************************
		AnswerDto dto = new AnswerDto();
		dto.setRecordId(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_RECORD_ID)));
		dto.setQuestionId(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_QUESTION_ID)));
		dto.setQuestionNo(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_QUESTION_NO)));
		dto.setChoices1(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_1)));
		dto.setChoices2(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_2)));
		dto.setChoices3(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_3)));
		dto.setChoices4(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_4)));
		dto.setChoices5(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_5)));
		dto.setChoices6(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_6)));
		dto.setChoices7(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_7)));
		dto.setChoices8(cursor.getLong(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_CHOICES_8)));
		dto.setAnswer(cursor.getString(cursor.getColumnIndexOrThrow(AnswerDto.COLUMN_ANSWER)));

		// 処理終了
		return dto;
	}
}