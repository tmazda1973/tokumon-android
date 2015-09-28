INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (1,1,1,'Android アプリケーションフレームワークに含まれていないのは、次のうちどれですか','choices',4,1,NULL, 'DialerManager が Android アプリケーションフレームワークには含まれていません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (2,1,1,'複数回呼び出される可能性のあるサービス定義のイベントは、次のうちどれですか？','choices',4,1,NULL, ' onCreateはサービスのインスタンス生成時(複数回startServiceを実行した場合、初回のみ)呼び出されます。\nonDestroyはサービス終了のタイミングで1回だけ呼び出されます。\nonBindはバインド時(接続時)に呼び出されますが、Unbind（バインド解除）後に再度バインドする際はonRebindが使用されるため、1回だけ呼び出されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (3,1,1,'ProgressDialog の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'ProgressDialog の setContentView メソッドでは定義されたカスタムレイアウトを適用できません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (4,1,1,'センサーがアクセスされたときに使用されるクラスは、次のうちどれですか？','choices',4,1,NULL, 'SensorManager インスタンスに対し、センサーを受信するためのリスナーを登録することで、センサーへのアクセスに応答します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (5,1,1,'Bluetooth デバイスを探知し、リンクされたデバイスと通信するクラスは、次のうちどれですか？','choices',4,1,NULL, 'BluetoothDeviceクラスはリンクされたデバイスとの通信の他に、デバイスの名前、アドレス、クラス、および結合状態等のデバイスに関する情報を取得します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (6,1,1,'Ul/Application Exerciser Monkey （モンキーツール）の機能として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'Monkeyはエミュレーターまたは端末上で動くプログラムであり、クリック、タッチ、ジェスチャーさらにはシステムレベルのイベントなどランダムな動作を発生させることができます。Monkeyを用いると、開発中のアプリケーションに対して、繰り返しが可能なランダム動作による負荷テストを実施することが可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (7,1,1,'アプリケーションを公開するときのプライベートキーに関する記述として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'SDK ツールで生成されたデバッグキーで署名されたアプリケーションは公開できません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (8,1,1,'スクリーン表示の状態の定義でないものは、次のうちどれですか？','choices',4,1,NULL, 'Activityは“状態”を持っています。　アクティビティが表示されていて、操作可能な状態を「フォアグラウンド」、表示されていない状態を「バックグラウンド」、アクティビティが表示されているが操作できない状態を「ビジブル」と呼びます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (9,1,1,'Traceview の機能として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'android.os.Debug.startMethodTracing と android.os.Debug.stopMethodTracingにて指定した箇所のログを取得し、それらをTraceview にてグラフィカルに表示できます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (10,1,1,'ADT （Android Development Tools） プラグインが提供していない機能は、次のうちどれですか？','choices',4,1,NULL, 'View を組み合わせてレイアウトを作成するサポート機能はありますが、 View の作成をサポートする機能はありません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (11,1,1,'adb (Android Debug Bridge) を使ったネットワークを通じてハンドセットでデバッグを行う際に必要な操作は、次のうちどれですか？','choices',4,1,NULL, 'adbを使用してデバッグを行う際は、環境変数 ADBHOSTにIPアドレスをセットする必要があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (12,1,1,'個々の ContentProvider を作成し、それを使用するときのデータアップデート通知に必要な処理として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'ContentResolverクラスのnotifyChange(Uri uri, ContentObserver observer)を使用することで、データアップデート通知を行います。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (13,1,1,'DalvikVM コアライブラリは、次のどのサブセットですか？','choices',4,1,NULL, 'Androidのすべてのアプリケーションは、Dalvik VM上で動作します。Dalvik VMは、Java VMと同様、メモリー管理をガベージ・コレクタ*が担当している。開発者がメモリーの確保と解放を明示的に実行しないでも、メモリー・リークによる深刻なシステム破壊を防いでいます。 Dalvik VM のコアライブラリは、「Java Platform, Standard Edition(Java SE)のサブセット＋Android拡張」です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (14,1,1,'Eclipse で Android を開発するために必要なプラグインは、次のうちどれですか？','choices',4,1,NULL, 'Eclipse で開発するためには ADT (Android Development Tools) が必要です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (15,1,1,'Android のセキュリティ機能の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'ネットワークやハードウェアなどの機能を使う際は、マニュフェストファイルに適切なパーミッションを設定する必要があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (16,1,1,'SharedPreferences のアクセスモード定数として定義されないものは、次のうちどれですか？','choices',4,1,NULL, 'MODE_PUBLIC：定義されていません。\nMODE_WORLD_WRITEABLE：他のアプリから書き込み可能です。\nMODE_WORLD_READABLE：他のアプリから読み取り可能です。\nMODE_PRIVATE：そのアプリケーションのみ使用可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (17,1,1,'android.content.Context.openFileOutput("sample.txt", 0) を実行したとき、次のどのパスにファイルが保存されますか？','choices',4,1,NULL, '/data/data//files にファイルが保存されます。他のパス指定はできません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (18,1,1,'リソースからビデオを読み込むとき、Android において推奨されるビデオファイルの保存場所は、次のうちどれですか？','choices',4,1,NULL, '/res/rawに配置することで、自動的にリソースIDが採番されるため、ファイルの呼び出し時に利用できます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (19,1,1,'Android はメモリが不十分になると、重要度が低い順にプロセスを破棄します。重要度が高いものから低いものへと並んでいるプロセスは、次のうちどれですか？','choices',4,1,NULL, 'プロセスの優先順位は以下のとおりです。\n①Foreground（フォアグラウンド プロセス）\n　ユーザーがその時点で行っている作業に必要なプロセス\n②Visible（可視プロセス）\n　フォアグラウンドではないものの、ユーザーが見ている画面に影響を及ぼすことのできるプロセス\n③Service（サービス プロセス）\n　サービスが保持しているプロセス\n④Background（バックグラウンド プロセス）\n　現在ユーザーに画面を表示していない停止したプロセス\n⑤Empty（空のプロセス）\n　何もしていないプロセス　次回の起動時間を短くするために維持されているもの。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (20,1,1,'サイズユニットについて、デバイス非依存の Android で指定できるのは、次のうちどれですか？','choices',4,1,NULL, 'px：画面の実際のピクセル数で計測するため、デバイスによって、1インチ当たり異なるピクセル数を持つ可能性があります。\ndp（dip）：仮想的なピクセル単位で、160dpiの画面では1dpは1pxと対応します。\nsp：ユーザーが設定したフォントサイズによって自動的にスケールされます。\npt：スクリーンの物理サイズに基づいた 1/72 インチです。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (21,1,1,'Toast クラスの説明として間違っているものは、次のうちどれですか？\n','choices',4,1,NULL, 'トーストに XML で定義されたカスタムレイアウトを設定できますが、トーストをカスタムレイアウトに設定することはできません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (22,1,1,'デバイスの [メニュー] ボタンが押されたときに表示されるメニューを作成する際、オーバーライドしなくてはならない Activity クラスのメソッドは、次のうちどれですか？','choices',4,1,NULL, 'onCreateContextMenu はコンテキストメニューの生成です。onMenuOpened はオプションメニューの表示時に実行されます。openOptionsMenu はオプションメニューの表示です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (23,1,1,'AIDL （Android Interface Description Language） の記述として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'AIDL ファイルにはインターフェイスとして１つ以上の関数を定義することができます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (24,1,1,'マニフェストファイルに <uses-sdk android:minSdkVersion-"6"/>が書かれているとき、対応する Android SDK の開発環境は、次のうちどのバージョンですか？','choices',4,1,NULL, 'minSdkVersionはアプリケーションが実行するために必要な最小の API レベルを指定します。Android システムは、システムの API レベルがこの属性で特定された値より低い場合に、ユーザがこのアプリケーションをインストールしないよう保護します。\nこの属性を宣言しない場合、この値は "1" とみなされ、Android のすべてのバージョンで互換性があることを示します。\nなお、API Level6はAndroid 2.0.1に対応します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (25,1,1,'複数のアプリケーションでデータを共有するための仕組みとして正しいものは、次のうちどれですか？','choices',4,1,NULL, 'ContentProviderは複数のアプリケーションでデータを共有するための仕組みで、アプリケーション間の連携、効率の観点から共通データタイプ(住所録、画像情報など)を定義しています。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (26,1,1,'ADT プラグインの新規プロジェクト ウィザードを完了すると自動生成されるフォルダーとして間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'Eclipse ADTプラグインは、src, bin, gen, assets, res等のフォルダを自動生成します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (27,1,1,'AndroidManifest.xml を設定せずとも使用できるコンポーネントは、次のうちどれですか？\n','choices',4,1,NULL, 'Intent のみ設定は不要です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (28,1,1,'作成された ContentProvider クラスを宣言するファイルとして正しいものは、次のうちどれですか？','choices',4,1,NULL, 'アプリケーションの部品であるすべてのコンテンツプロバイダはマニフェストファイルで provider 要素により表現されている必要があります。宣言されていなければ、システムがそれを参照できないことにより実行されなくなります');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (29,1,1,'AsyncTask.Status で定義されない変数は、次のうちどれですか？','choices',4,1,NULL, '7th attempt');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (30,1,1,'単体の Activity の機能テストを行うクラス、ActivityInstrumentationTestCase2 の各テストメソッドの終了後に呼び出されるのは、次のうちどれですか？','choices',4,1,NULL, 'runTestは現在のテストを実行します。tearDown は各テストメソッドの終了後に呼び出されます。setUp はテスト実行前の準備処理を実行します。setActivityIntent は ACTION_MAIN 以外でアクティビティを起動したい場合に使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (31,1,1,'以下の menu_option.xml は、デバイスの [メニュー] ボタンを押すと表示されるメニューのレイアウトを定義します。(1) に入るべきメニュー コンポーネントの記述は、次のうちどれですか？ \n\nres/menu/menu_option.xml\n\n\n01: <menu xmlns:android="http://schemas.android.com/apk/res/android">\n02: (1)\n03: menu>','choices',4,1,NULL, 'メニューのレイアウトを設定するためには、 Menu タグの子ノードとして item タグを設定します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (32,1,1,'Map API キーの説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'Google Mapを使用する場合は、Android SDKの証明書、または配布するアプリケーションに付与する証明書ごとにAPI Keyを取得する必要があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (33,1,1,'AAPT (Android Asset Packaging Tool) の説明として正しいものは、次のうちどれですか？\n','choices',4,1,NULL, 'Android Asset Packaging Tool (aapt)とは、バイナリーとリソースを含んだアンドロイドアプリケーションのapkファイルを作成するツールです。\napkファイルはZIP形式の圧縮されたファイルとなっています。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (34,1,1,'zipalign の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'zipalign はアーカイブを整列するツールで、Android アプリケーション ( .apk ) で重要な最適化を提供します。すべての未圧縮データが、ファイルの開始位置から相対的な特定の位置合わせで始まることを保証することがこのツールの目的です。具体的には、.apk 内のイメージや生のファイルといった未圧縮データを 4 バイトバウンダリに整列させるようにします。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (35,1,1,'adb(Android Debug Bridge) の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'adb(Android Debug Bridge)は Android SDK の platform-tools に含まれるツールであり、このツールを用いると、現在利用可能なデバイス・エミュレータの列挙、シェルコマンドの発行、ファイルの転送などが行えます。\nadb は主に adb クライアント と adb サーバー から構成されます。\nadb クライアントを起動すると、adb クライアントは現在実行中の adb サーバーを探します。サーバーが見つからない場合は、adb サーバープロセスを起動します。\nadb サーバープロセスは起動後 TCP ポートの 5037 番で待ち受けを開始します。 adb クライアントは、5037 番ポートに接続に行きます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (36,1,1,'以下のメソッドに関する説明として正しいものは、次のうちどれですか？\n\n(1) android.content.Context.sendBroadcast \n\n(2) android.content.Context.startActivity\n','choices',4,1,NULL, 'どちらのメソッドも Intent をブロードキャストできます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (37,1,1,'以下のコードを実行すると、TextView01 に表示されるのは、次のうちどれですか？ \n--------------------------------------------------------\n01: import android.app.Activity;\n02: import android.os.Bundle;\n03: import android.widget.TextView;\n04:\n05: public class ExampleActivity extends Activity {\n06:     private TextView textView;\n07:\n08:     @Override\n09:     public void onCreate(Bundle savedInstanceState) {\n10:       super.onCreate(savedlnstanceState);\n11:       setContentView(R.layout.main);\n12:       textView = (TextView)findViewById(R.id.TextView01);\n13:\n14:       new Thread(new Runnable() {\n15:          public void run() {\n16:              textView.setText("Hello");\n17:          }\n18:       }). start ();\n19:       textView.setText("Hello World");\n20:     }\n21: }\n--------------------------------------------------------','choices',4,1,NULL, 'onCreate メソッドの内容が順次実行されますが、途中で新たなスレッドを作成し、その中で textView の表示内容を "Hello" に設定しています。\n次に続く onCreate メソッドの"Hello World" の設定処理とは別スレッドで "Hello" の設定処理が実行されるため、どちらが早く動作するかは確定していません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (38,1,1,'個々のビューを作成するメソッドとして、『Android 開発ガイド』で推奨されていないものは、次のうちどれですか？\n','choices',4,1,NULL, 'AndroidSDK にて提供されているクラスはコピーせずに拡張して作成することが推奨されています。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (39,1,1,'以下のコードは、ステータスバー通知を送信するプログラムの一部です。送信後、自動的に通知をキャンセルするために、(1)に挿入するコードとして正しいものは、次のうちどれですか？\n--------------------------------------------------------\nNotification notification = new Notification(icon, tickerText, when);\nnotification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);\n    (   1   )\nnotificationManager.notify(1, notification);\n--------------------------------------------------------','choices',4,1,NULL, 'Notification クラスは flags を保持していますが、 setter が存在しないため、値を直接代入します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (40,1,1,'HTTP やソケットの通信の実装に必要なパーミッションは、次のうちどれですか？','choices',4,1,NULL, 'ソケット通信ではインターネット接続を行うので、パーミッションにandroid.permission.INTERNETを追加する必要があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (41,1,1,'android.net パッケージに含まれていないクラスは、次のうちどれですか？','choices',4,1,NULL, 'WifiManager のみ、 android.net.wifi パッケージに含まれています。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (42,1,1,'アプリケーションへの署名の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'androidアプリを公開する場合、アプリ(apkファイル)にデジタル署名をつける必要があります。apkファイルに署名するためのコマンドがjarsignerです。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (43,1,1,'GPS にアクセスするために Android マニフェストファイルに追加される権限は、次のうちどれですか？','choices',4,1,NULL, 'GPS のアクセスには ACCESS_FINE_LOCATION の追加が必要です。エミュレータでの開発時に GPS を使用する場合には ACCESS_MOCK_LOCATION を使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (44,1,1,'Eclipse の LogCat ウィンドウへの出力ストリングに必要な android.util パッケージのクラスは、次のうちどれですか？','choices',4,1,NULL, 'ログを出力するには、android.util パッケージのLog クラスを使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (45,1,1,'セキュリティ設定を含めた Wi-Fi ネットワーク設定を行う wifi パッケージのクラスは、次のうちどれですか？','choices',4,1,NULL, 'ScanResult　・・・　スキャンして発見したアクセスポイントの情報を表示するクラス\nWifiConfiguration　・・・　セキュリティ設定を含めたWi-Fi ネットワーク設定を行うクラス\nWifilnfo　・・・　アクティブか否かに関わらず、Wifi接続の状態を表示するクラス\nWifiManager　・・・　Wifi接続のあらゆる面を管理できるクラス');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (46,1,1,'res/drawable/image.png ファイルで Bitmap オブジェクトを作成するコードとして正しいものは、次のうちどれですか？','choices',4,1,NULL, 'Bitmap オブジェクトを作成するには、「BitmapFactory」クラスで用意されているstaticメソッドの「decodeResource」メソッドを使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (47,1,1,'draw9patchを使って PNG から作成された NinePatch 画像のファイル名として正しいものは、次のうちどれですか？（元の画像ファイル名は、「sample.png」とします。）','choices',4,1,NULL, 'Draw9-patch ツールで PNG から作成されたイメージは、ファイル名が .9.png で保存されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (48,1,1,'Foo.java ソースコードの説明として正しいものは、次のうちどれですか？\n01: class Foo {\n02:   private native String bar(String s, int i, int j); \n03: \n04:   public static void main (String[] args) { \n05:     Foo foo = new Foo();\n06:     String str = foo.bar("JNI Problem", 2, 3);\n07:     System.out.println(str);\n08:   } \n09: \n10:   static {\n11:     System.loadLibrary("Foo");\n12:   } \n13: }\n--------------------------------------------------------','choices',4,1,NULL, '問題なくコンパイルされます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (49,1,1,'adb コマンドの説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, '間違っているものは「adb copy」です。 ファイルをコピーするためには「adb push」を使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (50,1,1,'Intent の役割として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'ContentProvider は Intent ではなく、主に ContentResolver オブジェクトを利用して操作を行います。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (51,1,1,'layoutopt の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'リビジョン 5 以降、SDK ツールとして使用できます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (52,1,1,'ASE（Android Scripting Environment）でサポートされていない言語は、次のうちどれですか？','choices',4,1,NULL, 'Android Scripting Environment（ASE）とは、Android上でPythonなどのスクリプト言語を実行するためのAndroidアプリケーションです。 \n対応しているスクリプト言語は、Python, Perl, JRuby, Lua, BeanShell, JavaScript, Tcl, shell です。 \n\nJScript は、マイクロソフト社製のスクリプト言語であり、Microsoft Windows 上で動作します。　JavaScriptと類似しており、Internet Explorer を使用したクライアントサイドスクリプティング処理、および Internet Information Services(IIS) などを使用したサーバサイドスクリプティング処理を記述することができます。 \n\n参考資料: \nhttp://code.google.com/p/android-scripting/');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (53,1,1,'JNI（Java Native Interface）の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'ネイティブメソッドで例外をスローした場合、 Java 側でキャッチできます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (54,1,1,'mksdcard コマンドによって作成されるディスク イメージのファイル システムは、次のうちどれですか？','choices',4,1,NULL, 'mksdcardは、Android仮想デバイス上でもSDカードをシミュレートできるようにFAT32のディスクイメージを作成してくれるツールです。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (55,1,1,'Android に適用されているライセンスは、次のうちどれですか？','choices',4,1,NULL, 'Apache 2.0, GPLv2, LGPLなどが適用されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (56,1,1,'Android Emulator のネットワーク速度エミュレーション機能からは実行できないコマンドは、次のうちどれですか？','choices',4,1,NULL, 'network speedのフォーマットは、以下のいずれかです。 ( 数値は キロビット / 秒 ) \n\ngsm  ⇒GSM/CSD( 上り: 14.4、下り: 14.4)\nhscsd  ⇒HSCSD( 上り: 14.4、下り: 43.2)\ngprs  ⇒GPRS( 上り: 40.0、下り: 80.0)\nedge  ⇒EDGE/EGPRS( 上り: 118.4、下り: 236.8)\numts  ⇒UMTS/3G( 上り: 128.0、下り: 1920.0)\nhsdpa  ⇒HSDPA( 上り: 348.0、下り: 14400.0)\nfull  ⇒制限なし( 上り: 0.0、下り: 0.0)\n"num"  ⇒アップロードとダウンロード両方で使用する正確なレートを設定\n"up":"down" ⇒アップロードとダウンロードを分けて正確なレートを設定\n\n以上より、3gという指定はできません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (57,1,1,'エミュレーターは、SD カードに代わり、ディスクイメージファイルのマウントをサポートします。その作成メソッドとして正しいものは、次のうちどれですか？','choices',4,1,NULL, 'mksdcard メソッドは -l の後に SD カードの名称を定義し、サイズの単位はキロバイトかメガバイトまで指定できます。create メソッドは定義されていません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (58,1,1,'「android」コマンドがサポートしない機能は、次のうちどれですか？','choices',4,1,NULL, 'プロジェクトの作成および削除は android コマンドでは出来ません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (59,1,1,'Traceview の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'SD カードにファイル名「tao.trace」として保存されるため、ファイル名の指定は不要です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (60,1,1,'BroadcastReceiver のコールバックを有効にするコードとして正しいものは、次のうちどれですか？','choices',4,1,NULL, 'BroadcastReceiver を使用するには BroadcastReceiver クラスを継承し、 onReceive メソッド内に処理を記載します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (61,1,1,'SharedPreferences を保持する方法として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'SharedPreferencesオブジェクトを取得した際、設定データは XML ファイルに保存されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (62,1,1,'以下のプログラムはウェブブラウザーに指定されたウェブページを開く Intent を使っています。(1) に当てはまるコードとして正しいものは、次のうちどれですか？\n\nIntent intent = new Intent("   (  1  )   ", Uri.parse("http://www.crammedia.com/"));\nstartActivity(intent);','choices',4,1,NULL, 'Intent の第一引数に ACTION_VIEW （アクション）を設定すると、第二引数の値を判断し、ウェブブラウザや地図のアプリを起動して表示することが可能です。\n電話をかける場合は ACTION_CALL 、電話をかける画面を表示する場合は ACTION_DIAL を使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (63,1,1,'GPS を使用するためのパーミッションが格納されている構成ファイルは、次のうちどれですか？','choices',4,1,NULL, 'GPS を使用するためには、マニフェストファイルの manifest の子要素に、以下のパーミッションの使用を宣言する必要があります。 \n\n<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (64,1,1,'以下のコードはダイアログを作成する Activity クラスの一部です。このダイアログを表示するために使用する Activity クラスのメソッドは、次のうちどれですか？\n--------------------------------------------------------\n01: @Override\n02: protected Dialog onCreateDialog(int id) {\n03:       return new AlertDialog.Builder(this).setMessage("message").create();\n04: }\n--------------------------------------------------------','choices',4,1,NULL, 'AlertDialog クラスで用意されている static メソッドである show メソッドを使用して、ダイアログを表示させることができます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (65,1,1,'Notification のステータスバーの説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'Notificationを用いることで、サウンド、バイブレーション、LEDを用いてアラートする事ができます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (66,1,1,'Dalvik VM の実行ファイルフォーマットは、次のうちどれですか？','choices',4,1,NULL, 'dexfile が使用されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (67,1,1,'Android でサポートしていない URI スキームは、次のうちどれですか？','choices',4,1,NULL, '"android://"はサポートしていません。\n"content://"はコンテンツプロバイダーへのアクセスに使用します。\n"http://"は URL の指定に使用します。\n"market://search?"は Android Marcket へのアクセスに使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (68,1,1,'アクティビティのライフサイクルを述べる (1 )～(3) の組み合わせとして正しいものは、次のうちどれですか？ \n\nオブジェクトの作成から破棄までのライフサイクルは、アクティビティとして定義されます。アクティビティには 3 つの状態があります:(1)、(2)、および (3) です。\n\n(1) は、アクティビティが画面に表示され、カーソルがポイントされている状態です。アクティビティが別のアクティビティにより非表示にされている状態が (2) です。ダイアログといった、 アクティビティではない画面が表示され、カーソルがない状態が (3) です。','choices',4,1,NULL, 'フォアグラウンド：アクティビティが画面に表示され、カーソルがポイントされている状態です。\nビジブル：ダイアログといった、 アクティビティではない画面が表示され、カーソルがない状態です。\nバックグラウンド：アクティビティが別のアクティビティにより非表示にされている状態です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (69,1,1,'テーマの説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'テーマの設定はアプリケーションかアクティビティのみ可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (70,1,1,'SD カードを使った外部ストレージの説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'SDカードを読み書きするにはjava.io.FileとFileInputStream、FileOutputStreamを使う必要があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (71,1,1,'Android SDK の階層ビューワーの説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'ツリー ビュー、プロパティ ビュー、ワイヤーフレーム ビューはいずれもレイアウト ビューの構成要素です。\nピクセル パーフェクト ビューはエクスプローラ ビュー、ノーマル ビュー、ルーペ ビューの 3 つのビューで構成されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (72,1,1,'SQLite の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'SQLiteはデータ保存に単一ファイルを使用する、クロスプラットホームの軽量リレーショナルデータベースシステムです。一般的なデータベースサーバーとは異なり、アプリに組み込まれて使われます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (73,1,1,'アプリケーションに署名する際に必要となる証明書を作成するツールは、次のうちどれですか？','choices',4,1,NULL, 'keytool を使用して証明書を作成します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (74,1,1,'以下のコードは、XML で定義されるダイアログ レイアウトに適用されます。(1) に当てはまるコードとして正しいものは、次のうちどれですか？(ダイアログ レイアウトは、res/layout/custom_dialog.xml で正しく定義されており、アプリケーションのそのほかの部分には問題がないものとします。) \n--------------------------------------------------------\n01: Dialog dialog = new Dialog(MainActivity.this);\n02: dialog.setTitle("Dialog");\n03: (1)\n04: dialog.show();\n--------------------------------------------------------','choices',4,1,NULL, 'setContentView メソッドにてダイアログに表示するレイアウトを設定します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (75,1,1,'Android NDK の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'Android NDK とは、Androidアプリケーションの一部をCやC++などネイティブコードで記述することが出来るようするツールです。\nネイティブコード部分についてはDalvik仮想マシンを介さず実行できるため、アプリケーションの高速化等のメリットがあります。（アプリケーションの”一部”をネイティブ化するので、Datvik VM なしでは実行できません。）\nまた、ネイティブコードで開発されたコードの再利用が可能になるというメリットもあります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (76,1,1,'Android ライセンスフォームの説明として間違っているものは、次のうちどれですか？\n','choices',4,1,NULL, 'Android プラットフォームは、Apache、BSD、LGPL等、多くのライセンスが存在しており、同じライセンスを共有するものではありません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (77,1,1,'Android のネットワーク接続に必要なクラスが含まれるパッケージとして間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'android.location は位置情報を取り扱う際に使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (78,1,1,'以下のマニフェストファイルは、Android ユニットテストを行うためのものです。(1) に当てはまる記述として正しいものは、次のうちどれですか？ \n--------------------------------------------------------\n01: xml version="1.0" encoding="utf-8"?>\n02: <manifest\n03:       xmlns:android="http://schemas.android.com/apk/res/android" \n04:       package="com.example.android.apis.tests"> \n05:       <application>\n06:          <uses-library android:name=" (1) " />\n07:       application> \n08:       <instrumentation\n09:          android:name="android.test.InstrumentationTestRunner"\n10:          android:targetPackage="com.example.android.apis"\n11:          android:label="Tests for Api Demos."/>\n12: manifest> \n--------------------------------------------------------','choices',4,1,NULL, 'uses-library要素はアプリケーションがリンクする必要がある共有ライブラリを特定します。この要素は、ライブラリのコードをパッケージに対するクラスローダに含めるようシステムに伝えます。\nInstrumentationTestRunnerは共有ライブラリの android.test.runner に存在していて、このライブラリは通常は Android コードとはリンクされていません。これをインクルードするために、uses-library 要素にその指定が必要となります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (79,1,1,'ローカルデータを保存するアプリケーションの方法として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'Dictionary クラスは非推奨のクラスであり、代替クラスは Map です。永続的なデータの保存は出来ません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (80,1,1,'Service をバインドするために使われるインタフェース定義として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'AIDL ( Android Interface Definition Language: Android インターフェイス定義言語 ) とは、Androidアプリにおいて、プロセス間通信（IPCないしRPC）のために利用するインタフェースです。　アクティビティとサービスが別プロセスで、互いに情報をやり取りしたい場合などに使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (81,1,1,'ファイルアクセスの記述として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'Androidのアプリケーションを起動するユーザーはアプリケーションで固有であり、ファイルアクセスも排他的になります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (82,1,1,'バックグラウンドで処理できる Android の機能は、次のうちどれですか？','choices',4,1,NULL, '解説：Androidの「サービス」は、バックグラウンドで処理を行いたい場合やバックグラウンドに常駐させたい場合に利用することができます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (83,1,1,'アクセス権限設定の方法として正しいものは、次のうちどれですか？','choices',4,1,NULL, '<uses-permission> と <application> タグは同列に扱います。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (84,1,1,'Idle 状態の MediaPlayer インスタンスが setDataSource() を実行すると、インスタンスは次のどの状態に遷移しますか？','choices',4,1,NULL, 'Initialized 状態に遷移するため、 start メソッドにて再生します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (85,1,1,'ddms の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'ddms （デバッグモニタサーバ（ Dalvik Debug Monitor Server ））はモニタとして情報の閲覧がメインであり、ネットワークに関する設定を変更することはできません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (86,1,1,'携帯デバイスで adb (Android Debug Bridge) を使ったデバッグの説明として正しいものは、次のうちどれですか？(開発環境は Windows コンピューターとします。)','choices',4,1,NULL, 'ADBHOST にデバイスの IP アドレスを設定する必要があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (87,1,1,'BroadcastReceiver の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, '明示的な Intent を受け取ることはできません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (88,1,1,'XML レイアウトファイルの説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'XML レイアウト ファイルは、作成するプロジェクトの res/layout/ ディレクトリ内に置かれます。「res」は「resources」の略で、アプリケーションに必要なコード以外のすべてのアセットがこのディレクトリに格納されます。リソースには、レイアウト ファイルの他に、画像、音声、ローカライズされた文字列などのアセットがあります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (89,1,1,'SQLite の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, '\nSQLite を Android で使用しても機能の制限はありません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (90,1,1,'Android のテスト フレームワークの説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'AndroidManifest.xml に instrumentation タグを設定する必要があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (91,1,1,'SQLite の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, '特定、不特定のアプリケーションからのアクセスを制御することが出来ます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (92,1,1,'AndroidManifest.xml の タグの android:debuggable 属性に関する説明として、間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'AndroidManifest.xml 内の android:debuggable 属性は、アプリケーションのデバッグが可能かどうかを指定するもので、ユーザモードでデバイス上での実行時でも有効です。デフォルト値は "false" です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (93,1,1,'Android SDK と AVD Manager の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'ダウンロードできる開発ツールとして GoogleAIPs や samples 等も挙げられます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (94,1,1,'MenuItem インタフェースの説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'android.view.Menultem インタフェースは、前に作成したメニューアイテムに直接アクセスするためのインタフェースです。 \nアイコンまたはテキストを表示できます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (95,1,1,'ADT (Android Development Tools) プラグインが提供する Eclipse で画面を作成・編集するためのツールは、次のうちどれですか？','choices',4,1,NULL, 'Androidの画面作成には、ADTプラグインのLayout Editorを使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (96,1,1,'MediaPlayer でビデオを再生するときのメソッドの設定として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'setDisplay には関連付けたい SurfaceHolder オブジェクトを設定します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (97,1,1,'VideoView クラスを使った動画の再生についての正しい記述は、次のうちどれですか？','choices',4,1,NULL, 'URI または ファイルパスの指定が可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (98,1,1,'BroadcastReceiver の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'ブロードキャスト レシーバは、ブロードキャストの連絡を受信してそれに対処するだけのコンポーネントです。ブロードキャストの多くが元々はシステム コードで、たとえばタイム ゾーンが変更されたこと、電池の残量が少なくなったこと、写真が撮影されたこと、ユーザーが言語設定を変更したことなどを連絡するために使用します。アプリケーションでも、たとえば何らかのデータがデバイスにダウンロードされて利用できるようになったことを、他のアプリケーションにブロードキャストで知らせることができます。\nアプリケーションでは、重要と思われるすべての連絡に応答できるよう、ブロードキャスト レシーバをいくつでも設定できます。すべてのレシーバは、BroadcastReceiver 基本クラスの拡張です。 \n\nブロードキャスト レシーバがアクティブになっているプロセスは、強制終了しないよう保護されます。一方、アクティブでないコンポーネントのみからなるプロセスは、それが消費しているメモリが他のプロセスで必要になった場合は、いつでも強制終了される可能性があります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (99,1,1,'Intent を受信できないコンポーネントは、次のうちどれですか？','choices',4,1,NULL, 'ContentProvider はデータの保存等に使用しますが、 Intent による受信はできません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (100,1,1,'Android マーケットにアプリケーションのアップデートを公開する際の注意点として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'パッケージ名もプライベートキーもアップデート前と同じものを使用しなければなりません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (101,1,1,'Android で使用できる SQLite データベースによってサポートされていないデータ型は、次のうちどれですか？','choices',4,1,NULL, '「NULL」「INTEGER」「REAL」「TEXT」「BLOB」の5種類のデータ型がサポートされています。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (102,1,1,'Ul/Application Exerciser Monkey （モンキーツール） の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'Ul/Application Exerciser Monkey は発生間隔を指定してランダムにイベントを発生させることが出来るため、ストレステストとしてバグの発見に利用できます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (103,1,1,'AndroidManifest.xml の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'AndroidManifest.xml が存在しない場合、コンパイルエラーになります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (104,1,1,'Android マーケットに公開されたアプリケーションを更新する方法として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'アプリケーションの更新をアップロードする前に、マニフェストファイルの 要素にある android:versionCode と android:versionName 属性を、必ずインクリメントする必要があります。 また、パッケージ名は同じなければならず、.apk は同じプライベートキーで署名されなければなりません。パッケージ名と署名された証明書が既存のバージョンのものと一致しない場合は、マーケットは新しいアプリケーションと見なし、ユーザにアップデートが提供されなくなってしまいます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (105,1,1,'現在のアクティビティから別のアクティビティに変えるときに使われるクラスとして正しいものは、次のうちどれですか？','choices',4,1,NULL, '解説：AndroidではIntentオブジェクトを使用し、Activityから他のActivityを起動することができます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (106,1,1,'Activity の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'onRestart()は、onStop()の呼び出し後、現在のアクティビティが再表示されたとき（ユーザがそこにバックしたとき）に呼び出されますが、onRestart()の呼び出し後に引き続き onStart()、onResume()が呼び出されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (107,1,1,'Android システムを起動すると表示されるロゴ、initlogo.rle は、rgb2565 で変換されます。変換前の元のフォーマットは、次のうちどれですか？','choices',4,1,NULL, 'rawファイルが rgb2565 で変換可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (108,1,1,'ListView の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'TextView 以外にも、一意に定義された View のリストを表示が可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (109,1,1,'Android ライセンスフォームの説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'ソースコードを公開しなくてもライセンス違反にはなりません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (110,1,1,'以下のコードが実行され、ボタンが押されたときの反応として正しいものは、次のうちどれですか？(ソースコードの環境と構成は正しいものとします。) \n--------------------------------------------------------\n01: public class Buttonclick extends Activity implements View.OnClickListener { \n02:\n03:    Button button; \n04:\n05:    @Override\n06:    public void onCreate(Bundle savedInstanceState) { \n07:      super.onCreate(savedInstanceState);\n08:\n09:      LinearLayout layout = new LinearLayout(this); \n10:      layout.setOrientation(LinearLayout.HORIZONTAL); \n11:      setContentView(layout);\n12:\n13:      button = new Button(this); \n14:      button.setText("Button");\n15:      button.setLayoutParams(new LinearLayout.LayoutParams(\n16:             LinearLayout.LayoutParams.WRAP_CONTENT,\n17:             LinearLayout.LayoutParams.WRAP_CONTENT)); \n18:      layout.addView(button);\n19:      }\n20:\n21:    @Override\n22:    public void onClick (View v) { \n23:      if (v == button) {\n24:         Toast.makeText(this,"Touch1", Toast.LENGTH_LONG).show();\n25:      }\n26:      else {\n27:         Toast.makeText(this, "Touch2", Toast.LENGTH_LONG).show();\n28:      }\n29:    }\n30: }\n--------------------------------------------------------','choices',4,1,NULL, 'Activity は onClick イベントを返却しません。\n問題の場合では、 button.setOnClickListener(this) と記述した場合には、ボタンを押下した際に onClick イベントを返却します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (111,1,1,'Android が備える標準 ContentProvider でないものは、次のうちどれですか？','choices',4,1,NULL, 'ブックマークは Browser クラスを使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (112,1,1,'MediaPlayer クラスのインスタンスを取得するコードは、次のうちどれですか？','choices',4,1,NULL, '全ての回答で this を使用しているため Activity クラス内での記述が前提となっています。\nインスタンスの取得には create メソッドを使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (113,1,1,'オーディオファイルの再生にあたって、『Android 開発ガイド』が推奨するファイルの保存場所はどこでしょう？','choices',4,1,NULL, '/res/rawに配置することで、自動的にリソースIDが採番されるため、ファイルの呼び出し時に利用できます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (114,1,1,'SQLite データベース管理に関する説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, 'アプリケーションがデータベースファイルを所有しています。\nAndroidManifest.xml の設定で他のアプリケーションにデータベースを公開することが可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (115,1,1,'開発中にエミュレーターを使って実行できない処理は、次のうちどれですか？','choices',4,1,NULL, 'E メールの受信が実行できません。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (116,1,1,'dx の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'dx は、.class ファイルから、Android バイトコードを生成してくれるツールです。このツールは、複数の対象のファイル ( または複数のディレクトリ ) を、Dalvik 実行可能フォーマット ( .dex ) に変換し、それにより、それらが Android 環境で実行可能となります。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (117,1,1,'ライフサイクルがないのは、次のうちどれですか？','choices',4,1,NULL, 'ContentProvider以外のものに関しては、それぞれ異なるステータスですがライフサイクルが存在します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (118,1,1,'SQLite データベースを作成して使用するためのプロシージャとして正しいものは、次のうちどれですか？','choices',4,1,NULL, 'SQLiteOpenHelperを使用してデータベースを作成する場合、本クラスは、abstract（抽象）クラスなので、以下のコールバックを実装する必要があります。\n\nonCreate() メソッド　・・・　データベースを作成したタイミングで呼び出されるメソッドです。通常はここでテーブルを作成します。\nonUpgrade() メソッド　・・・　データベースをバージョンアップしたタイミングで呼び出されるメソッドです。通常はここでデータのコンバートなどを行います。\n\nその後、実装したSQLiteOpenHelperのサブクラスのインスタンスを生成し、当インスタンスのgetWritableDatabase()メソッドを使うことにより、データベースをオープンすることができます。\nなお、読み取り専用でいいときは、getReadableDatabase()でも使用できます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (119,1,1,'Android の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, '携帯デバイスのプラットフォームを主なターゲットとしていますが、他の携帯デバイス以外でも使用が可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (120,1,1,'暗黙的 Intent の説明として正しいものは、次のうちどれですか？','choices',4,1,NULL, '暗黙的Intentは、所定の動作（たとえばブラウザを起動）のみ指定してアプリケーションを起動します。\n起動される側のアプリケーションは、反応したいイベント（ブラウザでURLを表示する、というAction）に対して返事をします。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (121,1,1,'以下のAndroidManifest.xml コンテンツの記述として間違っているものは、次のうちどれですか？ \n--------------------------------------------------------\n01: xml version="1.0" encodings="utf-8"?>\n02: <manifest xmlns:android="http://schemas.android.com/apk/res/android"\n03:     package="jp.oesf.sample"\n04:     android:versionCode="1"\n05:     android:versionName="1.01">\n06:   <application android:icon="@drawable/icon" android:label="@string/app_name"> \n07:      <activity android:name=".MainActivity" >\n08:         <intent-filter>\n09:            <action android:name="android.intent.action.MAIN" />\n10:            <category android:name="android.intent.category.LAUNCHER" />\n11:         intent-filter>\n12:      activity>\n13:   application>\n14:   <uses-sdk android:minSdkVersion="3" />\n15: manifest>\n--------------------------------------------------------','choices',4,1,NULL, '「android:label」はアプリケーションタグに設定することで、アプリケーションのヘッダーに設定した文字が表示されます。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (122,1,1,'ASE (Android Scripting Environment) の説明として間違っているものは、次のうちどれですか？','choices',4,1,NULL, 'ASE では直接スクリプトやインタプリタの編集や新規作成が可能です。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (123,1,1,'接続要求、接続受付、およびデータ転送などの Bluetooth 通信を実行するために必要な承認は、次のうちどれですか？','choices',4,1,NULL, '接続要求、接続受付、およびデータ転送などは BLUETOOTH 、デバイス起動や設定変更などは BLUETOOTH_ADMIN を使用します。');
@@
INSERT INTO QUESTION (question_id,course_id,category_id,question,pattern,choices,answers,chart_source,explanation) VALUES (124,1,1,'標準インストールされたアドレス帳からデータを読み込むために必要なマニフェストファイルの権限は、次のうちどれですか？','choices',4,1,NULL, 'READ_CONTACTS にてアドレス帳からデータを取得する。なお、READ_ADDRESS_DATA という権限は存在しない。');
