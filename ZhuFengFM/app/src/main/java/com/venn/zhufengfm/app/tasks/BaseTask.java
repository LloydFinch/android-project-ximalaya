package com.venn.zhufengfm.app.tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;

/**
 * Created by VennUser on 2015/7/28.
 */

//抽象异步任务类
public abstract class BaseTask extends AsyncTask<String, Integer, TaskResult> {

	protected TaskCallback taskCallback;

	public BaseTask(TaskCallback taskCallback) {
		this.taskCallback = taskCallback;
	}

	protected TaskResult doInBackground(String... params) {
		return null;
	}

	protected void onPostExecute(TaskResult taskResult) {

		if (taskCallback != null) {
			taskCallback.onTaskFinished(taskResult);
		}
	}
}
