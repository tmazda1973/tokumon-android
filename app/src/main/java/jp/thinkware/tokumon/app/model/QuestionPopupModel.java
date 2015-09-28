package jp.thinkware.tokumon.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.SQLUtils;
import jp.thinkware.tokumon.app.dao.AnswerDao;
import jp.thinkware.tokumon.app.dao.QuestionDao;
import jp.thinkware.tokumon.app.dao.impl.AnswerDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.QuestionDaoImpl;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.QuestionDto;
import android.app.Activity;


/**
 * 問題一覧ポップアップ画面のモデルクラスです。<br>
 * - MVCモデルのModel層の処理を行います。
 * @author thinkware
 */
public class QuestionPopupModel {

// field

	/** 設問Daoクラス */
	private QuestionDao questionDao = null;
	/** 解答Daoクラス */
	private AnswerDao answerDao = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 問題一覧ポップアップ画面のアクティビティクラス
	 */
	public QuestionPopupModel(Object obj) {
		//******************************************************************************
		//* クラス生成時の処理を行う
		//******************************************************************************
		Activity activity = (Activity)obj; // アクティビティクラス
		// Daoクラスを生成する
		this.questionDao = new QuestionDaoImpl(activity); // 設問Daoクラス
		this.answerDao  = new AnswerDaoImpl(activity);  // 解答Daoクラス
		// 処理終了
		return;
	}

	public AnswerDto[] selectAnswer(Map<String, Object> conditionMap) {

		Map<String, Object> narrowCondMap = null; // 抽出条件マップ(絞込み用)
		//*------------------------------------------------------------------------*
		//* 設問テーブル
		//*------------------------------------------------------------------------*
		// 抽出条件マップを生成する：[設問テーブル]
		narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
						AnswerDto.COLUMN_RECORD_ID // レコードID
				}
			);
		// 解答テーブルのレコードを抽出する
		List<AnswerDto> answerDtoList = this.answerDao.selectList(narrowCondMap);
		// 設問Dto
		AnswerDto[] answerDto = new AnswerDto[answerDtoList.size()];

		if (answerDtoList.size() > 0) {
			for (int i = 0; i < answerDtoList.size(); i++) {
				narrowCondMap.clear();

				// 抽出条件を生成する
				Map<String, Object> question_conditionMap = new HashMap<String, Object>(); // 抽出条件マップ
				/***** 問題をDBから取得する *****/
				// 抽出条件を生成する
				question_conditionMap.put(QuestionDto.COLUMN_QUESTION_ID, String.valueOf(answerDtoList.get(i).getQuestionId()));// 設問ID

				// 抽出条件マップを生成する：[設問テーブル]
				narrowCondMap =
					SQLUtils.narrowConditionMap(
						question_conditionMap,
						new String[] {
							QuestionDto.COLUMN_QUESTION_ID // レコードID
						}
					);
				// 設問テーブルのレコードを抽出する
				List<QuestionDto> questionDtoList = this.questionDao.selectList(narrowCondMap);
				// 設問Dto
				AnswerDto single_answerDto = null;
				//解答データセット
				single_answerDto = answerDtoList.get(i);
				//設問データセット
				single_answerDto.getJoin().setQuestionDto(questionDtoList.get(0));

				// 設問Dtoを解答Dtoに設定する
				answerDto[i] = single_answerDto;
			}
		}


		return answerDto;
	}
}
