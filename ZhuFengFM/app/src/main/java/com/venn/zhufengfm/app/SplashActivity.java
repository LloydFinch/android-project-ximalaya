package com.venn.zhufengfm.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import com.venn.zhufengfm.app.model.CategoryTagMenu;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.tasks.impl.CategoryTagMenuTask;
import com.venn.zhufengfm.app.uitl.Constants;
import com.venn.zhufengfm.app.uitl.PackageUtil;
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

			if (taskId == Constants.TASK_CATEGORY_TAG_MENU) {

				List<CategoryTagMenu> categoryTagMenuList = null;
				categoryTagMenuList = DataParser.parseCategoryTagMenu((JSONObject) data);

				Log.d("--------->", categoryTagMenuList.toString());
			}

			SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
			String lastVersionName = sp.getString(Constants.SP_KEY_GUIDE_LAST_SHOW_VER, "");
			String versionName = PackageUtil.getPackageVersionName(this);
			Intent intent = null;
			if (!lastVersionName.equals(versionName)) {

				//show Guide page
				intent = new Intent(this, GuideActivity.class);
			} else {

				//show main page
				intent = new Intent(this, MainActivity.class);
			}

			//可以清空任务栈
			//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intent);
			finish();
		}
	}
}
