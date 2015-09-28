INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (1,1,'NotificationManager',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (1,2,'WindowManager',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (1,3,'PackageManager',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (1,4,'DialerManager',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (2,1,'onDestroy',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (2,2,'onCreate',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (2,3,'onStartCommand',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (2,4,'onBind',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (3,1,'ProgressDialog は AlertDialog クラスから継承している。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (3,2,'ProgressDialog は、setContentView(...) メソッドを使用することにより、XML で定義されたカスタムレイアウトを適用できる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (3,3,'ProgressDialog は、STYLE_HORIZONTAL と STYLE_SPINNER の 2 つの型に設定できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (3,4,'ProgressDialog は、プログレスバーを表示する Drawable クラスを使用するよう自在に構成できる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (4,1,'Sensor',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (4,2,'SensorEventListener',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (4,3,'SensorManager',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (4,4,'SensorEvent',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (5,1,'BluetoothDevice',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (5,2,'BluetoothAdapter',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (5,3,'BluetoothSocket',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (5,4,'BluetoothClass',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (6,1,'初歩的な操作をユーザーに教えることができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (6,2,'テストのためのダミーアプリケーションを提供する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (6,3,'ターミナルでランダムなユーザー操作をエミュレートできる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (6,4,'GUIで、SOLite データベースファイルを操作できる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (7,1,'RSA はキー作成の暗号化アルゴリズムとして使うことはできない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (7,2,'キーツールを使用して作成することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (7,3,'キー保存ファイルに、複数のキーを保存することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (7,4,'SDK ツールで作成されたデバッグキーは使用できない。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (8,1,'バックグラウンド',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (8,2,'フォアグラウンド',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (8,3,'ビジブル',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (8,4,'ノンビジブル',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (9,1,'実行時に取得したログをグラフィカルに表示する。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (9,2,'呼び出しスタックをグラフィカルに表示する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (9,3,'メモリ情報の取得とリリースログをグラフィカルに表示する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (9,4,'UI 状態階層をグラフィカルに表示する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (10,1,'サポートしているリソースファイルの作成',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (10,2,'Android アプリケーションの実行',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (10,3,'View の作成のサポート',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (10,4,'Android プロジェクトの作成',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (11,1,'adb のスタートアップ オプションで、ハンドセットの IP アドレスを指定する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (11,2,'使用するポート番号を「5554」に設定する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (11,3,'環境変数 ADBHOST をハンドセットの IP アドレスに設定する。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (11,4,'ハンドセットの設定で、「ADB デバッグ接続を許可」をオンにする。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (12,1,'ContentProvider クラスの update メソッドで、ContentResolver.setNotificationUri メソッドを呼び出し通知する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (12,2,'ContentProvider クラスの update メソッドで、Cursor.notifyChange メソッドを呼び出し通知する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (12,3,'ContentProvider クラスの update メソッドで、ContentResolver.notifyChange メソッドを呼び出し通知する。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (12,4,'ContentProvider クラスの update メソッドで、Cursor.setNotificationUri メソッドを呼び出し通知する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (13,1,'Doja',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (13,2,'Java ME',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (13,3,'Java EE',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (13,4,'Java SE',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (14,1,'ADT',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (14,2,'AJDT',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (14,3,'RDT',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (14,4,'CDT',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (15,1,'Android は暗号化機能を標準で提供しないため、ライブラリを別途埋め込む必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (15,2,'ネットワークやハードウェアなどの機能を使うには、ユーザーの使用許可とともに、開発段階での設定が必要である。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (15,3,'Android アプリケーションは、他のアプリケーションに使われている情報は参照できない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (15,4,'Android は、ユーザー認証やデバイス認証といった標準認証メカニズムを提供する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (16,1,'MODE_PRIVATE',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (16,2,'MODE_WORLD_WRITEABLE',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (16,3,'MODE_PUBLIC',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (16,4,'MODE_WORLD_READABLE',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (17,1,'/system/app//files',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (17,2,'/data/data//files',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (17,3,'/data/app//files',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (17,4,'/system/data//files',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (18,1,'/res/movie',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (18,2,'/res/values',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (18,3,'/res/raw',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (18,4,'/res/anim',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (19,1,'サービス>フォアグラウンド>ビジブル>バックグラウンド>エンプティ',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (19,2,'サービス>フォアグラウンド>ビジブル>エンプティ>バックグラウンド',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (19,3,'フォアグラウンド>サービス>ビジブル>バックグラウンド>エンプティ',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (19,4,'フォアグラウンド>ビジブル>サービス>バックグラウンド>エンプティ',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (20,1,'dp (dip)',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (20,2,'pt',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (20,3,'sp',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (20,4,'px',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (21,1,'トーストの表示時間の長さは、LENGTH_LONG と LENGTH_SHORT の2つから選べる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (21,2,'トーストは表示されると自動的に閉じるため、dismiss () メソッドは用意されていない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (21,3,'トーストは、android.widget パッケージに含まれているクラスである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (21,4,'トーストは簡単な表示のためのクラスであり、XMLで定義されたカスタムレイアウトでは設定できない。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (22,1,'openOptionsMenu',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (22,2,'onCreateContextMenu',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (22,3,'onMenuOpened',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (22,4,'onCreateOptionsMenu',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (23,1,'AIDL ファイルでは、複数のメソッドを定義することができる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (23,2,'メソッドのパラメーターとして、Java のプリミティブ型を使用することはできない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (23,3,'スクリプト言語実行の環境を提供している。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (23,4,'アプリケーション間のデータ交換を可能にする。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (24,1,'2.0 以降',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (24,2,'1.5 以降',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (24,3,'1.6 以降',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (24,4,'2.1 以降',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (25,1,'ContentObservable',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (25,2,'Android Interface Definition Language',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (25,3,'ContentProvider',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (25,4,'ContentProducer',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (26,1,'dat',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (26,2,'res',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (26,3,'gen',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (26,4,'src',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (27,1,'Activity',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (27,2,'BroadcastReceiver',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (27,3,'Service',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (27,4,'Intent',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (28,1,'リソースファイル',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (28,2,'ソースファイル',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (28,3,'プロジェクトファイル',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (28,4,'マニフェストファイル',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (29,1,'WAITING',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (29,2,'RUNNING',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (29,3,'PENDING',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (29,4,'FINISHED',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (30,1,'setUp',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (30,2,'runTest',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (30,3,'setActivityIntent',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (30,4,'tearDown',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (31,1,'<menultem android:id="@+id/open" android:title-"Open">',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (31,2,'<option android:id="@+id/open" android:title="Open">',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (31,3,'<optionitem android:id="@+id/open"android:title-"Open">',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (31,4,'<item android:id="@+id/open" android:title-"Open">',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (32,1,'Map API キーを取得するには、開発者情報を提供する必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (32,2,'1 つの apk ファイルで複数の Map API キーを定義することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (32,3,'PCごとにデバッグ用の Map API キーを取得する必要がある。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (32,4,'Map API キーは、keytool ユーティリティで作成される。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (33,1,'外部ライブラリを使用するときに必要なツールである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (33,2,'アセット フォルダーに、リソーファイルのためにID を自動的に生成する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (33,3,'zip と互換性のあるアーカイブファイルを新規作成する。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (33,4,'クラスファイルから Android バイトコードを作成する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (34,1,'apk ファイルを最適化するツールである。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (34,2,'apk ファイルを作成し、アーカイブするツールである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (34,3,'クラスファイルを dex ファイルに変換するツールである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (34,4,'レイアウトファイルの階層を表示するツールである。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (35,1,'adb サーバーは、偶数の TCP ポートを adb デーモンに接続するよう割り当てる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (35,2,'adb サーバーは、adb クライアントの通信を受けるようTCP ポート 5037 にバインドする。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (35,3,'adb サーバーはエミュレーターや物理ハンドセット上で動作する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (35,4,'adb サーバーが動作していないと、adb クライアントは起動時、正常に立ち上がらない。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (36,1,'どちらのメソッドも Intent をブロードキャストできる。\n\n',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (36,2,'どちらのメソッドもオーバーロードにより定義される。\n\n',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (36,3,'どちらのメソッドも例外をスローする。\n\n',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (36,4,'どちらのメソッドも非同期である。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (37,1,'ランタイム例外がスローされる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (37,2,'「Hello World」または「Hello」のどちらが表示されるかは決まっていない。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (37,3,'「Hello」が表示される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (37,4,'「Hello World」が表示される。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (38,1,'Button や TextView といった既存の View クラスのソースをコピーして作成する。\n\n',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (38,2,'android.view.View クラスを拡張して作成する。\n\n',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (38,3,'複数の View を組み合わせて作成する。\n\n',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (38,4,'Button や TextView といった既存の View クラスを拡張して作成する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (39,1,'notification.setFlags(Notification. FLAGJNSISTENT);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (39,2,'notification.flags |= Notification.FLAG_AUTO_CANCEL;',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (39,3,'notification.setFlags(Notification.FLAG_AUTO_CANCEL);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (39,4,'notification.flags |= Notification.FLAG_INSISTENT;',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (40,1,'INTERNET',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (40,2,'BLUETOOTH',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (40,3,'CHANGE_NE7WORK_STATE',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (40,4,'ACCESS_NETWORK_STATE',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (41,1,'ConnectivityManager',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (41,2,'Proxy',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (41,3,'WifiManager',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (41,4,'Networklnfo',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (42,1,'署名には、秘密鍵を含めたキーストア ファイルを設定する必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (42,2,'アプリケーションをインストールするには証明が必要である。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (42,3,'署名には、jarsigner を使う必要がある。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (42,4,'アプリケーションの更新では、同じ認証で署名する必要がある。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (43,1,'ACCESS_COARSE_LOCATION',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (43,2,'ACCESS_CHECKIN_PROPERTIES',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (43,3,'ACCESS_MOCK_LOCATION',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (43,4,'ACCESS_FINE_LOCATION',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (44,1,'EventLog',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (44,2,'DisplayMetrics',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (44,3,'Log',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (44,4,'DebugUtils',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (45,1,'WifiConfiguration',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (45,2,'WifiManager',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (45,3,'ScanResult',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (45,4,'Wifilnfo',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (46,1,'Bitmap img = BitmapFactory.decodeResource(R.drawable.image);',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (46,2,'Bitmap img = (Bitmap)GraphicsFactory.decodeResouces(R.drawable.image);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (46,3,'Bitmap img = BitmapFactory.decodeFile(R.drawable.image),',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (46,4,'Bitmap img = new Bitmap(R.drawable.image);',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (47,1,'sample-9.png',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (47,2,'sample.png',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (47,3,'sample.9.png',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (47,4,'sample_9.png',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (48,1,'ネイティブメソッドでは、参照型として文字列を使うことはできない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (48,2,'C/C++ にマッピングされるので、int は jint と宣言されなくてならない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (48,3,'ネイティブメソッドでは、ビジビリティをプライベートと宣言することはできない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (48,4,'問題なくコンパイルされる。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (49,1,'「adb start-server」コマンドは adb サーバーを起動する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (49,2,'「adb install」コマンドは apk をインストールする。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (49,3,'「adb devices」コマンドは接続されたハンドセットとエミュレーターをリストする。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (49,4,'「adb copy」コマンドはターゲットにファイルをコピーできる。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (50,1,'Activity の開始',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (50,2,'BroadcastReceiver の開始',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (50,3,'Service の開始',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (50,4,'ContentProvider の開始',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (51,1,'アプリケーションのレイアウトとレイアウト階層を最適化する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (51,2,'リビジョン 4 以降、SDK ツールとして使用できる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (51,3,'コマンドラインで使用されるツールであり、GUI はない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (51,4,'レイアウトファイルで動作する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (52,1,'Jscript',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (52,2,'Perl',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (52,3,'BeanShell',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (52,4,'Lua',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (53,1,'Java の例外は、ネイティブメソッドで生成することができるが、Java 側ではキャッチできない。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (53,2,'JN Iは、Java VM のメモリー上の領域以外、ネイティブ側にはガベージコレクションを行わない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (53,3,'Java 側で生成されたヘッダーファイルが含まれており、ネイティブ（C/C++）側のソースコードで実装される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (53,4,'JNI でネイティブコードを使用していたとしても、アプリケーションの処理スピードが必ずしも向上するわけではない。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (54,1,'AndroidFS',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (54,2,'ext3',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (54,3,'FAT32',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (54,4,'NTFS',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (55,1,'GNU General Public License',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (55,2,'Berkeley Software Distribution License',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (55,3,'GNU Lesser General Public License',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (55,4,'Apache License 2.0',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (56,1,'network speed 3g',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (56,2,'network speed gsm',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (56,3,'network speed edge',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (56,4,'network speed 14.4 80',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (57,1,'mksdcard -l mysd 2048MB mysd.img',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (57,2,'mksdcard -l 2048 mysd.img',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (57,3,'mksdcard -create -I mysd 2GB mysd.img',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (57,4,'mksdcard -create -I mysd 2048 mysd.img',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (58,1,'Android SDK および AVD Manager ツールの起動機能',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (58,2,'SDK アップデート機能',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (58,3,'Android プロジェクトを作成および削除する機能',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (58,4,'AVD （Android Virtual Device） を作成および編集する機能',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (59,1,'トレースファイルは SD カードに保存されるので、開発者はファイル名を指定しなくてはならない。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (59,2,'Traceview は、SDK のツールのひとつであり、コマンドラインまたは DDMS から使用することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (59,3,'トレースファイルを作成するには、プロファイルを作成する部分の始めと終わりの位置を指定するメソッドを書かなければならない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (59,4,'Traceview はトレースファイルをそのままの状態で使えないため、adb が有効な開発マシンを使う必要がある。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (60,1,'public class ReceiverSample extends BroadcastReceiver{\npublic void onReceive(Context context, Intent intent) {}\n}',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (60,2,'public class ReceiverSample extends BroadcastReceiver {\npublic void onCreate(Context context, Intent intent) {}\n}',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (60,3,'public class ReceiverSample implements BroadcastReceiver {\npublic void onReceive(Context context, Intent intent) {}\n}',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (60,4,'public class ReceiverSample implements BroadcastReceiver{\npublic void onCreate(Context context, Intent intent) {}\n}',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (61,1,'jsonファイル',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (61,2,'Javaオブジェクト',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (61,3,'XMLファイル',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (61,4,'SQLite',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (62,1,'Intent.ACTION_VIEW',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (62,2,'Intent.Action_View',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (62,3,'Intent.View',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (62,4,'Intent.VIEW',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (63,1,'マニフェストファイル',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (63,2,'レイアウトファイル',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (63,3,'プロパティファイル',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (63,4,'ソースファイル',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (64,1,'void createDialog(int id);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (64,2,'void createDialog();',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (64,3,'void show();',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (64,4,'void showDialog(int id);',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (65,1,'Notification は、ライトの点滅とともにステータスバーにアイコンを表示することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (65,2,'Notification は、動画とともにステータスバーにアイコンを表示することができる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (65,3,'Notification は、メロディーとともにステータスバーにアイコンを表示することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (65,4,'Notification は、バイブレーションとともにステータスバーにアイコンを表示することができる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (66,1,'classfile',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (66,2,'srecfile',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (66,3,'jarfile',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (66,4,'dexfile',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (67,1,'http://',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (67,2,'market://search?',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (67,3,'content://',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (67,4,'android://',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (68,1,'(1) フォアグラウンド (2) バックグラウンド (3) ビジブル',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (68,2,'(1) ビジブル (2) バックグラウンド (3) フォアグラウンド',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (68,3,'(1) フォアグラウンド (2) ビジブル (3) バックグラウンド',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (68,4,'(1) ビジブル (2) フォアグラウンド (3) バックグラウンド',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (69,1,'タグフォーマットのテーマは、AndroidManifest.xml で指定できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (69,2,'テーマは、アプリケーションとアクティビティだけでなく、個々のビューにも適用できる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (69,3,'テーマの <style> 定義で、継承させたい「親」の属性を指定することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (69,4,'setTheme(...) メソッドを使うとアクティビティのテーマを動的に指定することができる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (70,1,'SD カードは FAT ファイルシステムをサポートする。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (70,2,'SD カードのディレクトリは、Environment.getExternalStorageDirectory() で取得できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (70,3,'Linux ファイルシステムのパーミッションは SD カードには存在しない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (70,4,'SD カード上のファイルは、Java.io.File では扱えない。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (71,1,'Android ビューの invalidate() メソッドを呼び出せる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (71,2,'レイアウト ビューとピクセル パーフェクト ビューの 2 つのウィンドウがある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (71,3,'ピクセル パーフェクト ビューは、ツリー ビュー、プロパティ ビュー、ワイヤーフレーム ビューの 3 つのビューからなる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (71,4,'レイアウトファイルのパフォーマンスに関する問題を検知できる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (72,1,'トランザクションをサポートする。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (72,2,'サーバーのインストールへのサポートがある。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (72,3,'ビューをサポートする。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (72,4,'トリガーをサポートする。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (73,1,'adb',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (73,2,'etc 1 tool',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (73,3,'keytool',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (73,4,'fastboot',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (74,1,'dialog.inflate(R.layout.custom_dialog);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (74,2,'dialog.setContentView(R.layout.custom_dialog);',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (74,3,'dialog.setLayout(R.layout.custom_dialog);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (74,4,'dialog.getinflate().inflate(R.layout.custom_dialog);',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (75,1,'ネイティブコードのみで、Android アプリケーションを開発できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (75,2,'Datvik VM なしで実行できるため、高速パフォーマンスを実現できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (75,3,'ソースコードは複雑になるが、デバッグとそのほかの操作が容易なので、NDK の使用が推奨される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (75,4,'ネイティブコードで、共有ライブラリを作成できる。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (76,1,'Android は、GPLのもとでライセンスが供与されている Linux を使う。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (76,2,'Android 用に開発されたアプリケーションは、GPLのもとでライセンスが供与される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (76,3,'Android プラットフォームに含まれているライブラリはすべて同じライセンスを共有している。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (76,4,'Linux以外、Android プラットフォームの大部分には、Apache License 2.0が適用される。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (77,1,'android.net',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (77,2,'org.apache.http',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (77,3,'android.location',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (77,4,'java.net',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (78,1,'android.framework',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (78,2,'android.framework-tests',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (78,3,'android.test.runner',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (78,4,'android test',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (79,1,'ローカルのファイルシステムにファイルとして保存する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (79,2,'PreferencesActivity を拡張し、XML ファイルで保存する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (79,3,'Dictionary クラスを使って、ハッシュ表ファイルで保存する。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (79,4,'SQLite を使ってデータベースに保存する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (80,1,'IDL',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (80,2,'KML',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (80,3,'AIDL',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (80,4,'XML',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (81,1,'一般的に、ファイルはアプリケーションごとに専用のリソースとして扱われる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (81,2,'アプリケーションによって作成されたファイルのコンテンツは、ほかのアプリケーションからはアクセスできない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (81,3,'あるアプリケーションによって作成されたファイルは、ほかのアプリケーションからも直接アクセスできる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (81,4,'ファイルにアクセスするために、Context クラスに FileStream メソッドが用意されている。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (82,1,'アクティビティ',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (82,2,'サービス',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (82,3,'インテント',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (82,4,'ビュー',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (83,1,'AndroidManifest.xml で、 <application> タグの子タグとして <uses-permission> タグを追加する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (83,2,'AndroidManifest.xml で、 <application> タグの子タグとして <permission> タグを追加する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (83,3,'AndroidManifest.xml で、 <manifest> タグの子タグとして <permission> タグを追加する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (83,4,'AndroidManifest.xml で、 <manifest> タグの子タグとして <uses-permission> タグを追加する。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (84,1,'Started',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (84,2,'Initialized',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (84,3,'Idle',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (84,4,'Preparing',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (85,1,'強制的にガベージコレクションを実行し、現在のヒープ使用状況を確認することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (85,2,'ネットワークゾーンの速度と帯域幅制限のシミュレーションを行うことができる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (85,3,'ターミナルのスクリーンショットを取得するのに用いることができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (85,4,'現在実行中のスレッドのリストを表示し、選択してスタックトレースを確認することができる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (86,1,'ターミナルで、HOSTADR= <デバイスの IP アドレス>と設定する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (86,2,'ターミナルで、ADBHOST= <デバイスの IP アドレス>と設定する。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (86,3,'ターミナルで、HOSTIP= <デバイスの IP アドレス>と設定する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (86,4,'ターミナルで、ADBIP= <デバイスの IP アドレス>と設定する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (87,1,'broadcast Intent を受け取る',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (87,2,'明示的 Intent を受け取る',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (87,3,'暗黙的 Intent を受け取る',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (87,4,'登録されたパーミッションにより、Intent を受け取る',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (88,1,'レイアウトの定義はコードで行っても、XML レイアウトファイルで行っても、違いはない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (88,2,'XML レイアウトファイルに書かれているレイアウト情報は、スクリーンが表示されると Android プラットフォームによってコードに変換される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (88,3,'ADT プラグインを使用する Eclipse プロジェクトでは、XML レイアウトファイルは [/res/layout] のディレクトリにある。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (88,4,'XMLレイアウトファイル「main.xml」で定義された UI を表示するためには、文字列パラメータ「Bmain.xml」で Activity の setContentView メソッドを呼び出す。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (89,1,'カラムに格納された値は、Null、Integer、Real、Text、Blob の 5 つのデータ型に分類される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (89,2,'SQLite は、単一のファイルでデータを保存するデータベースである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (89,3,'SQLite は Android にロードされると、いくつかの機能が制限される。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (89,4,'トランザクション管理機能がついており、トランザクションを開始するとストレージがロックされるよう設計されている。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (90,1,'Android のテスト フレームワークを利用するには、物理デバイスが必要である。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (90,2,'Android のテスト フレームワークは、JUnit4 に基づいている。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (90,3,'Activity イベントのユニットテストを作成するには、アクティビティの instrumentationTestCase を拡張するテストクラスを作成する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (90,4,'Android のテスト フレームワークでユニットテストを行うには、AndroidManifest.xml に設定を加える必要がある。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (91,1,'クライアントサーバーフォーマットである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (91,2,'オブジェクトデータベースである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (91,3,'ContentProvider を通じて、ほかのアプリケーションからもアクセスできる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (91,4,'SQLOpenHelper を使って、データベースの作成とアクセスができる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (92,1,'設定されていない場合は「false」として処理される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (92,2,'アプリケーションをリリースするときは、android:debuggable を削除することが推奨される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (92,3,'Eclipse のブレークポイント機能を使用するには、この属性を「true」に設定する必要がある。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (92,4,'android:debuggable の設定値は、アプリケーションで読み取ることができる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (93,1,'Android SDK と AVD Manager からダウンロードできる開発ツールは、SDK プラットフォーム、NDK プラットフォーム、エミュレーターイメージ、ハンドセット用 USB ドライバーである。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (93,2,'SDK バージョン 1.6 より提供されている。バージョン 1.5 までは、AVD Manager はあったが、SDK の管理機能が欠けていた。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (93,3,'[/tools] がコマンドのパスに追加されると、「android」コマンドが使用できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (93,4,'AVD を作成し起動でき、起動時にその時点までのユーザーデータを削除することができる。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (94,1,'MenuItem では、メニューコンポーネントをクリックしたときに発行される Intent を決定できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (94,2,'MenuItem では、チェックボックスを設定できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (94,3,'MenuItem では、アイコンまたはテキストを表示できる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (94,4,'MenuItem のインスタンスは、Menu クラスの add(...) メソッドで返される。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (95,1,'Layout Editor',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (95,2,'Menu Editor',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (95,3,'Resource Editor',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (95,4,'View Editor',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (96,1,'setAudioStreamType は AudioManager で定義されたものから選んで、型を設定する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (96,2,'setDataSource は再生したいデータへのパスを設定する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (96,3,'setLooping は繰り返しのオン/オフを設定する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (96,4,'setDisplay は関連付けたい SurfaceView オブジェクトを設定する。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (97,1,'MediaController インスタンスを必要とする。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (97,2,'ソースに URI を指定できる。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (97,3,'XML ファイルで動画を定義する必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (97,4,'MediaPlayer インスタンスを必要とする。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (98,1,'BroadcastReceiver によってアクティブ化されるプロセスは強制終了できないように保護される。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (98,2,'BroadcastReceiver は、ブロードキャスト先に基づいてオプションの処理結果のソースを通知する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (98,3,'BroadcastReceiver は、getReceive() を実行しているときにのみアクティブとみなされる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (98,4,'BroadcastReceiver は、ユーザーインタフェースを表示する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (99,1,'BroadcastReceiver',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (99,2,'Service',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (99,3,'Activity',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (99,4,'ContentProvider',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (100,1,'パッケージ名は同じである必要はなく、.apk は異なるプライベートキーで署名してもよい。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (100,2,'パッケージ名は同じでなければならず、.apk は同じプライベートキーで署名しなければならない。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (100,3,'パッケージ名は同じでなければならないが、.apk は異なるプライベートキーで署名する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (100,4,'パッケージ名は同じである必要はないが、.apk は同じプライベートキーで署名しなければならない。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (101,1,'REAL',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (101,2,'INTEGER',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (101,3,'VARCHAR',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (101,4,'BLOB',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (102,1,'ストレステストを実行でき、新しいバグを発見することもある。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (102,2,'全イベントを網羅したテストを実行できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (102,3,'エラーが見つかっても、同じ動作状態を何度も再生することができない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (102,4,'イベント間のインターバルを可能な限り縮めるため、過度にロードされた状態で動作する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (103,1,'アイコン名やアプリケーション名は、AndroidManifest.xml で指定される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (103,2,'AndroidManifest.xml ファイルが存在しない場合は、Android の標準設定が適用される。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (103,3,'AndroidManifest.xml はリソースファイルの一種である。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (103,4,'アプリケーションで使われているコンポーネント (アクティビティやサービスなど) は、AndroidManifest.xml で定義される。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (104,1,'更新機能がないため、アプリケーション内で個別に実装する必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (104,2,'マニフェストファイルの属性、versionCode を追加し、マニフェストファイルをアップロードする。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (104,3,'更新された認証で署名し、アップロードする必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (104,4,'マニフェストファイルの属性、versionCode を追加し、最新のアプリケーションをアップロードする。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (105,1,'Activity',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (105,2,'Service',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (105,3,'ContentProvider',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (105,4,'Intent',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (106,1,'Activity が実行されているときに、別の Activity のインスタンスが作成されると、onPause() が実行される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (106,2,'Activity がフォアグラウンドに表示されると、onResume() が実行される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (106,3,'Activity を再度表示すると、onStart() の代わりに、onRestart() が実行される。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (106,4,'Activity が onPause() から復帰すると、onCreate() から実行されることがある。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (107,1,'raw',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (107,2,'gif',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (107,3,'tiff',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (107,4,'jpg',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (108,1,'ListView で Adapter クラスを使っている配列を表示するときは、それを Collection クラスに変換する必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (108,2,'ListView は ListActivity とセットで使用する必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (108,3,'ListView には、TextView 以外にも、一意に定義された View のリストを表示する機能がある。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (108,4,'ListView には表示する情報がないときにメッセージを表示する機能がある。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (109,1,'Android では、アプリケーションのライセンス実施に関する特別な規定はない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (109,2,'Android は、GPL、BSD、LGPL とさまざまな方法によってライセンス許可されたライブラリを使っているため、Android の下で開発されたアプリケーションは、もっとも厳しいライセンス契約、GPL に従う。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (109,3,'アプリケーションが Android を使用して開発された場合、ソースコードが公開されなくてもライセンス違反にはならない。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (109,4,'Android で有償のアプリケーションを開発するには、Android マーケットに登録し、ライセンス料を支払う必要がある。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (110,1,'「Touch 1」が画面上に表示される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (110,2,'「Touch2」が画面上に表示される。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (110,3,'ボタンは画面上に表示されない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (110,4,'ボタンを押しても何も起こらない。',1);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (111,1,'連絡先リスト',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (111,2,'データベース',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (111,3,'ブックマーク',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (111,4,'通話履歴',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (112,1,'MediaPlayer.create(this, R.raw.music);',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (112,2,'MediaPlayer.getSource(this, R.raw.music);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (112,3,'newMediaPlayer(this, R.raw.music);',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (112,4,'MediaPlayer.newInstance(this, R.raw.music),',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (113,1,'res/raw',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (113,2,'system/data',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (113,3,'data/data',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (113,4,'res/values',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (114,1,'データベースファイルは複数あってよい。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (114,2,'アプリケーションがデータベースファイルを所有している。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (114,3,'パスワードを設定する必要がある。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (114,4,'データベースのファイル名には、「.db」の拡張子をつける必要がある。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (115,1,'電話の発信のエミュレーション',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (115,2,'ヒープとスレッドの情報の表示',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (115,3,'E メールの受信',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (115,4,'処理の終了',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (116,1,'クラスファイルを Dalvik 実行可能フォーマット (dex ファイル) に変換する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (116,2,'変換に使われるファイルのタイプは、class、jar、および zlib のみである。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (116,3,'Eclipse を使えば、明示的に呼び出す必要はない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (116,4,'コマンドラインから使用するツールであり、GUI はない。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (117,1,'Service',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (117,2,'ContentProvider',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (117,3,'MediaPlayer',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (117,4,'Activity',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (118,1,'onCreate() メソッドと onUpgrade() メソッドを実装し、android.database.sqlite.SQLiteOpenHelper クラスを拡張、そして getWritableDatabase() メソッドを呼び出す。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (118,2,'android.database.sqlite.SQLiteOpenHelper クラスのインスタンスを宣言し、onCreate()、onUpgrade()、そして getWritabieDatabase() をそれぞれ呼び出す。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (118,3,'onCreate() と onUpgrade() メソッドの実装を書き、android.database.SQLiteOpenHelper インターフェースを実装、ApplicationContext.createOrOpenDatabase() にパラメーターとして渡す。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (118,4,'ApplicationContext メソッドの createDatabase() と openDatabase() を呼び出す。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (119,1,'Android は携帯電話を含めた、携帯デバイスのみのプラットフォームである。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (119,2,'Android は、オープンソースとしてGoogle からリリースされた。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (119,3,'Android 上で動作するアプリケーションは、Java で開発することができる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (119,4,'Android は、3G、Wi-Fi、および GPS のみならず、加速度計やコンパスなどのセンサーをも制御する標準 API を提供する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (120,1,'目的のアクティビティを直接指名して送信する。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (120,2,'目的のアクティビティを直接指名せずに送信する。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (120,3,'実は送信されない。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (120,4,'目的のサービスを直接指名して送信する。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (121,1,'このアプリケーションのバージョンは「1」である。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (121,2,'Android 1.6 以降のターミナルで実行可能なアプリケーションである。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (121,3,'「android:label」がアクティビティ タグで設定されていないため、アプリケーションのヘッダーには何も表示されない。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (121,4,'構成されたアクティビティは、アプリケーションのエンドポイントとなるアクティビティである。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (122,1,'ASE ではスクリプトを実行できるが、編集したり、新規文書を作成したりはできない。',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (122,2,'ASE を使った開発は、ターミナルを使ってインタラクティブに行える。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (122,3,'ASE は Android アプリケーションであり、Python といったスクリプト言語を実行できる。',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (122,4,'ASE を使った通話のために API がある。',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (123,1,'ACCOUNT MANAGER',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (123,2,'BLUETOOTH',1);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (123,3,'BLUETOOTH_ADMIN',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (123,4,'ACCESS_WIFI_STATE',0);

@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (124,1,'READ_OWNER_DATA',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (124,2,'READ_ADDRESS_DATA',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (124,3,'READ_PHONE_STATE',0);
@@
INSERT INTO choices (question_id,choices_id,content,correct_flag) VALUES (124,4,'READ_CONTACTS',1);