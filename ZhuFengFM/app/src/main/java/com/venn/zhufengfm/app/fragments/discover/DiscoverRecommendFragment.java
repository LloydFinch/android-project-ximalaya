package com.venn.zhufengfm.app.fragments.discover;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.venn.zhufengfm.app.activity.AlbumDetailActivity;
import com.venn.zhufengfm.app.activity.GuideActivity;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.adapters.DiscoverRecommendAdapter;
import com.venn.zhufengfm.app.model.discover.recommend.DiscoverRecommend;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.DiscoverRecommendTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.Constants;
import org.json.JSONObject;

public class DiscoverRecommendFragment extends Fragment implements AdapterView.OnItemClickListener, TaskCallback,
		View.OnClickListener, ViewPager.OnPageChangeListener {

	private FragmentActivity activity;
	private DiscoverRecommend discoverRecommend;
	private DiscoverRecommendAdapter adapter;
	private PullToRefreshListView listView;
	private static ViewPager viewPager;
	private static ImageView focusImageView;
	private Animator animator;

	public DiscoverRecommendFragment() {
		// Required empty public constructor
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		activity = getActivity();
		View view = inflater.inflate(R.layout.fragment_discover_recommend, container, false);

		listView = (PullToRefreshListView) view.findViewById(R.id.discover_recommend_list);
		listView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

		//listView = (ListView) view.findViewById(R.id.discover_recommend_list);
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
			}
		}
	}

	public void onClick(View view) {
		String s = (String) view.getTag();
		int id = view.getId();
		if (view instanceof TextView) {
			switch (id) {
				case R.id.item_dis_rec_more:
					startActivity(new Intent(activity, AlbumDetailActivity.class));
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
	public void onPageScrolled(int pre, float v, int post) {

	}

	public void onPageSelected(int position) {

		animator = AnimatorInflater.loadAnimator(activity, R.animator.animator_focus_image_slide);
		animator.setTarget(focusImageView);
		//focusImageView.setLeft(0);
		switch (position) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				if (focusImageView != null) {
					animator.start();
				}
				break;
			case 5:
				break;
			default:
				break;
		}
	}

	public void onPageScrollStateChanged(int position) {

	}

	public static void setView(ImageView focusImage, ViewPager viewP) {
		focusImageView = focusImage;
		viewPager = viewP;
	}
}
