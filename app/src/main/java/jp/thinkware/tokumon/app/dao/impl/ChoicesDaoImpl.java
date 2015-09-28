package jp.thinkware.tokumon.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.SQLUtils;
import jp.thinkware.tokumon.app.common.util.StringUtils;
import jp.thinkware.tokumon.app.dao.ChoicesDao;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * DBレコードのDAO実装クラスです。(選択肢テーブル)
 * @author thinkware
 */
public class ChoicesDaoImpl implements ChoicesDao {

///// field

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

///// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	public ChoicesDaoImpl(Context context) {
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(context).getWritableDatabase();
	}

	/**
	 * DBにレコードを追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(ChoicesDto dto) {
		//******************************************************************************************
		//* DBにレコードを追加する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(ChoicesDto.COLUMN_QUESTION_ID, dto.getQuestionId());
		values.put(ChoicesDto.COLUMN_CHOICES_ID, dto.getChoicesId());
		values.put(ChoicesDto.COLUMN_CONTENT, dto.getContent());
		values.put(ChoicesDto.COLUMN_CORRECT_FLAG, dto.getCorrectFlag());
		// DBにレコードを追加する
		Long rowId = this.db.insertOrThrow(ChoicesDto.TABLE_NAME, null, values);

		// 処理終了
		return rowId;
	}

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 */
	public void update(ChoicesDto dto) {
		//******************************************************************************************
		//* DBのレコードを更新する
		//******************************************************************************************
		// レコードの項目値を設定する
		ContentValues values = new ContentValues();
		values.put(ChoicesDto.COLUMN_QUESTION_ID, dto.getQuestionId());
		values.put(ChoicesDto.COLUMN_CHOICES_ID, dto.getChoicesId());
		values.put(ChoicesDto.COLUMN_CONTENT, dto.getContent());
		values.put(ChoicesDto.COLUMN_CORRECT_FLAG, dto.getCorrectFlag());
		// 抽出条件を生成する
		StringBuilder conditionBuilder = new StringBuilder();
		conditionBuilder.append(ChoicesDto.COLUMN_QUESTION_ID);
		conditionBuilder.append("=?");
		conditionBuilder.append(",");
		conditionBuilder.append(ChoicesDto.COLUMN_CHOICES_ID);
		conditionBuilder.append("=?");
		//*------------------------------------------------------------------------------------*
		//* DBのレコードを更新する
		//*------------------------------------------------------------------------------------*
 		this.db.update(
 			ChoicesDto.TABLE_NAME, values, conditionBuilder.toString(),
 			new String[]{
 				  String.valueOf(dto.getQuestionId()) // 設問ID
 				, String.valueOf(dto.getChoicesId())  // 選択肢ID
 			});
	}

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void delete(ChoicesDto dto) {
		//******************************************************************************************
		//* DBのレコードを削除する
		//******************************************************************************************
		Map<String, Object> conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
		conditionMap.put(ChoicesDto.COLUMN_QUESTION_ID , dto.getQuestionId());
		conditionMap.put(ChoicesDto.COLUMN_CHOICES_ID , dto.getChoicesId());
		// DBのレコードを削除する
		this.delete(conditionMap);
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
		this.db.delete(ChoicesDto.TABLE_NAME, whereStr, null);
	}

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<ChoicesDto> selectList(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBのレコードを抽出する
		//******************************************************************************************
		List<ChoicesDto> dtoList = new ArrayList<ChoicesDto>(); // 抽出データリスト
		// 抽出条件マップを生成する：[設問テーブル]
		Map<String, Object> narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					ChoicesDto.COLUMN_QUESTION_ID // 設問ID
				}
			);
		String whereStr = StringUtils.toWhereString(narrowCondMap); // 抽出条件文字列
		StringBuilder orderbyBuilder = new StringBuilder(); // ソート順文字列
		orderbyBuilder.append(ChoicesDto.COLUMN_QUESTION_ID);
		orderbyBuilder.append(" ASC");
		orderbyBuilder.append(",");
		orderbyBuilder.append(ChoicesDto.COLUMN_CHOICES_ID);
		orderbyBuilder.append(" ASC");
		// DBのレコードを抽出する
		Cursor cursor =
 			this.db.query(
 				ChoicesDto.TABLE_NAME, null, whereStr, null, null, null,
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
	protected ChoicesDto getRecord(Cursor cursor) {
		//******************************************************************************************
		//* カーソル位置のレコードデータを取得する
		//******************************************************************************************
		ChoicesDto dto = new ChoicesDto();
		dto.setQuestionId(cursor.getLong(cursor.getColumnIndexOrThrow(ChoicesDto.COLUMN_QUESTION_ID)));   // 設問ID
		dto.setChoicesId(cursor.getLong(cursor.getColumnIndexOrThrow(ChoicesDto.COLUMN_CHOICES_ID)));     // 選択肢ID
		dto.setContent(cursor.getString(cursor.getColumnIndexOrThrow(ChoicesDto.COLUMN_CONTENT)));        // 内容
		dto.setCorrectFlag(cursor.getLong(cursor.getColumnIndexOrThrow(ChoicesDto.COLUMN_CORRECT_FLAG))); // 正解フラグ

		// 処理終了
		return dto;
	}
}