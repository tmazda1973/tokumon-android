package jp.thinkware.tokumon.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DBレコードのDTOクラスです。(設問テーブル)
 * @author thinkware
 */
public class QuestionDto implements Serializable {

	private static final long serialVersionUID = 1L;

///// const

	//**********************************************************************************************
	//* 定数
	//**********************************************************************************************
	/** テーブル名 */
	public static final String TABLE_NAME = "question";

	/** カラム名：設問ID */
	public static final String COLUMN_QUESTION_ID = "question_id";
	/** カラム名：コースID */
	public static final String COLUMN_COURSE_ID = "course_id";
	/** カラム名：カテゴリID */
	public static final String COLUMN_CATEGORY_ID = "category_id";
	/** カラム名：問題 */
	public static final String COLUMN_QUESTION = "question";
	/** カラム名：設問パターン */
	public static final String COLUMN_PATTERN = "pattern";
	/** カラム名：選択肢数 */
	public static final String COLUMN_CHOICES = "choices";
	/** カラム名：解答数 */
	public static final String COLUMN_ANSWERS = "answers";
	/** カラム名：ソース、図表データ */
	public static final String COLUMN_CHART_SOURCE = "chart_source";
	/** カラム名：設問に対する解説 */
	public static final String COLUMN_EXPLANATION = "explanation";

///// field

	/** 項目値：設問ID integer */
	private Long _question_id = null;
	/** 項目値：コースID integer */
	private Long _course_id = null;
	/** 項目値：カテゴリID integer */
	private Long _category_id = null;
	/** 項目値：問題 text */
	private String _question = null;
	/** 項目値：設問パターン text */
	private String _pattern = null;
	/** 項目値：選択肢数 integer */
	private Long _choices = null;
	/** 項目値：解答数 integer */
	private Long _answers = null;
	/** 項目値：ソース、図表データ BLOB */
	private byte[] _chart_source = null;
	/** 項目値：設問に対する解説 text */
	private String _explanation = null;

	/** 結合テーブル処理内部クラスのインスタンス */
	private QuestionDto.Join join = null;

///// accessor

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
	//* 項目値：[コースID]
	//*----------------------------------------------------------------------------------------*
	/**
	 * コースIDを取得します。
	 * @return コースID
	 */
	public Long getCourseId() {
		return this._course_id;
	}

	/**
	 * コースIDを設定します。
	 * @param course_id コースID
	 */
	public void setCourseId(Long course_id) {
		this._course_id = course_id;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[カテゴリID]
	//*----------------------------------------------------------------------------------------*
	/**
	 * カテゴリIDを取得します。
	 * @return カテゴリID
	 */
	public Long getCategoryId() {
		return this._category_id;
	}

	/**
	 * カテゴリIDを設定します。
	 * @param category_id カテゴリID
	 */
	public void setCategoryId(Long category_id) {
		this._category_id = category_id;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[問題]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 問題を取得します。
	 * @return 問題
	 */
	public String getQuestion() {
		return this._question;
	}

	/**
	 * 問題を設定します。
	 * @param question 問題
	 */
	public void setQuestion(String question) {
		this._question = question;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[設問パターン]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 設問パターンを取得します。
	 * @return 設問パターン
	 */
	public String getPattern() {
		return this._pattern;
	}

	/**
	 * 設問パターンを設定します。
	 * @param pattern 設問パターン
	 */
	public void setPattern(String pattern) {
		this._pattern = pattern;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[選択肢数]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 選択肢数を取得します。
	 * @return 選択肢数
	 */
	public Long getChoices() {
		return this._choices;
	}

	/**
	 * 選択肢数を設定します。
	 * @param choices 選択肢数
	 */
	public void setChoices(Long choices) {
		this._choices = choices;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[解答数]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 解答数を取得します。
	 * @return 解答数
	 */
	public Long getAnswers() {
		return this._answers;
	}

	/**
	 * 解答数を設定します。
	 * @param answers 解答数
	 */
	public void setAnswers(Long answers) {
		this._answers = answers;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[ソース、図表データ]
	//*----------------------------------------------------------------------------------------*
	/**
	 * ソース、図表データを取得します。
	 * @return ソース、図表データ
	 */
	public byte[] getChartSource() {
		return _chart_source;
	}

	/**
	 * ソース、図表データを設定します。
	 * @param chart_source ソース、図表データ
	 */
	public void setChartSource(byte[] chart_source) {
		this._chart_source = chart_source;
	}

	//*----------------------------------------------------------------------------------------*
	//* 項目値：[設問に対する解説]
	//*----------------------------------------------------------------------------------------*
	/**
	 * 設問に対する解説を取得します。
	 * @return 設問に対する解説
	 */
	public String getExplanation() {
		return this._explanation;
	}

	/**
	 * 設問に対する解説を設定します。
	 * @param explanation 設問に対する解説
	 */
	public void setExplanation(String explanation) {
		this._explanation = explanation;
	}

	//*----------------------------------------------------------------------------------------*
	//* 結合テーブル処理内部クラスのインスタンス
	//*----------------------------------------------------------------------------------------*
	/**
	 * 結合テーブル処理内部クラスのインスタンスを取得します。
	 * @return join 結合テーブル処理内部クラスのインスタンス
	 */
	 public QuestionDto.Join getJoin() {
		// インスタンスが生成されていない場合は生成する
		if (this.join == null) {
			this.join = new QuestionDto().new Join();
		}
		// 処理終了
	 	return this.join;
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

		/** 結合テーブル */
		private List<ChoicesDto> choicesDtoList = new ArrayList<ChoicesDto>(); // 選択肢DTOリスト

///// accessor

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