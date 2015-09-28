package jp.thinkware.tokumon.app.model;

import java.util.Map;

import jp.thinkware.tokumon.app.dao.AnswerDao;
import jp.thinkware.tokumon.app.dao.impl.AnswerDaoImpl;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import android.app.Activity;

/**
 * 解答ポップアップ画面のモデルクラスです。<br>
 * - MVCモデルのModel層の処理を行います。
 * @author thinkware
 */
public class AnswerPopupModel {

// field

	/** 解答DAOクラス */
	private AnswerDao answerDao = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerPopupModel(Object obj) {
		//******************************************************************************************
		//* クラス生成時の初期処理を行う
		//******************************************************************************************
		Activity activity = (Activity)obj; // アクティビティクラス
		// DAOクラスのインスタンスを生成する
		this.answerDao = new AnswerDaoImpl(activity); // 解答DAOクラス

		// 処理終了
		return;
	}

	/**
	 * DBから解答データを結合テーブルも含めて抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return 解答データ
	 */
	public AnswerDto selectWithJoin(Map<String, Object> conditionMap) {
		// DBから解答データを抽出する(結合テーブル含む)
		return this.answerDao.selectWithJoin(conditionMap);
	}
}