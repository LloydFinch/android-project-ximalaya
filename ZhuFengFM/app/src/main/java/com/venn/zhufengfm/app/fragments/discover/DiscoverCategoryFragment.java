package com.venn.zhufengfm.app.fragments.discover;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.data.DataStore;
import com.venn.zhufengfm.app.model.discover.DiscoverCategory;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.DiscoverCategoryTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.Constants;
import org.json.JSONObject;

import java.util.List;

//发现的分类部分
public class DiscoverCategoryFragment extends Fragment implements TaskCallback {


	private List<DiscoverCategory> discoverCategoryList;

	public DiscoverCategoryFragment() {
		// Required empty public constructor
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		//判断有没有分类
		List<DiscoverCategory> categories = DataStore.getInstance().getDiscoverCategories();
		if (categories != null && !categories.isEmpty()) {

		} else {
			DiscoverCategoryTask task = new DiscoverCategoryTask(this);
			task.execute();
		}
		return inflater.inflate(R.layout.fragment_discover_category, container, false);
	}


	public void onTaskFinished(TaskResult result) {
		if (result != null) {
			Object data = result.getData();
			if (result.getTaskId() == Constants.TASK_DISCOVER_CATEGORY) {
				if (data != null && data instanceof JSONObject) {
					discoverCategoryList = DataParser.parseDiscoverCategory((JSONObject) data);
				}
			}
		}
	}
}
