package com.venn.zhufengfm.app.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.adapters.CommonFragmentPagerAdapter;
import com.venn.zhufengfm.app.fragments.discover.*;
import com.venn.zhufengfm.app.model.discover.DiscoverTab;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.DiscoverTabTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.Constants;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment implements View.OnClickListener, TabLayout.OnTabSelectedListener,
		TaskCallback {

	private ViewPager viewPager;

	//子栏目的tab指示器
	private TabLayout tabBar;
	private static List<DiscoverTab> discoverTabList;
	private List<Fragment> fragmentList;

	public DiscoverFragment() {
		// Required empty public constructor
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		discoverTabList = new ArrayList<DiscoverTab>();
		fragmentList = new ArrayList<Fragment>();
		View view = inflater.inflate(R.layout.fragment_discover, container, false);
		View btnSearch = view.findViewById(R.id.discover_button_search);
		if (btnSearch != null) {
			btnSearch.setOnClickListener(this);
		}

		tabBar = (TabLayout) view.findViewById(R.id.discover_tab_bar);

		//TabBar的数据从网络获取

		tabBar.setOnTabSelectedListener(this);

		viewPager = (ViewPager) view.findViewById(R.id.discover_pager);

		//ViewPager滑动监听器:TabLayout.onPagerChangeListener()
		//可以实现联动
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabBar));

		DiscoverTabTask discoverTabTask = new DiscoverTabTask(this);
		discoverTabTask.execute();

		return view;
	}

	public void onClick(View v) {

	}

	//以下为tab选中的三个方法,使用类似Actionbar
	public void onTabSelected(TabLayout.Tab tab) {
		int position = tab.getPosition();
		viewPager.setCurrentItem(position);
	}

	public void onTabUnselected(TabLayout.Tab tab) {

	}

	public void onTabReselected(TabLayout.Tab tab) {
		//TODO 刷新操作
	}

	public void onTaskFinished(TaskResult result) {
		if (result != null) {
			Object data = result.getData();
			if (result.getTaskId() == Constants.TASK_DISCOVER_TAB) ;
			if (data != null && data instanceof JSONObject) {
				JSONObject jsonObject = (JSONObject) data;
				discoverTabList = DataParser.parseDiscoverTab(jsonObject);
				updateTabs();
			} else {
				//TODO 其他操作
			}
		}
	}

	private void updateTabs() {
		if (discoverTabList != null) {
			for (DiscoverTab tab : discoverTabList) {
				tabBar.addTab(tabBar.newTab().setText(tab.getTitle()));

				//根据内容来加载指定的Fragment
				String type = tab.getContentType();
				if ("recommend".equals(type)) {
					fragmentList.add(new DiscoverRecommendFragment());
				} else if ("category".equals(type)) {
					fragmentList.add(new DiscoverCategoryFragment());
				} else if ("live".equals(type)) {
					fragmentList.add(new DiscoverLiveFragment());
				} else if ("ranking".equals(type)) {
					fragmentList.add(new DiscoverRankingFragment());
				} else if ("anchor".equals(type)) {
					fragmentList.add(new DiscoverAnchorFragment());
				}
			}

			CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(getChildFragmentManager(),
					fragmentList);
			viewPager.setAdapter(adapter);
		}
	}
}
