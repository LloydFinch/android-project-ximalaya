package com.venn.zhufengfm.app.tasks;

import com.venn.zhufengfm.app.client.ClientJSONAPI;
import com.venn.zhufengfm.app.uitl.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendTask extends BaseTask {

	public DiscoverRecommendTask(TaskCallback taskCallback) {
		super(taskCallback);
	}

	protected TaskResult doInBackground(String... params) {
		TaskResult result = new TaskResult();
		result.setTaskId(Constants.TASK_DISCOVER_RECOMMEND);
		String recommends = ClientJSONAPI.getDiscoverRecommends();
		try {
			JSONObject jsonObject = new JSONObject(recommends);
			result.setData(jsonObject);
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
}
