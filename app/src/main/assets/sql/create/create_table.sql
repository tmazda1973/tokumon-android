-- 受験コース情報を格納。
-- コースを購入すると追加登録される。
CREATE TABLE course
(
	course_id integer DEFAULT 1 NOT NULL PRIMARY KEY AUTOINCREMENT,
	-- コース名を表すコード。3文字または4文字
	course_code text NOT NULL UNIQUE,
	course_name_us text NOT NULL,
	course_name_ja text NOT NULL,
	summary text,
	description text,
	exam_time integer DEFAULT 0 NOT NULL,
	-- 本試験の合格点。
	-- 0の場合は設けない
	passing_score integer DEFAULT 0 NOT NULL,
	-- 登録日時のタイムスタンプ
	question_count integer DEFAULT 0 NOT NULL,
	regist_datetime text NOT NULL
);

@@
-- 設問を分類するカテゴリ情報を格納。
CREATE TABLE question_category
(
	category_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	course_id integer DEFAULT 1 NOT NULL,
	category_name text NOT NULL,
	FOREIGN KEY (course_id)
	REFERENCES course (course_id)
);

@@
-- 設問を管理するテーブル。
-- 選択肢は下位のquestionテーブルを参照
CREATE TABLE question
(
	question_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	course_id integer DEFAULT 1 NOT NULL,
	category_id integer NOT NULL,
	question text NOT NULL,
	-- choises : 選択肢
	-- filling : 穴埋め
	-- describing : 記述
	pattern text DEFAULT 'choises' NOT NULL,
	-- 出題時に表示する選択肢の数。
	--
	choices integer DEFAULT 4 NOT NULL,
	-- 1つの設問に対する回答(チェック)数。
	answers integer DEFAULT 1 NOT NULL,
	-- ソース、図表データ。BLOB型
	chart_source BLOB,
	-- 設問に対する解説。
	explanation text,
	FOREIGN KEY (category_id)
	REFERENCES question_category (category_id)
);

@@
-- ユーザ情報を管理。
CREATE TABLE kaiden_user
(
	user_id integer NOT NULL,
	name text NOT NULL,
	PRIMARY KEY (user_id)
);

@@
-- 解答用紙。受験履歴を管理するテーブル。
-- 成績の他に受験中の設問No、残り時間も管理する。
CREATE TABLE answer_sheet
(
	record_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	user_id integer NOT NULL,
	course_id integer DEFAULT 1 NOT NULL,
	exam_datetime text NOT NULL,
	-- 試験の残り時間(秒)。
	-- 試験を中断した際に更新する。
	-- 再開時に取得してタイマーにセットする。
	time_limit integer NOT NULL,
	-- 最後に参照していた設問。
	-- answer_sheet.question_idを参照
	current_question integer DEFAULT NULL,
	-- 本テストの点数。
	score integer NOT NULL,
	question_count integer NOT NULL,
	answer_count integer NOT NULL,
	correct_count integer NOT NULL,
	-- 試験の実施状態を示す値。
	-- 0:未実施
	-- 1:実施中
	-- 2:中断中
	-- 3:終了
	--
	status integer DEFAULT 0 NOT NULL,
	FOREIGN KEY (user_id)
	REFERENCES kaiden_user (user_id),
	FOREIGN KEY (course_id)
	REFERENCES course (course_id)
);

@@
-- 受験するコース、問題の情報を格納。
-- 受験を開始する際に、course、questionから出題する問題を抽出し、本テーブルにセットする。
CREATE TABLE answer
(
	record_id integer NOT NULL,
	question_no integer NOT NULL,
	question_id integer NOT NULL,
	choices_1 integer,
	choices_2 integer,
	choices_3 integer,
	choices_4 integer,
	choices_5 integer,
	choices_6 integer,
	choices_7 integer,
	choices_8 integer,
	-- 解答内容。選択肢の場合は、選択肢IDを格納する。
	answer text,
	PRIMARY KEY (record_id, question_no),
	FOREIGN KEY (record_id)
	REFERENCES answer_sheet (record_id),
	FOREIGN KEY (question_id)
	REFERENCES question (question_id)
);

@@
-- 設問毎の選択肢を管理するテーブル。1設問の選択肢は最大8個までとする。
-- 回答フラグは設問毎に複数設定が可能で、その場合は全選択で正解となる。
CREATE TABLE choices
(
	question_id integer NOT NULL,
	choices_id integer NOT NULL,
	content text NOT NULL,
	-- 1:正解
	correct_flag integer DEFAULT 0 NOT NULL,
	PRIMARY KEY (question_id, choices_id),
	FOREIGN KEY (question_id)
	REFERENCES question (question_id)
);