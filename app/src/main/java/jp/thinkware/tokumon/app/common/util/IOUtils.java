package jp.thinkware.tokumon.app.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 入出力処理に関する共通ユーティリティクラスです。
 * @author thinkware
 */
public final class IOUtils {

	/**
	 * コンストラクタ(インスタンス生成不可)
	 */
	private IOUtils() {}

	/**
	 * ファイルから文字列を読み込みます。
	 * @param is 入力ストリーム
	 * @param encode 文字エンコード
	 * @return ファイルの文字列
	 * @throws IOException
	 */
	public static final String readFile(InputStream is, String encode) throws IOException {
		BufferedReader br = null;
		// 文字コードが指定されていない場合
		if (encode == null || encode.length() <= 0) {
			// デフォルト値を設定する
			encode = "sjis";
		}
		try {
			br = new BufferedReader(new InputStreamReader(is, encode));
			StringBuilder sb = new StringBuilder();
			String str;
			while((str = br.readLine()) != null) {
				sb.append(str + "\n");
			}
			return sb.toString();
		}
		finally {
			if (br != null) br.close();
		}
	}
}
