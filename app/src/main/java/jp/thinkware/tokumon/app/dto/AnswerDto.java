package jp.thinkware.tokumon.app.dto;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.common.util.StringUtils;

/**
 * DBレコードのDTOクラスです。(解答テーブル)<br />
 * ・受験するコース、問題の情報を格納します。
 * ・受験を開始する際に、course、questionから出題する問題を抽出し、本テーブルにセットします。
 * @author thinkware
 */
public class AnswerDto implements Serializable {

	private static final long serialVersionUID = 1L;

///// const

	//**********************************************************************************************
	//* 定数
	//**********************************************************************************************
	/** テーブル名 */
	public static final String TABLE_NAME = "answer";

	/** カラム名：成績ID */
	public static final String COLUMN_RECORD_ID = "record_id";
	/** カラム名：設問ID */
	public static final String COLUMN_QUESTION_ID = "question_id";
	/** カラム名：設問番号 */
	public static final String COLUMN_QUESTION_NO = "question_no";
	/** カラム名：選択肢1 */
	public static final String COLUMN_CHOICES_1 = "choices_1";
	/** カラム名：選択肢2 */
	public static final String COLUMN_CHOICES_2 = "choices_2";
	/** カラム名：選択肢3 */
	public static final String COLUMN_CHOICES_3 = "choices_3";
	/** カラム名：選択肢4 */
	public static final String COLUMN_CHOICES_4 = "choices_4";
	/** カラム名：選択肢5 */
	public static final String COLUMN_CHOICES_5 = "choices_5";
	/** カラム名：選択肢6 */
	public static final String COLUMN_CHOICES_6 = "choices_6";
	/** カラム名：選択肢7 */
	public static final String COLUMN_CHOICES_7 = "choices_7";
	/** カラム名：選択肢8 */
	public static final String COLUMN_CHOICES_8 = "choices_8";
	/** カラム名：解答 */
	public static final String COLUMN_ANSWER = "answer";

///// field

	/** 項目値：成績ID */
	private Long _record_id = null;
	/** 項目値：設問ID */
	private Long _question_id = null;
	/** 項目値：設問番号 */
	private Long _question_no = null;
	/** 項目値：選択肢1 */
	private Long _choices_1 = null;
	/** 項目値：選択肢2 */
	private Long _choices_2 = null;
	/** 項目値：選択肢3 */
	private Long _choices_3 = null;
	/** 項目値：選択肢4 */
	private Long _choices_4 = null;
	/** 項目値：選択肢5 */
	private Long _choices_5 = null;
	/** 項目値：選択肢6 */
	private Long _choices_6 = null;
	/** 項目値：選択肢7 */
	private Long _choices_7 = null;
	/** 項目値：選択肢8 */
	private Long _choices_8 = null;
	/** 項目値：解答 */
	private String _answer = null;

	/** 結合テーブル処理内部クラスのインスタンス */
	private AnswerDto.Join join = null;

	/** 選択肢情報マップ(KEY：[選択肢番号]) - ソート済 */
	Map<Long, ChoicesDto> sortedChoicesInfoMap = null;

///// accessor

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[成績ID]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 成績IDを取得します。
	 * @return 成績ID
	 */
	public Long getRecordId() {
		return this._record_id;
	}

