package com.venn.zhufengfm.app.fragments.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.venn.zhufengfm.app.BaseActivity;
import com.venn.zhufengfm.app.GuideActivity;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.adapters.CommonFragmentPagerAdapter;
import com.venn.zhufengfm.app.adapters.DiscoverRecommendAdapter;
import com.venn.zhufengfm.app.adapters.GuideAdapter;
import com.venn.zhufengfm.app.fragments.DiscoverFragment;
import com.venn.zhufengfm.app.model.discover.recommend.DiscoverRecommend;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.DiscoverRecommendTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.Constants;
import com.venn.zhufengfm.app.uitl.MyLog;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DiscoverRecommendFragment extends Fragment implements AdapterView.OnItemClickListener, TaskCallback,
		View.OnClickListener, ViewPager.OnPageChangeListener {

	private FragmentActivity activity;
	private DiscoverRecommend discoverRecommend;
	private DiscoverRecommendAdapter adapter;
	private ListView listView;
	private static ImageView focusImageView;

	public DiscoverRecommendFragment() {
		// Required empty public constructor
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_discover_recommend, container, false);

		listView = (ListView) view.findViewById(R.id.discover_recommend_list);

		activity = getActivity();

		DiscoverRecommendTask task = new DiscoverRecommendTask(this);
		task.execute();
		return view;
	}

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}

	public void onTaskFinished(TaskResult result) {
		if (result.getTaskId() == Constants.TASK_DISCOVER_RECOMMEND) {
			Object data = result.getData();
			discoverRecommend = DataParser.parseDiscoverRecommend((JSONObject) data);

			if (listView != null) {
				adapter = new DiscoverRecommendAdapter(activity, discoverRecommend, this, this);
				listView.setAdapter(adapter);
				//adapter.setRecommend(discoverRecommend);
			}
		}
	}

	public void onClick(View view) {
		String s = (String) view.getTag();
		int id = view.getId();
		if (view instanceof TextView) {
			switch (id) {
				case R.id.item_dis_rec_more:
					startActivity(new Intent(activity, GuideActivity.class));
					break;
			}
		} else if (view instanceof ImageView) {

			Toast.makeText(activity, "点击了图片", Toast.LENGTH_SHORT).show();
			switch (id) {

				//TODO 点击了图片

			}
		}
	}


	//顶部滑动广告的处理
	public void onPageScrolled(int i, float v, int i1) {

	}

	public void onPageSelected(int position) {
		Animation animation = AnimationUtils.loadAnimation(activity, R.anim.anim_focus_slide);
		Animation initAnimation = AnimationUtils.loadAnimation(activity, R.anim.anim_focus_init);
		switch (position) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				if (focusImageView != null) {
					focusImageView.startAnimation(animation);
				}
				break;
			case 5:
				if (focusImageView != null) {
					focusImageView.startAnimation(initAnimation);
				}
				break;
			default:
				break;
		}
	}

	public void onPageScrollStateChanged(int position) {

	}

	public static void setFocusImageView(ImageView focusImage) {
		focusImageView = focusImage;
	}
}
