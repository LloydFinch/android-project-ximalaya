package com.venn.zhufengfm.app.uitl;

import android.util.Log;
import com.venn.zhufengfm.app.BuildConfig;

/**
 * Created by VennUser on 2015/7/31.
 */

//封装Android的Log工具,能够增加日志的开关
public final class MyLog {


	//通过控制常量的值来控制是否打印日志

	//日志的开关通常在Release(发布软件包)时关闭
	//BuildConfig可以自动根据当前环境来设置DEBUG的值
	private static final boolean ON = BuildConfig.DEBUG;


	private static final boolean DEBUG = true;
	private static final boolean INFO = true;

	private MyLog() {}

	public static void d(String tag, String msg) {

		if (ON && DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {

		if (ON && INFO) {
			Log.i(tag, msg);
		}
	}
}
