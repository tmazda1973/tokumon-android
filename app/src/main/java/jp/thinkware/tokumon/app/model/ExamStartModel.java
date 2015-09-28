package jp.thinkware.tokumon.app.model;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.ListUtils;
import jp.thinkware.tokumon.app.dao.AnswerDao;
import jp.thinkware.tokumon.app.dao.AnswerSheetDao;
import jp.thinkware.tokumon.app.dao.CourseDao;
import jp.thinkware.tokumon.app.dao.QuestionDao;
import jp.thinkware.tokumon.app.dao.impl.AnswerDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.AnswerSheetDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.CourseDaoImpl;
import jp.thinkware.tokumon.app.dao.impl.QuestionDaoImpl;
import jp.thinkware.tokumon.app.dto.AnswerDto;
import jp.thinkware.tokumon.app.dto.AnswerSheetDto;
import jp.thinkware.tokumon.app.dto.ChoicesDto;
import jp.thinkware.tokumon.app.dto.CourseDto;
import jp.thinkware.tokumon.app.dto.QuestionDto;
import jp.thinkware.tokumon.app.helper.db.DatabaseHelper;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

/**
 * 試験開始画面のモデルクラスです。<br>
 * - MVCモデルのModel層の処理を行います。
 * @author thinkware
 */
public class ExamStartModel {

// field

	/** コース情報DAOクラス */
	private CourseDao courseDao = null;
	/** 設問情報DAOクラス */
	private QuestionDao questionDao = null;
	/** 解答用紙情報DAOクラス */
	private AnswerSheetDao answerSheetDao = null;
	/** 解答DAOクラス */
	private AnswerDao answerDao = null;

	/** DB制御オブジェクト */
	private SQLiteDatabase db = null;

	/** アクティビティオブジェクト */
	private Activity activity = null;

// method

	/**
	 * コンストラクタ
	 * @param obj 解答ポップアップ画面のアクティビティクラス
	 */
	public ExamStartModel(Object obj) {
		//******************************************************************************
		//* クラス生成時の初期処理を行う
		//******************************************************************************
		this.activity = (Activity)obj; // アクティビティオブジェクト
		// DB制御オブジェクトのインスタンスを取得する
		this.db = DatabaseHelper.getInstance(this.activity).getWritableDatabase();
		// DAOクラスを生成する
		this.courseDao      = new CourseDaoImpl(this.activity);      // コース情報DAOクラス
		this.questionDao    = new QuestionDaoImpl(this.activity);    // 設問情報DAOクラス
		this.answerSheetDao = new AnswerSheetDaoImpl(this.activity); // 解答用紙情報DAOクラス
		this.answerDao      = new AnswerDaoImpl(this.activity);      // 解答情報DAOクラス

		// 処理終了
		return;
	}

