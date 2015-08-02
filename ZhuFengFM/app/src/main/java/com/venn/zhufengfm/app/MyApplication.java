package com.venn.zhufengfm.app;

import android.app.Application;
import com.venn.zhufengfm.app.cache.FileCache;

/**
 * Created by VennUser on 2015/7/31.
 */
public class MyApplication extends Application {
	public void onCreate() {
		super.onCreate();
		FileCache.createInstance(getApplicationContext());
	}
}
