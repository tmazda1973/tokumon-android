package jp.thinkware.tokumon.app.model;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dao.AnswerSheetDao;
import jp.thinkware.tokumon.app.dao.CourseDao;
import jp.thinkware.tokumon.app.dao.impl.AnswerSheetDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.CourseDaoImpl;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.CourseDto;
import android.app.Activity;

/**
 * 解答終了画面のモデルクラスです。<br>
 * - MVCモデルのModel層の処理を行います。
 * @author thinkware
 */
public class AnswerEndModel {

// field

	/** コース情報DAOクラス */
	private CourseDao courseDao = null;
	/** 解答用紙情報DAOクラス */
	private AnswerSheetDao answerSheetDao = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public AnswerEndModel(Object obj) {
		//******************************************************************************************
		//* クラス生成時の初期処理を行う
		//******************************************************************************************
		Activity activity = (Activity)obj; // アクティビティクラス
		// DAOクラスを生成する
		this.courseDao      = new CourseDaoImpl(activity);      // コース情報DAOクラス
		this.answerSheetDao = new AnswerSheetDaoImpl(activity); // 解答用紙情報DAOクラス

		// 処理終了
		return;
	}

	/**
	 * DBからコース情報を抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return コース情報データ
	 */
	public CourseDto selectCourseInfo(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* DBからコース情報を抽出する
		//******************************************************************************************
		CourseDto courseDto = null; // コース情報DTO
		/***** DBからコース情報を抽出する *****/
		List<CourseDto> courseDtoList = this.courseDao.selectList(conditionMap);
		// コース情報が存在する場合
		if (!courseDtoList.isEmpty()) {
			// 先頭の1件を取得する(1件のみしか抽出していないはず)
			courseDto = courseDtoList.get(0);
		}
		// 処理終了
		return courseDto;
	}

	/**
	 * 解答用紙レコードを更新します。
	 * @param updateDto 更新データ
	 * @return なし
	 */
	public void updateAnswerSheet(AnswerSheetDto updateDto) {
		//******************************************************************************************
		//* 解答用紙レコードを更新する
		//******************************************************************************************
		this.answerSheetDao.update(updateDto);
		// 処理終了
		return;
	}
}