package com.venn.zhufengfm.app.fragments.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.Test1Activity;

public class DiscoverRecommendFragment extends Fragment implements View.OnClickListener {

	public DiscoverRecommendFragment() {
		// Required empty public constructor
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_discover_recommend, container, false);
		Button button = (Button) view.findViewById(R.id.start);
		button.setOnClickListener(this);
		return view;
	}

	//给Activity的进入退出添加动画
	public void onClick(View v) {
		FragmentActivity context = getActivity();
		Intent intent = new Intent(context, Test1Activity.class);
		context.startActivity(intent);
	}
}
