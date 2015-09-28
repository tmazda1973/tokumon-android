package jp.thinkware.tokumon.app.activities;

import jp.thinkware.tokumon.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * @author noda
 *
 */
public class CourseMenuActivity extends KaidenBaseActivity {

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course_menu);

		// 開始画面遷移のダミーボタン（後で削除）
		Button btnExamStart = (Button) this.findViewById(R.id.go_exam_start);
		btnExamStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(CourseMenuActivity.this, ExamStartActivity.class);
				startActivity(intent);
			}
		});

		// メインメニューに戻るダミーボタン（後で削除）
		Button btnPrevMainMenu = (Button) this.findViewById(R.id.prev_main_menu);
		btnPrevMainMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				finish();
			}
		});

	}

}
