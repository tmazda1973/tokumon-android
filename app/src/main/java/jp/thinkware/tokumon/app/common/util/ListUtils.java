package jp.thinkware.tokumon.app.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * リストオブジェクトに関する共通ユーティリティクラスです。
 * @author thinkware
 */
public final class ListUtils {

	/**
	 * コンストラクタ(インスタンス生成不可)
	 */
	private ListUtils() {}

// method

	/**
	 * リスト要素をランダムに並び替えます。
	 * @param list 並び替え対象のリストオブジェクト
	 * @return リストオブジェクト(並び替え後 - 引数で指定したオブジェクト)
	 */
	public static <T> List<T> randomOrder(List<T> list) {
		//******************************************************************************************
		//* リスト要素をランダムに並び替える
		//******************************************************************************************
		List<T> tmpList = new ArrayList<T>(); // 並び替えリスト(作業用)
		Random random = new Random(); // ランダム制御オブジェクト
		// リストの要素が存在する間ループする
		while (list.size() > 0) {
			// 要素インデックスをランダムに選択する
			int r = random.nextInt(list.size());
			// ランダムに選んだ要素をリストから削除し、作業用リストに追加する
			tmpList.add(list.remove(r));
		}
		// 作業用リストの件数分ループする
		for (T object : tmpList) {
			// 作業用リストの要素を並び替えリストに追加する
			list.add(object);
		}

		// 処理終了
		return list;
	}

	/**
	 * コレクションデータを文字列型の配列に変換します。
	 * @param values コレクションデータ
	 * @return 文字列型の配列
	 */
	public static String[] toStringArray(Collection<Object> values) {
		//******************************************************************************************
		//* コレクションデータを文字列型の配列に変換する
		//******************************************************************************************
		List<String> strValueList = new ArrayList<String>(); // 文字列リスト
		// コレクションのデータ件数分ループする
		for (Object value : values) {
			// 文字列に変換してリストに追加する
			strValueList.add(value.toString());
		}

		// 処理終了
		return (String[])strValueList.toArray(new String[]{});
	}
}
