package com.venn.zhufengfm.app.tasks.impl;

import com.venn.zhufengfm.app.client.ClientDiscoverAPI;
import com.venn.zhufengfm.app.tasks.BaseTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/28.
 */
public class CategoryTagMenuTask extends BaseTask {

	TaskResult taskResult = new TaskResult();

	public CategoryTagMenuTask(TaskCallback taskCallback) {
		super(taskCallback);
	}

	protected TaskResult doInBackground(String... params) {
		taskResult.setTaskId(Constants.TASK_CATEGORY_TAG_MENU);

		String type = null;

		if (params != null && params.length > 0) {
			type = params[0];
		}
		String str = ClientDiscoverAPI.getCategoryTagMenu(type);

		if (str != null) {
			try {
				taskResult.setData(new JSONObject(str));
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return taskResult;
	}

	protected void onPostExecute(TaskResult taskResult) {
		super.onPostExecute(taskResult);
	}
}
