package jp.thinkware.tokumon.app.model;

import java.util.Map;

import jp.thinkware.tokumon.app.dao.AnswerSheetDao;
import jp.thinkware.tokumon.app.dao.impl.AnswerSheetDaoImpl;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import android.app.Activity;

/**
 * 解答結果画面のモデルクラスです。<br>
 * - MVCモデルのModel層の処理を行います。
 * @author thinkware
 */
public class AnswerResultModel {

// field

	/** 解答用紙DAOクラス */
	private AnswerSheetDao answerSheetDao = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerResultModel(Object obj) {
		//******************************************************************************
		//* クラス生成時の初期処理を行う
		//******************************************************************************
		Activity activity = (Activity)obj; // アクティビティクラス
		// DAOクラスを生成する
		this.answerSheetDao = new AnswerSheetDaoImpl(activity); // 解答用紙DAOクラス

		// 処理終了
		return;
	}

	/**
	 * DBから解答用紙データを結合テーブルも含めて抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return 解答用紙データ
	 */
	public AnswerSheetDto selectWithJoin(Map<String, Object> conditionMap) {
		// DBから解答用紙データを抽出する(結合テーブル含む)
		return this.answerSheetDao.selectWithJoin(conditionMap);
	}
}