package com.venn.zhufengfm.app.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.venn.zhufengfm.app.R;

import java.util.List;

/**
 * Created by VennUser on 2015/7/29.
 */

//教程页的适配器
public class GuideAdapter extends PagerAdapter {

	private Context context;
	private List<Integer> images;
	private View.OnClickListener goOnClickListener;

	public void setGoOnClickListener(View.OnClickListener goOnClickListener) {
		this.goOnClickListener = goOnClickListener;
	}

	public GuideAdapter(Context context, List<Integer> images) {
		this.context = context;
		this.images = images;
	}

	public int getCount() {
		return images == null ? 0 : images.size();
	}

	public boolean isViewFromObject(View view, Object o) {

		//对于FragmentAdapter,o是Fragment,view与o的判断就不能直接view == o
		return view == o;
	}

	public Object instantiateItem(ViewGroup container, int position) {

		View view = null;
		int resId = images.get(position);
		if (position == images.size() - 1) {

			FrameLayout frameLayout = new FrameLayout(context);

			//设置图片
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(resId);
			ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT);
			imageView.setLayoutParams(layoutParams);
			frameLayout.addView(imageView);

			//设置按钮
			Button button = new Button(context);
			button.setText(R.string.guide_start_main);

			FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);

			//需要进行机型适配
			params.bottomMargin = 80;
			button.setLayoutParams(params);
			frameLayout.addView(button);
			button.setOnClickListener(goOnClickListener);

			//代码设置tag,没有id可以通过tag区分
			button.setTag("Go");

			view = frameLayout;
		} else {

			ImageView imageView = new ImageView(context);
			imageView.setImageResource(resId);
			FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT);
			imageView.setLayoutParams(layoutParams);
			view = imageView;
		}
		container.addView(view);
		return view;
	}

	public void destroyItem(ViewGroup container, int position, Object object) {
		if (object instanceof View) {
			container.removeView((View) object);
		}
	}
}
