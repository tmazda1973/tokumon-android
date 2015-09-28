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
public class MainMenuActivity extends KaidenBaseActivity {

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		// コースメニュー遷移のダミーボタン（後で削除）
		Button btnCourseMenuDummy = (Button) this.findViewById(R.id.go_course_menu);
		btnCourseMenuDummy.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(MainMenuActivity.this, CourseMenuActivity.class);
				startActivity(intent);
			}
		});
	}
}
