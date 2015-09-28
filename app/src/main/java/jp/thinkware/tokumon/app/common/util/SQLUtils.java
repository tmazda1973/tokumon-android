package jp.thinkware.tokumon.app.common.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SQLに関する共通ユーティリティクラスです。
 * @author thinkware
 */
public final class SQLUtils {

	/**
	 * コンストラクタ(インスタンス生成不可)
	 */
	private SQLUtils() {}

	/**
	 * 抽出条件マップを絞り込んで新規にマップを生成します。
	 * - パラメータで指定された抽出条件マップから、絞込み対象のキーと値を抽出して新規にマップを生成します。
	 * @param conditionMap 抽出条件マップ
	 * @param keyValues 絞込み対象となるキーの配列
	 * @return 抽出条件マップ(絞込み後)
	 */
	public static Map<String, Object> narrowConditionMap(
			Map<String, Object> conditionMap, String[] keyValues) {
		//******************************************************************************************
		//* 抽出条件マップを絞り込む
		//******************************************************************************************
		Map<String, Object> narrowCondMap = new HashMap<String, Object>(); // 抽出条件マップ(絞込み用)
		// 抽出条件マップが指定されていない場合は終了する
		if (conditionMap == null) {
			// 処理終了
			return narrowCondMap;
		}
		// 絞込み対象キーが指定されていない場合は終了する
		if (keyValues == null) {
			// 処理終了
			return conditionMap;
		}
		List<String> narrowKeyList = Arrays.asList(keyValues); // 絞込み対象キーリスト
		// 抽出条件マップのキー件数分ループする
		for (String key : conditionMap.keySet()) {
			// 絞込み対象のキーである場合
			if (narrowKeyList.contains(key)) {
				// 抽出条件値を絞込み用のマップに登録する
				narrowCondMap.put(key, conditionMap.get(key));
			}
		}

		// 処理終了
		return narrowCondMap;
	}
}
