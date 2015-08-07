package com.venn.zhufengfm.app.tasks.impl;

import com.venn.zhufengfm.app.client.ClientJSONAPI;
import com.venn.zhufengfm.app.tasks.BaseTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.Constants;
import com.venn.zhufengfm.app.uitl.MyLog;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/8/5.
 */
public class AlbumDetailTask extends BaseTask {
	public AlbumDetailTask(TaskCallback taskCallback) {
		super(taskCallback);
	}

	protected TaskResult doInBackground(String... params) {
		TaskResult result = new TaskResult();

		String ret = params[0];
		result.setTaskId(Constants.TASK_ALBUM_DETAIL);
		String album = ClientJSONAPI.getAlbumDetail(ret);
		try {
			if (album != null) {
				JSONObject json = new JSONObject(album);
				result.setData(json);
			} else {
				MyLog.d("TaskResult doInBackground", "album is null");
			}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
}