	/**
	 * DBからコース情報を抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return コース情報データ
	 */
	public CourseDto selectCourseInfo(Map<String, Object> conditionMap) {
		//******************************************************************************
		//* DBからコース情報を抽出する
		//******************************************************************************
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
	 * 試験情報をDBに登録します。
	 * @param conditionMap 抽出条件マップ
	 * @return  登録した試験情報の成績ID
	 */
	public Long insertExamInfo(Map<String, Object> conditionMap) {
		//******************************************************************************
		//* 試験情報をDBに登録する
		//******************************************************************************
		Long recordId = null; // 成績ID
		/***** トランザクションを開始する *****/
		this.db.beginTransaction();
		try {
			//*--------------------------------------------------------------------*
			//* 解答用紙情報
			//*--------------------------------------------------------------------*
			// 解答用紙情報を登録する
			AnswerSheetDto answerSheetDto =
				this.createInsertAnswerSheetDto(conditionMap); // 解答用紙DTO(登録データ)
			answerSheetDto = this.insertAnswerSheet(answerSheetDto);
			//*--------------------------------------------------------------------*
			//* 解答情報
			//*--------------------------------------------------------------------*
			// 解答情報を登録する
			List<AnswerDto> answerDtoList = this.createInsertAnswerDtoList(answerSheetDto); // 解答DTOリスト(登録データ)
			this.insertAnswerList(answerDtoList);

			/***** トランザクションをコミットする *****/
			this.db.setTransactionSuccessful();
			// 登録した試験情報の成績IDを設定する
			recordId = answerSheetDto.getRecordId();
		}
		// 後処理
		finally {
			/***** トランザクションを終了する *****/
			this.db.endTransaction();
		}

		// 処理終了
		return recordId;
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

// private method

	/**
	 * 登録用の解答用紙DTOを生成します。
	 * @param conditionMap 抽出条件マップ
	 * @return 解答用紙DTO
	 */
	private AnswerSheetDto createInsertAnswerSheetDto(Map<String, Object> conditionMap) {
		//******************************************************************************
		//* 登録用の解答用紙DTOを生成する
		//******************************************************************************
		AnswerSheetDto answerSheetDto = new AnswerSheetDto(); // 解答用紙DTO
		Long userId = (Long)conditionMap.get(AnswerSheetDto.COLUMN_USER_ID); // ユーザID
		// 解答用紙情報の登録に必要なデータを取得する
		CourseDto courseDto = this.selectCourseInfo(conditionMap); // コース情報
		/***** 項目値を設定する *****/
		answerSheetDto.setUserId(userId); // ユーザID
		answerSheetDto.setCourseId(courseDto.getCourseId()); // コースID
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
		answerSheetDto.setExamDatetime(sdf.format(Calendar.getInstance().getTime())); // 受験日時
		answerSheetDto.setTimeLimit(courseDto.getExamTime()); // 制限時間
		answerSheetDto.setCurrentQuestion((long)1); // 最後に参照していた設問
		answerSheetDto.setScore((long)0); // 点数
		answerSheetDto.setQuestionCount(courseDto.getQuestionCount()); // 設問数
		answerSheetDto.setAnswerCount((long)0); // 解答数
		answerSheetDto.setCorrectCount((long)0); // 正解数
		answerSheetDto.setStatus(AnswerSheetDto.STATUS_STANDBY); // 状態：[未実施]

		// 処理終了
		return answerSheetDto;
	}

	/**
	 * 登録用の解答DTOを生成します。
	 * @param answerSheetDto 解答用紙DTO
	 * @return 解答DTOリスト
	 */
	private List<AnswerDto> createInsertAnswerDtoList(AnswerSheetDto answerSheetDto) {
		//******************************************************************************
		//* 登録用の解答DTOを生成する
		//******************************************************************************
		List<AnswerDto> answerDtoList = new ArrayList<AnswerDto>(); // 解答DTOリスト
		// 解答情報の登録に必要なデータを取得する
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put(AnswerDto.COLUMN_RECORD_ID, answerSheetDto.getRecordId()); // 成績ID
		List<QuestionDto> questionDtoList =
			this.selectQuestionList(conditionMap, answerSheetDto.getQuestionCount()); // 設問DTOリスト
		/***** 解答情報を生成する *****/
		long questionNo = 0; // 設問番号
		// 設問DTOの件数分ループする
		for (QuestionDto questionDto : questionDtoList) {
			// 設問番号が設問数以上である場合
			if (questionNo >= answerSheetDto.getQuestionCount()) {
				// ループ終了
				break;
			}
			//*--------------------------------------------------------------------*
			//* 解答DTOを生成する
			//*--------------------------------------------------------------------*
			AnswerDto answerDto = new AnswerDto(); // 解答DTO
			/***** 項目値を設定する *****/
			answerDto.setRecordId(answerSheetDto.getRecordId());  // レコードID
			answerDto.setQuestionId(questionDto.getQuestionId()); // 設問ID
			answerDto.setQuestionNo(++questionNo); // 設問番号
			List<ChoicesDto> choicesDtoList =
				new ArrayList<ChoicesDto>(questionDto.getJoin().getChoicesDtoList()); // 選択肢DTOリスト
			// 選択肢DTOリストをランダムに並び替える
			choicesDtoList = ListUtils.randomOrder(choicesDtoList);
			// 選択肢DTOの件数分ループする
			for (int i = 0; i < choicesDtoList.size(); i++) {
				//******************************************************************
				//* リフレクションでメソッドを呼び出して項目値を設定する
				//******************************************************************
				// 選択肢の項目値を設定する（リフレクションを使用）
				try {
					ChoicesDto choicesDto = choicesDtoList.get(i); // 選択肢Dto
					String methodName = "setChoices" + (i + 1); // メソッド名
					Method method =
						answerDto.getClass().getDeclaredMethod(methodName, new Class[]{Long.class});
					method.setAccessible(true);
					// 選択肢IDを設定する
					method.invoke(answerDto, new Object[]{choicesDto.getChoicesId()});
				}
				// 例外発生：[一般例外]
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 解答DTOをリストに追加する
			answerDtoList.add(answerDto);
		}

		// 処理終了
		return answerDtoList;
	}

	/**
	 * DBから設問情報を抽出します。(結合テーブル含む)
	 * @param conditionMap 抽出条件マップ
	 * @param questionCount 設問数
	 * @return 抽出データリスト
	 */
	private List<QuestionDto> selectQuestionList(
			Map<String, Object> conditionMap, long questionCount) {
		//******************************************************************************
		//* DBから設問情報を抽出する
		//******************************************************************************
		List<QuestionDto> selectDtoList = new ArrayList<QuestionDto>(); // 抽出データリスト
		Map<String, Object> conditionJoinMap = new HashMap<String, Object>(); // 抽出条件マップ(結合テーブル)
		//*------------------------------------------------------------------------*
		//* 結合テーブルを含めてレコードを抽出する
		//*------------------------------------------------------------------------*
		// 設問情報を取得してランダムにソートする
		List<QuestionDto> questionList = this.questionDao.selectList(conditionMap, questionCount);
		questionList = ListUtils.randomOrder(questionList);
		// 設問情報レコードの件数分ループする
		for (QuestionDto dto : questionList) {
			// 抽出条件をマップに設定する
			conditionJoinMap.put(QuestionDto.COLUMN_QUESTION_ID, dto.getQuestionId()); // 設問ID
			// 結合テーブルを含めてレコードを抽出する
			QuestionDto joinDto = this.questionDao.selectWithJoin(conditionJoinMap);
			// 抽出データリストにレコードを追加する
			selectDtoList.add(joinDto);
		}

		// 処理終了
		return selectDtoList;
	}

	/**
	 * 解答用紙レコードをDBに登録します。
	 * @param insertDto 登録対象データ
	 * @return 登録データ
	 */
	private AnswerSheetDto insertAnswerSheet(AnswerSheetDto insertDto) {
		//******************************************************************************
		//* 解答用紙レコードを登録する
		//******************************************************************************
		Long rowId = this.answerSheetDao.insert(insertDto);
		AnswerSheetDto dto = this.answerSheetDao.selectRow(rowId);
		// 処理終了
		return dto;
	}

	/**
	 * 解答情報レコードをDBに登録します。
	 * @param insertDtoList 登録対象データリスト
	 * @return なし
	 */
	private void insertAnswerList(List<AnswerDto> insertDtoList) {
		//******************************************************************************
		//* 解答情報レコードを登録する
		//******************************************************************************
		// 解答情報レコードの件数分ループする
		for (AnswerDto dto : insertDtoList) {
			// 解答情報レコードを登録する
			this.answerDao.insert(dto);
		}
		// 処理終了
		return;
	}
}