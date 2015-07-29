package com.venn.zhufengfm.app.uitl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.test.mock.MockPackageManager;

/**
 * Created by VennUser on 2015/7/29.
 */

//软件包工具类,获取版本号等信息
public final class PackageUtil {
	private PackageUtil() {

	}

	public static String getPackageVersionName(Context context) {
		String versionName = "1.0";

		if (versionName != null) {
			PackageManager manager = context.getPackageManager();

			//获取当前软件包的package信息
			PackageInfo info = null;
			try {
				info = manager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
			}
			catch (PackageManager.NameNotFoundException e) {
				e.printStackTrace();
			}
			versionName = info.versionName;
		}

		return versionName;
	}
}
