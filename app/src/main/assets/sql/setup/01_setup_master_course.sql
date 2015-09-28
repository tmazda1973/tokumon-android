-- コース情報
INSERT INTO COURSE
(
    course_id,
    course_code,
    course_name_us,
    course_name_ja,
    summary,
    description,
    exam_time,
    passing_score,
    question_count,
    regist_datetime
)
VALUES
(
    1,
    'OAO-001J',
    'Android Application Basic',
    ' Androidアプリケーション技術者認定試験ベーシック',
    'Androidアプリ開発者の実力を証明する資格試験。',
    'Android技術者認定試験制度は、フレームワークの共同開発などで、組み込み分野におけるAndroid利用を促進する一般社会団法人Open Embedded Software Foundation（以下OESF）が実施している資格認定制度です。応用製品が続々登場するなど、ニーズがますます高くなっているAndroidですが、登場から日が浅いこともあり、市場の急拡大に伴う技術者不足が懸念されています。Android技術者認定試験制度は、Android技術者のスキルを公的に認定し、この問題を解消することを目的として設けられました。',
    90,
    70,
    30,
    '2013-01-18'
);
