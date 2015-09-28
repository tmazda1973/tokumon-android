package jp.thinkware.tokumon.app.model;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.SQLUtils;
import jp.thinkware.tokumon.app.dao.AnswerDao;
import jp.thinkware.tokumon.app.dao.AnswerSheetDao;
import jp.thinkware.tokumon.app.dao.ChoicesDao;
import jp.thinkware.tokumon.app.dao.QuestionDao;
import jp.thinkware.tokumon.app.dao.impl.AnswerDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.AnswerSheetDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.ChoicesDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.QuestionDaoImpl;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.dto.QuestionDto;
import android.app.Activity;
import android.util.Log;


/**
 * 問題画面のモデルクラスです。<br>
 * - MVCモデルのModel層の処理を行います。
 * @author thinkware
 */
public class QuestionModel {

// field

	/** 設問Daoクラス */
	private QuestionDao questionDao = null;
	/** 設問Daoクラス */
	private ChoicesDao choicesDao = null;
	/** 解答用紙Daoクラス */
	private AnswerSheetDao answerSheetDao = null;
	/** 解答Daoクラス */
	private AnswerDao answerDao = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public QuestionModel(Object obj) {
		//******************************************************************************
		//* クラス生成時の処理を行う
		//******************************************************************************
		Activity activity = (Activity)obj; // アクティビティクラス
		// Daoクラスを生成する
		this.questionDao = new QuestionDaoImpl(activity); // 設問Daoクラス
		this.choicesDao  = new ChoicesDaoImpl(activity);  // 選択肢Daoクラス
		this.answerDao  = new AnswerDaoImpl(activity);  // 解答Daoクラス
		this.answerSheetDao = new AnswerSheetDaoImpl(activity);  // 解答用紙Daoクラス
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

	public QuestionDto selectQuestion(Map<String, Object> conditionMap) {
		QuestionDto questionDto = null; // 解答Dto
		Map<String, Object> narrowCondMap = null; // 抽出条件マップ(絞込み用)
		//*------------------------------------------------------------------------*
		//* 設問テーブル
		//*------------------------------------------------------------------------*
		// 抽出条件マップを生成する：[設問テーブル]
		narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					QuestionDto.COLUMN_QUESTION_ID // 設問ID
				}
			);
		// 設問テーブルのレコードを抽出する
		List<QuestionDto> questionDtoList = this.questionDao.selectList(narrowCondMap);
		if (questionDtoList.size() > 0) {
			// 設問Dtoを解答Dtoに設定する
			questionDto = questionDtoList.get(0);
		}
		return questionDto;
	}

	public AnswerDto selectAnswer(Map<String, Object> conditionMap) {
		AnswerDto answerDto = null; // 設問Dto
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
						,AnswerDto.COLUMN_QUESTION_ID // 設問ID
				}
			);
		// 設問テーブルのレコードを抽出する
		List<AnswerDto> answerDtoList = this.answerDao.selectList(narrowCondMap);
		if (answerDtoList.size() > 0) {
			// 設問Dtoを解答Dtoに設定する
			answerDto = answerDtoList.get(0);
		}
		return answerDto;
	}

	public ChoicesDto[] selectChoices(Map<String, Object> conditionMap) {
		Map<String, Object> narrowCondMap = null; // 抽出条件マップ(絞込み用)
		//*------------------------------------------------------------------------*
		//* 設問テーブル
		//*------------------------------------------------------------------------*
		// 抽出条件マップを生成する：[設問テーブル]
		narrowCondMap =
			SQLUtils.narrowConditionMap(
				conditionMap,
				new String[] {
					QuestionDto.COLUMN_QUESTION_ID // 設問ID
				}
			);
		// 設問テーブルのレコードを抽出する
		List<ChoicesDto> choicesDtoList = this.choicesDao.selectList(narrowCondMap);


		ChoicesDto[] choicesDto = new ChoicesDto[choicesDtoList.size()]; // 解答Dto
		if (choicesDtoList.size() > 0) {
			for (int i = 0; i < choicesDtoList.size(); i++) {
				// 設問Dtoを解答Dtoに設定する
				choicesDto[i] = (ChoicesDto)choicesDtoList.get(i);
			}
		}
		return choicesDto;
	}


	/**
	 * 答えた問題を解答テーブルへ登録する
	 * @return
	 */
	public Boolean registAnswer(AnswerDto ansDto) {
		Boolean ok_flg = false;
		try {
			// 解答テーブルのレコードを抽出する
			this.answerDao.update(ansDto);
			//レコード更新に成功
			ok_flg = true;
		} catch (Exception e){
			Log.e("kaiden", "QuestionModel.java(182) 解答レコードの更新に失敗" + e.getMessage().toString());
		}
		return ok_flg;
	}

	/**
	 * 解答用紙レコードを更新します。
	 * @param updateDto 更新データ
	 * @return なし
	 */
	public void updateAnswerSheet(AnswerSheetDto updateDto) {
		//******************************************************************************
		//* 解答用紙レコードを更新する
		//******************************************************************************
		this.answerSheetDao.update(updateDto);
		// 処理終了
		return;
	}
}
