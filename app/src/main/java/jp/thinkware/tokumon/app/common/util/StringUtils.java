package jp.thinkware.tokumon.app.common.util;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * 文字列に関する共通ユーティリティクラスです。
 * @author thinkware
 */
public final class StringUtils {

	/**
	 * コンストラクタ(インスタンス生成不可)
	 */
	private StringUtils() {}

	/**
	 * 抽出条件をWHERE句文字列に変換します。
	 * @param conditionMap 抽出条件マップ
	 * @return WHERE句文字列
	 */
	public static String toWhereString(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* 抽出条件をWHERE句文字列に変換する
		//******************************************************************************************
		StringBuilder wherePhrBuilder = new StringBuilder(); // WHERE句文字列
		Set<String> conditionKeySet = conditionMap.keySet(); // 抽出条件のキーセット
		// 抽出条件のキーセット数分ループする
		for (String key : conditionKeySet) {
			// WHERE句文字列が既に設定されている場合
			if (wherePhrBuilder.length() > 0) {
				// 区切り文字を連結する
				wherePhrBuilder.append(" AND ");
			}
			// 抽出条件を連結する
			wherePhrBuilder.append(key + "=" + String.valueOf(conditionMap.get(key)));
		}
		// 処理終了
		return wherePhrBuilder.toString();
	}

	/**
	 * 抽出条件をWHERE句文字列(プレースホルダ形式)に変換します。
	 * @param conditionMap 抽出条件マップ
	 * @return WHERE句文字列
	 */
	public static String toWhereStringPlaceholder(Map<String, Object> conditionMap) {
		//******************************************************************************************
		//* 抽出条件をWHERE句文字列に変換する
		//******************************************************************************************
		StringBuilder wherePhrBuilder = new StringBuilder(); // WHERE句文字列
		Set<String> conditionKeySet = conditionMap.keySet(); // 抽出条件のキーセット
		// 抽出条件のキーセット数分ループする
		for (String key : conditionKeySet) {
			// WHERE句文字列が既に設定されている場合
			if (wherePhrBuilder.length() > 0) {
				// 区切り文字を連結する
				wherePhrBuilder.append(" AND ");
			}
			// 抽出条件を連結する
			wherePhrBuilder.append(key + "=?");
		}
		// 処理終了
		return wherePhrBuilder.toString();
	}

	/**
	 * 文字列が数値であるかを判定します。
	 * @param value 判定対象の文字列
	 * @return true 数値である, false 数値ではない
	 */
	public static boolean isNumeric(String value) {
		//******************************************************************************************
		//* 文字列が数値であるかを判定する
		//******************************************************************************************
		boolean isNumeric = false; // 数値判定
		try {
			// 文字列を数値に変換する
			new BigDecimal(value);
			// 例外が発生しない場合、【数値である】と判定する
			isNumeric = true;
		}
		// 例外発生
		catch (Exception e) {
			// 何もしない
		}
		// 処理終了
		return(isNumeric);
	}

	/**
	 * 改行コードを変換します。(UTF-8->ISO-8859-1)<br />
	 * ・文字コードが【UTF-8】のSQLiteから抽出した文字列を、TextViewなどの画面コンポーネントに表示する場合に使用します。
	 * @param srcStr 変換元文字列
	 * @return 改行コード変換後の文字列
	 */
	public static String replaceNewLine(String srcStr) {
		//******************************************************************************************
		//* 改行コードを変換する(UTF-8->ISO-8859-1)
		//******************************************************************************************
		String replaceStr = null; // 変換後文字列
		try {
			// 文字列置換用の改行コード文字列を生成する(文字コード：[UTF-8])
			byte[] bytes = "\\\\n".getBytes("ISO-8859-1");
			String newline = new String(bytes, "UTF-8");
			// 文字列の改行コードを変換する(UTF-8->ISO-8859-1)
			replaceStr = srcStr.replaceAll(newline, "\n");
		}
		// 例外発生
		catch (Exception e) {
			// 処理終了
			return srcStr;
		}

		// 処理終了
		return replaceStr;
	}

	/**
	 * 改行コードを削除します。<br />
	 * ・改行コードが存在する文字列を、ListView等で一行で表示する場合に使用します。
	 * @param srcStr 変換元文字列
	 * @return 改行コード削除後の文字列
	 */
	public static String removeNewLine(String srcStr) {
		//******************************************************************************************
		//* 改行コードを削除する
		//******************************************************************************************
		String replaceStr = null; // 変換後文字列
		try {
			// 改行コードを空白文字に変換する
			replaceStr = srcStr.replaceAll("\n", "");
		}
		// 例外発生
		catch (Exception e) {
			// 処理終了
			return srcStr;
		}

		// 処理終了
		return replaceStr;
	}

	/**
	 * 文字列が空文字であるかを判定します。<br>
	 * - 文字列がnull値、もしくは文字長が【0】である場合に空文字と判定します。
	 * @param value 判定対象の文字列
	 * @return true 空文字である, false 空文字ではない
	 */
	public static boolean isEmpty(String value) {
		//******************************************************************************************
		//* 文字列が空文字であるかを判定する
		//******************************************************************************************
		// 文字列がnull値、もしくは文字長が【0】である場合
		if (value == null || value.length() == 0) {
			// 処理終了
			return true;
		}
		// 処理終了
		return false;
	}
}