	/**
	 * 成績IDを設定します。
	 * @param record_id 成績ID
	 */
	public void setRecordId(Long record_id) {
		this._record_id = record_id;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[設問ID]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 設問IDを取得します。
	 * @return 設問ID
	 */
	public Long getQuestionId() {
		return this._question_id;
	}

	/**
	 * 設問IDを設定します。
	 * @param question_id 設問ID
	 */
	public void setQuestionId(Long question_id) {
		this._question_id = question_id;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[設問番号]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 設問番号を取得します。
	 * @return 設問番号
	 */
	public Long getQuestionNo() {
		return this._question_no;
	}

	/**
	 * 設問番号を設定します。
	 * @param question_no 設問番号
	 */
	public void setQuestionNo(Long question_no) {
		this._question_no = question_no;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢1]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢1を取得します。
	 * @return _choices_1 選択肢1
	 */
	public Long getChoices1() {
		return this._choices_1;
	}

	/**
	 * 選択肢1を設定します。
	 * @param choices_1 選択肢1
	 */
	public void setChoices1(Long choices_1) {
		this._choices_1 = choices_1;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢2]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢2を取得します。
	 * @return 選択肢2
	 */
	public Long getChoices2() {
		return this._choices_2;
	}

	/**
	 * 選択肢2を設定します。
	 * @param choices_2 選択肢2
	 */
	public void setChoices2(Long choices_2) {
		this._choices_2 = choices_2;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢3]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢3を取得します。
	 * @return 選択肢3
	 */
	public Long getChoices3() {
		return this._choices_3;
	}

	/**
	 * 選択肢3を設定します。
	 * @param choices_3 選択肢3
	 */
	public void setChoices3(Long choices_3) {
		this._choices_3 = choices_3;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢4]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢4を取得します。
	 * @return 選択肢4
	 */
	public Long getChoices4() {
		return this._choices_4;
	}

	/**
	 * 選択肢4を設定します。
	 * @param choices_4 選択肢4
	 */
	public void setChoices4(Long choices_4) {
		this._choices_4 = choices_4;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢5]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢5を取得します。
	 * @return 選択肢5
	 */
	public Long getChoices5() {
		return this._choices_5;
	}

	/**
	 * 選択肢5を設定します。
	 * @param choices_5 選択肢5
	 */
	public void setChoices5(Long choices_5) {
		this._choices_5 = choices_5;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢6]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢6を取得します。
	 * @return 選択肢6
	 */
	public Long getChoices6() {
		return this._choices_6;
	}

	/**
	 * 選択肢6を設定します。
	 * @param choices_6 選択肢6
	 */
	public void setChoices6(Long choices_6) {
		this._choices_6 = choices_6;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢7]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢7を取得します。
	 * @return 選択肢7
	 */
	public Long getChoices7() {
		return this._choices_7;
	}

	/**
	 * 選択肢7を設定します。
	 * @param choices_7 選択肢7
	 */
	public void setChoices7(Long choices_7) {
		this._choices_7 = choices_7;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢8]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢8を取得します。
	 * @return 選択肢8
	 */
	public Long getChoices8() {
		return this._choices_8;
	}

	/**
	 * 選択肢8を設定します。
	 * @param choices_8 選択肢8
	 */
	public void setChoices8(Long choices_8) {
		this._choices_8 = choices_8;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[解答]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 解答を取得します。
	 * @return 解答
	 */
	public String getAnswer() {
		return this._answer;
	}

	/**
	 * 解答を設定します。
	 * @param answer 解答
	 */
	public void setAnswer(String answer) {
		this._answer = answer;
	}

	//*----------------------------------------------------------------------------------------*
	//* 結合テーブル
	//*----------------------------------------------------------------------------------------*
	/**
	 * 結合テーブル処理内部クラスのインスタンスを取得します。
	 * @return join 結合テーブル処理内部クラスのインスタンス
	 */
	 public AnswerDto.Join getJoin() {
		// インスタンスが生成されていない場合は生成する
		if (this.join == null) {
			this.join = new AnswerDto().new Join();
		}
		// 処理終了
	 	return this.join;
	 }

	//*----------------------------------------------------------------------------------------*
	//* ソート済の選択肢リスト
	//*----------------------------------------------------------------------------------------*
	/**
	 * ソート済の選択肢リストを取得します。
	 * @return ソート済の選択肢リスト
	 */
	public List<ChoicesDto> getSortedChoicesList() {
		List<ChoicesDto> choicesList =
			new ArrayList<ChoicesDto>(this.getSortedChoicesInfoMap().values());
		// 処理終了
		return choicesList;
	}

///// method

	 /**
	  * 解答テーブルの選択肢順にソートされた選択肢情報マップを取得します。
	  * @return 選択肢情報マップ(KEY [選択肢番号])
	  */
	 public Map<Long, ChoicesDto> getSortedChoicesInfoMap() {
		//******************************************************************************************
		//* 解答テーブルの選択肢順にソートされた選択肢情報マップを取得する
		//******************************************************************************************
		// 選択肢情報マップが既に生成されている場合
		if (this.sortedChoicesInfoMap != null && !this.sortedChoicesInfoMap.isEmpty()) {
			// 処理終了
			return this.sortedChoicesInfoMap;
		}
		// 選択肢情報マップを生成する
		this.sortedChoicesInfoMap = new LinkedHashMap<Long, ChoicesDto>();
		// 選択肢IDをキーにした選択肢情報マップを生成する
		Map<Long, ChoicesDto> choicesInfoMap = new LinkedHashMap<Long, ChoicesDto>();
		// 選択肢情報の件数分ループする
		for (ChoicesDto dto : this.getJoin().getChoicesDtoList()) {
			// 選択肢IDをキーにして選択肢情報をマップに登録する
			choicesInfoMap.put(dto.getChoicesId(), dto);
		}
		/***** 選択肢情報をマップに登録する *****/
		Long choiceCount = this.getJoin().getQuestionDto().getChoices(); // 選択肢数
		// 選択肢数の件数分ループする
		for (int i = 0; i < choiceCount; i++) {
			//*--------------------------------------------------------------------------------*
			//* リフレクションでメソッドを呼び出して項目値を取得する
			//*--------------------------------------------------------------------------------*
			try {
				Long choicesNo = (long)(i + 1); // 選択肢番号
				String methodName = "getChoices" + choicesNo; // メソッド名
				Method method = this.getClass().getDeclaredMethod(methodName);
				method.setAccessible(true); // メソッドアクセス可能
				// 選択肢IDを設定する
				Long choicesId = (Long)method.invoke(this);
				// 選択肢IDが選択肢情報マップのキー値である場合
				if (choicesInfoMap.keySet().contains(choicesId)) {
					// マップから選択肢情報を取得してリストに追加する
					this.sortedChoicesInfoMap.put(choicesNo, choicesInfoMap.get(choicesId));
				}
			}
			// 例外発生：[一般例外]
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		 // 処理終了
		 return this.sortedChoicesInfoMap;
	 }

	/**
	 * 解答が正解であるかを判定します。
	 * @return true 正解である, false 正解ではない
	 */
	public boolean isCorrect() {
		//******************************************************************************************
		//* 解答が正解であるかを判定する
		//******************************************************************************************
		// 結合テーブルが設定されていない場合は終了する
		if (this.join == null) return false;
		// 未解答の場合は【選択されていない】と判定する
		if (this.getAnswerChoicesInfoMap().isEmpty()) {
			 // 処理終了
			 return false;
		}
		QuestionDto questionDto = this.join.getQuestionDto(); // 設問Dto
		//*------------------------------------------------------------------------------------*
		//* 解答した選択肢の件数が正解数と等しいかを判定する
		//* - 解答件数が正解数と一致しない場合、【正解ではない】と判定する。
		//*------------------------------------------------------------------------------------*
		int selectAnswerCount = this.getAnswerChoicesInfoMap().values().size(); // 解答件数
		// 解答した選択肢の件数が正解数と一致しない場合
		if (selectAnswerCount != questionDto.getAnswers()) {
			 // 処理終了
			 return false;
		}
		//*------------------------------------------------------------------------------------*
		//* 解答した選択肢が全て正解であるかを判定する
		//* - 解答した選択肢の正解数をカウントし、設問の正解数と一致しない場合は
		//*   【正解ではない】と判定する。
		//*------------------------------------------------------------------------------------*
		int answerCorrectCount = 0; // 解答した選択肢の正解数
		// 選択肢の件数分ループする
		for (ChoicesDto choicesDto : this.getAnswerChoicesInfoMap().values()) {
			// 選択肢の正解フラグが【TRUE】である場合
			if (ChoicesDto.CORRECT_FLAG_TRUE.equals(choicesDto.getCorrectFlag())) {
				// 正解数を加算する
				answerCorrectCount++;
			}
		}
		// 解答の正解数が設問の正解数と一致しない場合
		if (answerCorrectCount != questionDto.getAnswers()) {
			 // 処理終了
			 return false;
		}
		// 処理終了
		return true;
	}

	/**
	 * 選択肢が解答として選択されているかを判定します。
	 * @param choicesId 選択肢ID
	 * @return true 解答として選択されている, false 解答として選択されていない
	 */
	public boolean isSelected(Long choicesId) {
		//******************************************************************************************
		//* 選択肢が解答として選択されているかを判定する
		//******************************************************************************************
		// 結合テーブルが設定されていない場合は終了する
		if (this.join == null) return false;
		// 未解答の場合は【選択されていない】と判定する
		if (this.getAnswerChoicesInfoMap().isEmpty()) {
			 // 処理終了
			 return false;
		}
		// 解答した選択肢の件数ループする
		for (ChoicesDto choiceDto : this.getAnswerChoicesInfoMap().values()) {
			// 解答選択肢の選択肢IDと一致する場合
			if (choiceDto.getChoicesId().equals(choicesId)) {
				 // 【解答として選択されている】と判定する
				 return true;
			}
		}
		// 処理終了
		return false;
	}

	/**
	 * 解答値の選択肢内容を生成します。
	 * @return String 選択肢内容文字列
	 */
	public String createAnswerContent() {
		//******************************************************************************************
		//* 解答値の選択肢内容を生成する
		//******************************************************************************************
		StringBuilder contentBuilder = new StringBuilder(); // 選択肢内容文字列
		// 解答選択肢の件数分ループする
		for (Long choicesNo : this.getAnswerChoicesInfoMap().keySet()) {
			ChoicesDto choicesDto = this.getAnswerChoicesInfoMap().get(choicesNo); // 選択肢DTO
			// 選択肢内容に文字列が既に設定されている場合
			if (contentBuilder.length() > 0) {
				// 改行コードを付与する
				contentBuilder.append("\n");
			}
			/***** 選択肢内容を文字列に追加する *****/
			contentBuilder.append("(");
			contentBuilder.append(choicesNo); // 選択肢ID
			contentBuilder.append(") ");
			contentBuilder.append(choicesDto.getContent()); // 内容
		 }
		// 処理終了
		return contentBuilder.toString();
	}

	/**
	 * 正解値の選択肢内容を生成します。
	 * @return 正解値の選択肢内容文字列
	 */
	public String createCorrectContent() {
		//******************************************************************************************
		//* 正解値の選択肢内容を生成する
		//******************************************************************************************
		StringBuilder contentBuilder = new StringBuilder(); // 選択肢内容文字列
		// 正解選択肢の件数分ループする
		for (Long choicesNo : this.getCorrectChoiceMap().keySet()) {
			ChoicesDto choicesDto = this.getCorrectChoiceMap().get(choicesNo); // 選択肢DTO
			// 選択肢内容に文字列が既に設定されている場合
			if (contentBuilder.length() > 0) {
				// 改行コードを付与する
				contentBuilder.append("\n");
			}
			/***** 選択肢内容を文字列に追加する *****/
			contentBuilder.append("(");
			contentBuilder.append(choicesNo); // 選択肢番号
			contentBuilder.append(") ");
			contentBuilder.append(choicesDto.getContent()); // 内容
		}
		// 処理終了
		return contentBuilder.toString();
	}

///// private method

	/**
	 * 解答した選択肢を取得します。<br />
	 * - 選択肢番号をキーにしたマップを取得します。
	 * @return 選択肢情報マップ(KEY [選択肢番号])
	 */
	private Map<Long, ChoicesDto> getAnswerChoicesInfoMap() {
		//******************************************************************************************
		//*  解答した選択肢を取得する
		//******************************************************************************************
		Map<Long, ChoicesDto> answerChoicesInfoMap = new LinkedHashMap<Long, ChoicesDto>(); // 選択肢情報マップ
		// 解答値が設定されていない場合は終了する
		if (StringUtils.isEmpty(this.getAnswer())) return answerChoicesInfoMap;
		// 結合テーブルが設定されていない場合は終了する
		if (this.join == null) return answerChoicesInfoMap;
		//*------------------------------------------------------------------------------------*
		//* 解答値と一致する選択肢データをリストに追加する
		//*------------------------------------------------------------------------------------*
		// 解答値を区切り文字で分割する
		String[] answerValues = this.getAnswer().split(",");
		// 解答値の件数分ループする
		for (String answer : answerValues) {
			// 解答値が数値文字列ではない場合は次のデータへ
			if (!StringUtils.isNumeric(answer)) continue;
			// 解答値を数値型に変換する
			Long answerValue = Long.parseLong(answer);
			// 選択肢の件数分ループする
			for (Long choicesNo : this.getSortedChoicesInfoMap().keySet()) {
				ChoicesDto choicesDto = this.getSortedChoicesInfoMap().get(choicesNo); // 選択肢DTO
				// 選択肢番号が解答値と等しい場合
				if (choicesNo.equals(answerValue)) {
					// 選択肢情報マップに登録する
					answerChoicesInfoMap.put(choicesNo, choicesDto);
					// ループ終了
					break;
				}
			}
		}
		// 処理終了
		return answerChoicesInfoMap;
	}

	/**
	 * 正解値の選択肢を取得します。<br />
	 * - 選択肢番号をキーにしたマップを取得します。
	 * @return 正解の選択肢Dtoリスト
	 */
	private Map<Long, ChoicesDto> getCorrectChoiceMap() {
		//******************************************************************************************
		//*  正解値の選択肢を取得する
		//******************************************************************************************
		Map<Long, ChoicesDto> choicesInfoMap = new LinkedHashMap<Long, ChoicesDto>(); // 選択肢情報マップ
		// 結合テーブルが設定されていない場合は終了する
		if (this.join == null) return choicesInfoMap;
		//*------------------------------------------------------------------------------------*
		//* 解答値と一致する選択肢データをリストに追加する
		//*------------------------------------------------------------------------------------*
		// 選択肢の件数分ループする
		for (Long choicesNo : this.getSortedChoicesInfoMap().keySet()) {
			ChoicesDto choicesDto = this.getSortedChoicesInfoMap().get(choicesNo); // 選択肢DTO
			// 選択肢が正解値である場合(正解フラグがTRUEである)
			if (ChoicesDto.CORRECT_FLAG_TRUE.equals(choicesDto.getCorrectFlag())) {
				// 選択肢情報マップに登録する
				choicesInfoMap.put(choicesNo, choicesDto);
			}
		}
		// 処理終了
		return choicesInfoMap;
	}

//**************************************************************************************************
//* 内部クラス
//**************************************************************************************************
	/**
	 * 結合テーブルに関する処理を定義する内部クラスです。
	 * @author thinkware
	 */
	 public class Join {

///// field

		//*------------------------------------------------------------------------------------*
		//* 結合テーブル
		//*------------------------------------------------------------------------------------*
		/** 結合テーブル：[設問DTO] */
		private QuestionDto questionDto = null;
		/** 結合テーブル：[選択肢DTOリスト] */
		private List<ChoicesDto> choicesDtoList = new ArrayList<ChoicesDto>();

///// accessor

		//*------------------------------------------------------------------------------------*
		//* 設問DTO
		//*------------------------------------------------------------------------------------*
		/**
		 * 設問DTOを取得します。
		 * @return 設問DTO
		 */
		public QuestionDto getQuestionDto() {
			return this.questionDto;
		}

		/**
		 * 設問DTOを設定します。
		 * @param questionDto 設問DTO
		 */
		public void setQuestionDto(QuestionDto questionDto) {
			this.questionDto = questionDto;
		}

		//*------------------------------------------------------------------------------------*
		//* 選択肢DTOリスト
		//*------------------------------------------------------------------------------------*
		/**
		 * 選択肢DTOリストを取得します。
		 * @return 選択肢DTOリスト
		 */
		public List<ChoicesDto> getChoicesDtoList() {
			return this.choicesDtoList;
		}

		/**
		 * 選択肢DTOリストを設定します。
		 * @param choicesDtoList 選択肢DTOリスト
		 */
		public void setChoicesDtoList(List<ChoicesDto> choicesDtoList) {
			this.choicesDtoList = choicesDtoList;
		}
	}
}