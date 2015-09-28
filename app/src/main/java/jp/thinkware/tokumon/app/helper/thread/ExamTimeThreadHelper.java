package jp.thinkware.tokumon.app.helper.thread;

import android.os.Handler;


/**
 * 試験時間を管理するスレッドを操作するヘルパークラスです。<br>
 * - Singletonパターンを実装しています。
 * @author thinkware
 */
public class ExamTimeThreadHelper {

///// field

	/** 自身のインスタンス */
	private static ExamTimeThreadHelper instance = null;
	/** スレッドハンドラのインスタンス */
	private Handler handler = null;
	/** スレッドクラスのインスタンス */
	private ExamTimeThread thread = null;

	//*--------------------------------------------------------------------------------------------*
	//* 経過時間計測用
	//*--------------------------------------------------------------------------------------------*
	/** 開始時刻(ミリ秒) */
	private long startTime = 0;
	/** 前回時刻(ミリ秒) */
	private long prevTime = 0;
	/** 経過時間(ミリ秒) */
	private long elapsedTime = 0;

///// accessor

	/**
	 * 経過時間を取得します。(分)
	 * @return Long 経過時間
	 */
	public long getElapsedTimeMinute() {
		// 経過時間を【分】に変換する
		return this.getElapsedTime() / 60;
	}

	/**
	 * 経過時間を取得します。(秒)
	 * @return elapsedTime
	 */
	public long getElapsedTime() {
		return this.elapsedTime / 1000;
	}

	/**
	 * 経過時間を取得します。(ミリ秒)
	 * @return elapsedTime
	 */
	public long getElapsedTimeMill() {
		return this.elapsedTime;
	}

///// method

	/**
	 * コンストラクタ
	 */
	private ExamTimeThreadHelper() {}

	/**
	 * 自オブジェクトのインスタンスを取得します。(Singletonパターン）
	 * @return ExamTimeThreadHelper
	 */
	public static synchronized ExamTimeThreadHelper getInstance() {
		// インスタンスが生成されていない場合は生成する
		if (ExamTimeThreadHelper.instance == null) {
			ExamTimeThreadHelper.instance = new ExamTimeThreadHelper();
		}
		// 処理終了
		return ExamTimeThreadHelper.instance;
	}

	/**
	 * 試験時間の管理を開始します。
	 */
	public void start() {
		//******************************************************************************************
		//* 試験時間の管理を開始する
		//******************************************************************************************
		// 既にスレッドが起動している場合は終了する
		this.stop();
		//*------------------------------------------------------------------------------------*
		//* 経過時間計測用の変数を初期化する
		//*------------------------------------------------------------------------------------*
		this.startTime = System.currentTimeMillis(); // 開始時刻
		this.prevTime  = this.startTime; // 前回時刻
		this.elapsedTime = 0; // 経過時間
		//*------------------------------------------------------------------------------------*
		//* 経過時間計測スレッドを開始する
		//*------------------------------------------------------------------------------------*
		// スレッドハンドラを生成してスレッドを起動する
		this.handler = new Handler();
		this.thread  = new ExamTimeThread();
		this.handler.post(this.thread);
	}

	/**
	 * 試験時間の管理を再開します。
	 */
	public void resume() {
		//******************************************************************************************
		//* 試験時間の管理を再開する
		//******************************************************************************************
		// スレットハンドラが生成されていない場合は終了する
		if (this.handler == null || this.thread == null) {
			// 処理終了
			return;
		}
		//*------------------------------------------------------------------------------------*
		//* 経過時間計測用の変数を設定する
		//*------------------------------------------------------------------------------------*
		this.prevTime = System.currentTimeMillis(); // 前回時刻
		//*------------------------------------------------------------------------------------*
		//* 経過時間計測スレッドを開始する
		//*------------------------------------------------------------------------------------*
		this.handler.post(this.thread);
	}

	/**
	 * 試験時間の管理を停止します。
	 */
	public void pause() {
		//******************************************************************************************
		//* 試験時間の管理を停止する
		//******************************************************************************************
		// 経過時間計測スレッドが起動している場合は終了する
		if (this.handler != null && this.thread != null) {
			this.handler.removeCallbacks(this.thread);
		}
	}

	/**
	 * 試験時間の管理を終了します。
	 */
	public void stop() {
		//******************************************************************************************
		//* 試験時間の管理を終了する
		//******************************************************************************************
		// 経過時間計測スレッドが起動している場合は終了する
		if (this.handler != null && this.thread != null) {
			this.handler.removeCallbacks(this.thread);
		}
		// 処理スレッドのインスタンスを初期化する
		this.handler = null; // スレッドハンドラのインスタンス
		this.thread  = null; // スレッドクラス
	}

//**************************************************************************************************
//* 内部クラス
//**************************************************************************************************

	/**
	 * 経過時間を計測するスレッドクラスです。
	 * @see Runnable
	 * @author thinkware
	 */
	private class ExamTimeThread implements Runnable {

// method

		/**
		 * スレッド起動時に実行されるハンドラです。<br>
		 * - 経過時間を計測します。
		 * @see Runnable#run()
		 */
		@Override
		public void run() {
			//**************************************************************************************
			//* 経過時間を計測する(1秒ごとに再帰呼び出しを行う)
			//**************************************************************************************
			ExamTimeThreadHelper parent = ExamTimeThreadHelper.this; // 親クラスのインスタンス
			// 前回時刻が設定されていない場合は終了する
			if (parent.prevTime == 0) return;
			// 経過時間を算出する([現在時刻 - 前回時刻]を加算する)
			long currentTime = System.currentTimeMillis(); // 現在時刻
			parent.elapsedTime += (currentTime - parent.prevTime);
			// 前回時刻を更新する
			parent.prevTime = currentTime;
			// 1秒(1000ミリ秒)後に再帰呼び出しを行う
			parent.handler.postDelayed(this, 1000);
		}
	}
}
