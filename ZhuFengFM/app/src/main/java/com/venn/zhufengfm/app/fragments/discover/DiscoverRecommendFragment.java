package com.venn.zhufengfm.app.fragments.discover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.adapters.CommonFragmentPagerAdapter;
import com.venn.zhufengfm.app.fragments.DiscoverFragment;
import com.venn.zhufengfm.app.model.discover.recommend.DiscoverRecommend;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.DiscoverRecommendTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.Constants;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DiscoverRecommendFragment extends Fragment implements AdapterView.OnItemClickListener, TaskCallback {

	private FragmentActivity activity;
	private DiscoverRecommend discoverRecommend;

	public DiscoverRecommendFragment() {
		// Required empty public constructor
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_discover_recommend, container, false);

		ListView listView = (ListView) view.findViewById(R.id.discover_recommend_list);

		activity = getActivity();
		if (listView != null) {
			List<String> stringList = new ArrayList<String>();
			for (int i = 0; i < 50; i++) {
				stringList.add("Android: " + i);
			}
			//listView.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, stringList));
			//listView.setOnItemClickListener(this);
		}

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
			Log.d("------------->", "discoverRecommend: " + discoverRecommend.toString());
		}
	}
}
