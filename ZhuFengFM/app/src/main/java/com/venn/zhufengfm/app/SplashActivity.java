package com.venn.zhufengfm.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import com.venn.zhufengfm.app.model.CategoryTagMenu;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.tasks.impl.CategoryTagMenuTask;
import com.venn.zhufengfm.app.uitl.TaskConstants;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

//启动扉页,程序入口点
public class SplashActivity extends Activity implements TaskCallback {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_splash);
	}

	protected void onResume() {
		super.onResume();

		//启动扉页,进行网络检测与网络请求,下载数据,最终显示主界面

		CategoryTagMenuTask categoryTagMenuTask = new CategoryTagMenuTask(this);

		String string = null;
		categoryTagMenuTask.execute(string);
	}

	public void onTaskFinished(TaskResult result) {
		if (result != null) {
			int taskId = result.getTaskId();
			Object data = result.getData();

			Log.d("---------->", "data: " + (data.toString()));

			if (taskId == TaskConstants.TASK_CATEGORY_TAG_MENU) {

				List<CategoryTagMenu> categoryTagMenuList = null;
				categoryTagMenuList = DataParser.parseCategoryTagMenu((JSONObject) data);

				Log.d("--------->", categoryTagMenuList.toString());
			}
		}
	}
}
