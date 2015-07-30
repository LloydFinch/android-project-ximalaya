package com.venn.zhufengfm.app.fragments.discover;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venn.zhufengfm.app.R;

//发现的推荐部分上方滑动的图片内容
public class DiscoverRecommendFocusImageFragment extends Fragment {


	public DiscoverRecommendFocusImageFragment() {

	}


	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_discover_recommend_focus_image, container, false);

		return view;
	}


}
