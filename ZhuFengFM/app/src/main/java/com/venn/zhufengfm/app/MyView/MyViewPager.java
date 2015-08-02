package com.venn.zhufengfm.app.MyView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by VennUser on 2015/8/1.
 */
public class MyViewPager extends ViewPager {
	public MyViewPager(Context context) {
		super(context);
	}

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public boolean dispatchTouchEvent(MotionEvent ev) {

		//让父类不拦截触屏事件
		getParent().requestDisallowInterceptTouchEvent(true);

		return super.dispatchTouchEvent(ev);
	}
}
