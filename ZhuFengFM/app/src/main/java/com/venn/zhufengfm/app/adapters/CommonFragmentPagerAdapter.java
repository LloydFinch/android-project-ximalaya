package com.venn.zhufengfm.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by VennUser on 2015/7/29.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter{

	private List<Fragment> fragmentList;

	public CommonFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
	}

	public Fragment getItem(int position) {
		return fragmentList.get(position);
	}

	public int getCount() {
		return fragmentList.size();
	}
}
