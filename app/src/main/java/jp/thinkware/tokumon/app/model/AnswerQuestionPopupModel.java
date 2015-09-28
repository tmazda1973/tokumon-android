package jp.thinkware.tokumon.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dao.AnswerDao;
import jp.thinkware.tokumon.app.dao.AnswerSheetDao;
import jp.thinkware.tokumon.app.dao.impl.AnswerDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.AnswerSheetDaoImpl;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import android.app.Activity;

/**
 * 解答問題ポップアップ画面のモデルクラスです。<br>
 * - MVCモデルのModel層の処理を行います。
 * @author thinkware
 */
public class AnswerQuestionPopupModel {

// field

	/** 解答用紙DAOクラス */
	private AnswerSheetDao answerSheetDao = null;
	/** 解答DAOクラス */
	private AnswerDao answerDao = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerQuestionPopupModel(Object obj) {
		//******************************************************************************
		//* クラス生成時の初期処理を行う
		//******************************************************************************
		Activity activity = (Activity)obj; // アクティビティクラス
		// DAOクラスのインスタンスを生成する
		this.answerSheetDao = new AnswerSheetDaoImpl(activity); // 解答用紙DAOクラス
		this.answerDao = new AnswerDaoImpl(activity); // 解答DAOクラス

		// 処理終了
		return;
	}

	/**
	 * DBから解答用紙データを結合テーブルも含めて抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return 解答用紙データ
	 */
	public AnswerSheetDto selectAnswerSheetWithJoin(Map<String, Object> conditionMap) {
		//******************************************************************************
		//* DBから解答用紙データを抽出する
		//******************************************************************************
		AnswerSheetDto answerSheetDto = null; // 解答用紙データ
		// DBから解答用紙データを抽出する
		List<AnswerSheetDto> answerSheetDtoList = this.answerSheetDao.selectList(conditionMap);
		// 解答用紙データが存在する場合
		if (!answerSheetDtoList.isEmpty()) {
			// 先頭の1件を取得する(1件しか存在しないはず)
			answerSheetDto = answerSheetDtoList.get(0);
			/***** DBから解答データを抽出する *****/
			List<AnswerDto> answerDtoList = new ArrayList<AnswerDto>(); // 解答DTOリスト
			AnswerDto answerDto = this.answerDao.selectWithJoin(conditionMap);
			// 解答データをリストに追加する
			answerDtoList.add(answerDto);
			// 解答データを解答テーブルに結合する
			answerSheetDto.getJoin().setAnswerDtoList(answerDtoList);
		}

		// 処理終了
		return answerSheetDto;
	}
}