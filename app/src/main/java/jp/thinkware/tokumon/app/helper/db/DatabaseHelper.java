package jp.thinkware.tokumon.app.helper.db;

import java.io.IOException;

import jp.thinkware.tokumon.app.common.util.IOUtils;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * AndroidのDB(SQLite)操作に関するヘルパークラスです。<br>
 * - Singletonパターンを実装しています。
 * @author thinkware
 */
public class DatabaseHelper extends SQLiteOpenHelper {

// field

	/** データベース名 */
	private final static String DB_NAME = "tw_kaiden_db";
	/** データベースのバージョン */
	private final static int DB_VER = 2;
	/** コンテキストオブジェクト */
	private Context context;
	/** 自身のインスタンス */
	private static DatabaseHelper instance = null;

// method

	/**
	 * コンストラクタ
	 * @param context コンテキストオブジェクト
	 */
	private DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VER);
		this.context = context;
	}

	/**
	 * DB操作オブジェクトのインスタンスを取得します。(Singletonパターン）
	 */
	public static synchronized DatabaseHelper getInstance(Context context) {
		// インスタンスが生成されていない場合は生成する
		if (DatabaseHelper.instance == null) {
			DatabaseHelper.instance = new DatabaseHelper(context);
		}
		// 処理終了
		return DatabaseHelper.instance;
	}

	/**
	 * データベースが作成された時に呼ばれます。<br>
	 * assets/sql/create内に定義されているsqlを実行します。
	 * @param db DBオブジェクト
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			// SQLを実行する(CREATE TABLE)
			this.execSql(db, "sql/create");
			// SQLを実行する：[マスタデータ作成]
			this.execSql(db, "sql/setup");
		}
		// 例外が発生した場合：[一般例外]
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * データベースをバージョンアップした時に呼ばれます。<br>
	 * assets/sql/drop内に定義されているsqlを実行します。<br>
	 * その後onCreate()メソッドを呼び出します。<br>
	 * @param db DBオブジェクト
	 * @param oldVersion 旧バージョン
	 * @param newVersion 新バージョン
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		try {
			// SQLを実行する(DROP TABLE)
			this.execSql(db, "sql/drop");
		}
		// 例外が発生した場合：[一般例外]
		catch (IOException e) {
			e.printStackTrace();
		}
		// DBを作成する
		this.onCreate(db);
	}

	/**
	 * assetsフォルダ内のSQLファイルを実行します。<br>
	 * ファイル内に複数のSQL文を記述する場合、区切り文字("@@")でSQL文を分割します。
	 * @param db データベース
	 * @param assetsDir assetsフォルダ内のフォルダのパス
	 * @throws IOException
	 */
	private void execSql(SQLiteDatabase db, String assetsDir)
			throws IOException {
		//**********************************************************************
		//* assetsフォルダ内のSQLファイルを実行する
		//**********************************************************************
		AssetManager as = this.context.getResources().getAssets();
		try {
			// assetsフォルダ配下のファイルを取得する
			String files[] = as.list(assetsDir);
			// ファイルの件数分ループする
			for (int i = 0; i < files.length; i++) {
				// SQLファイルを読み込む
				String sql_str = IOUtils.readFile(as.open(assetsDir + "/" + files[i]), "UTF-8");
				// 区切り文字("@@")で分割した件数分ループする
				for (String sql : sql_str.split("@@")) {
					// SQL文字列が存在する場合
					if (sql != null && sql.length() > 0) {
						// SQLを実行する
						db.execSQL(sql);
					}
				}
			}
		}
		// 例外が発生した場合：[入出力例外]
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// 例外が発生した場合：[一般例外]
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
