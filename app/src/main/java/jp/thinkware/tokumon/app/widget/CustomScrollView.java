package jp.thinkware.tokumon.app.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * 画面コンポーネントの独自ビュークラスです。(スクロールビュー)
 * @author thinkware
 */
public class CustomScrollView extends ScrollView {

	/**
	 * コンストラクタ
	 * @param context
	 * @see android.widget.ScrollView#ScrollView(Context)
	 */
	public CustomScrollView(Context context) {
		super(context);
	}

	/**
	 * コンストラクタ
	 * @param context
	 * @param attrs
	 * @see android.widget.ScrollView#ScrollView(Context, AttributeSet)
	 */
	public CustomScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * コンストラクタ
	 * @param context
	 * @param attrs
	 * @param defStyle
	 * @see android.widget.ScrollView#ScrollView(Context, AttributeSet, int)
	 */
	public CustomScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// 親アクティビティのタッチイベントを実行する
		((Activity)(this.getContext())).onTouchEvent(ev);

		final int action = ev.getAction();
		switch (action & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_MOVE: {
				if ( this.canScroll() ) {
					//スクロール可能な場合は既定の処理を実施
					return super.onTouchEvent(ev);
				} else {
					return false;
				}
			}

			case MotionEvent.ACTION_DOWN: {
				// 処理終了
				return super.onTouchEvent(ev);
			}

			case MotionEvent.ACTION_CANCEL:
			case MotionEvent.ACTION_UP:
				return super.onTouchEvent(ev);
			case MotionEvent.ACTION_POINTER_UP:
				return super.onTouchEvent(ev);
		}

		// 処理終了
		return super.onTouchEvent(ev);
	}

//	/**
//	 * @see android.widget.ScrollView#onInterceptTouchEvent(MotionEvent)
//	 */
//	@Override
//	public boolean onInterceptTouchEvent(MotionEvent ev) {
//
//		// 親アクティビティのタッチイベントを実行する
//		((Activity)(this.getContext())).onTouchEvent(ev);
//
//		final int action = ev.getAction();
//		switch (action & MotionEvent.ACTION_MASK) {
//			case MotionEvent.ACTION_MOVE: {
//				if ( this.canScroll() ) {
//					//スクロール可能な場合は既定の処理を実施
//					return super.onInterceptTouchEvent(ev);
//				} else {
//					return false;
//				}
//			}
//
//			case MotionEvent.ACTION_DOWN: {
//				// 処理終了
//				return super.onInterceptTouchEvent(ev);
//			}
//
//			case MotionEvent.ACTION_CANCEL:
//			case MotionEvent.ACTION_UP:
//				return super.onInterceptTouchEvent(ev);
//			case MotionEvent.ACTION_POINTER_UP:
//				return super.onInterceptTouchEvent(ev);
//		}
//
//		// 処理終了
//		return super.onInterceptTouchEvent(ev);
//	}

	/**
	 * スクロールが可能であるかを判定します。
	 * @return true 可能である, false 可能ではない
	 */
	protected boolean canScroll() {
		View child = this.getChildAt(0);
		if (child != null) {
			int childHeight = child.getHeight();
			return this.getHeight() < childHeight + this.getPaddingTop() + this.getPaddingBottom();
		}
		return false;
	}
}
