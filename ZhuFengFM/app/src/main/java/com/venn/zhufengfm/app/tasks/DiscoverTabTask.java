package com.venn.zhufengfm.app.tasks;

import com.venn.zhufengfm.app.client.ClientDiscoverAPI;
import com.venn.zhufengfm.app.uitl.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/29.
 */

//发现栏目上方Tab获取
public class DiscoverTabTask extends BaseTask {

	public DiscoverTabTask(TaskCallback taskCallback) {
		super(taskCallback);
	}

	protected TaskResult doInBackground(String... params) {

		TaskResult result = new TaskResult();
		result.setTaskId(Constants.TASK_DISCOVER_TAB);

		String tabs = ClientDiscoverAPI.getDiscoverTabs();
		if (tabs != null) {
			try {
				result.setData(new JSONObject(tabs));
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
