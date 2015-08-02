package com.venn.zhufengfm.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by VennUser on 2015/8/1.
 */
public class MyViewPagerAdapter extends PagerAdapter {

	private List<ImageView> imageViewList;

	public MyViewPagerAdapter(List<ImageView> imageViewList) {
		this.imageViewList = imageViewList;
	}

	public int getCount() {
		return imageViewList.size();
	}

	public boolean isViewFromObject(View view, Object o) {
		return view == o;
	}

	public Object instantiateItem(ViewGroup container, int position) {

		((ViewPager) container).addView(imageViewList.get(position));
		return imageViewList.get(position);
	}

	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView(imageViewList.get(position));
	}
}
